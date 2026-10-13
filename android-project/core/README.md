# core — 模块化的核心层

从**单模块、11 个扁平文件**重构为**三个 Gradle 模块、29 个单职责文件**。

原来 `Models.kt` 一个文件装了 11 个类型、`Stores.kt` 装了 3 个 Store、`AiGateway.kt` 装了 5 个声明、`ReplyRepository.kt` 里内嵌了缓存与缓存键 —— 现在全部按职责拆开。

---

## 一、模块划分

```
core/
├── model/    :core:model     纯 Kotlin 数据模型     —— 11 个文件
├── domain/   :core:domain    纯 Kotlin 业务规则     —— 4 个文件（+4 个测试）
└── data/     :core:data      Android 数据层         —— 14 个文件（+3 个测试）
```

**划分依据是「变化的理由」和「依赖的重量」，不是文件长短。**

| 模块 | 职责 | 为什么单独成模块 | Android 依赖 |
| --- | --- | --- | --- |
| `:core:model` | 只描述**数据长什么样** | 全工程依赖的根；零依赖让它能被任何层引用，也让它永远不会成为编译瓶颈 | 无 |
| `:core:domain` | 只描述**业务规则怎么算** | 提示词、风格目录、安全词表、意图识别都是纯函数，改它们不该牵动任何 Android 代码 | 无 |
| `:core:data` | 只描述**数据从哪来、到哪去** | 唯一需要 `Context` / `Canvas` / `FileProvider` 的一层，把它隔离出来，上面两层才能跑纯 JVM 单测 | 有 |

依赖方向单向、无环：

```
:app ──▶ :core:data ──api──▶ :core:domain ──api──▶ :core:model
```

`model` 与 `domain` 用的是 `kotlin("jvm")` 而不是 `com.android.library` —— 因为它们一行 `android.*` 都没有，没必要背上 Android 插件。好处是 `./gradlew :core:domain:test` 不需要 Android SDK、不需要模拟器，几秒出结果。

---

## 二、拆分明细：旧文件 → 新文件

### `:core:model`（11 个类型 → 11 个文件）

旧 `domain/Models.kt`（176 行，11 个类型挤在一起）拆为：

| 新文件 | 类型 |
| --- | --- |
| `model/Scene.kt` | `Scene` |
| `model/Persona.kt` | `Persona` |
| `model/AppSettings.kt` | `AppSettings`（含 6 个常量） |
| `model/StylePreset.kt` | `StylePreset` |
| `model/ReplyRequest.kt` | `ReplyRequest` |
| `model/Reply.kt` | `Reply` |
| `model/ReplySource.kt` | `ReplySource` |
| `model/ReplyKey.kt` | `ReplyKey` |
| `model/GenState.kt` | `GenState` + `Idle` / `Loading` / `Done` / `Failed` |
| `model/QuotaState.kt` | `QuotaState` |
| `model/HistoryItem.kt` | `HistoryItem` |

### `:core:domain`（4 个对象 → 3 个子包）

| 旧文件 | 新文件 |
| --- | --- |
| `domain/StyleCatalog.kt` | `domain/style/StyleCatalog.kt` |
| `domain/PromptBuilder.kt` | `domain/prompt/PromptBuilder.kt` |
| `domain/LocalTemplateEngine.kt` | `domain/prompt/LocalTemplateEngine.kt` |
| `domain/SafetyFilter.kt` | `domain/safety/SafetyFilter.kt` |

### `:core:data`（6 个文件 → 4 个子包 / 14 个文件）

| 旧文件 | 拆出的新文件 |
| --- | --- |
| `data/AiGateway.kt`（5 个声明） | `ai/AiGateway.kt`（接口）<br>`ai/AiTimeouts.kt`（超时常量）<br>`ai/ChatCompletionsEndpoint.kt`（端点拼接）<br>`ai/JsonExtensions.kt`（`optNullableString`）<br>`ai/OpenAiCompatGateway.kt`（实现） |
| `data/ReplyRepository.kt` | `repository/ReplyRepository.kt`（编排）<br>`repository/ReplyCache.kt`（**新抽出**：访问序 LRU 缓存）<br>`repository/ReplyCacheKey.kt`（**新抽出**：七段缓存键算法） |
| `data/Stores.kt`（3 个 Store） | `storage/SettingsStore.kt`<br>`storage/PersonaStore.kt`<br>`storage/HistoryStore.kt` |
| `data/HistoryCodec.kt` | `storage/HistoryCodec.kt` |
| `data/HistoryMutations.kt` | `storage/HistoryMutations.kt` |
| `data/ShareCardRenderer.kt` | `share/ShareCardRenderer.kt` |

两处是**真的提取**，不是挪位置：

- `ReplyCache` —— 原来是一个内嵌在 `ReplyRepository` 里的匿名 `LinkedHashMap` 子类，现在是一个有明确边界的类，可以单独测容量淘汰与访问序。
- `replyCacheKey` —— 原来是 `ReplyRepository` 的私有方法 + 一个私有 `StringBuilder.field` 扩展，现在是一个独立函数，缓存失效条件可以单独断言。

### 一处**有意的包名变更**

类型从 `com.mouthpiece.app.domain` / `com.mouthpiece.app.data` 迁到了更细的子包（`…domain.prompt`、`…data.repository` 等）。`ReplyKey` 原本定义在 `vm/MainViewModel.kt`，语义上属于领域模型，归入 `model`。

> 包名变更不影响功能，但如果你已经写了引用旧包名的代码，需要改 import。`app/` 下的 Java 参考代码引用的是旧包名 —— 那份 Java 本来就不能编译（见 `../README.md`），不受影响。

---

## 三、重要：有 5 处工具输出与真实语义不符（已修正）

高层恢复（jadx 默认模式）在下面这些地方给出了**语义错误**的结果。我用字节码模式（`-m fallback`）逐条核对过，本实现按**字节码**恢复。

### ① `SafetyFilter.isOutputSafe` 的返回值语义

- ❌ 高层恢复：字面读会「永远返回 true」
- ✅ 真实逻辑：**安全返回 `true`**

```kotlin
fun isOutputSafe(text: String): Boolean {
    if (text.isBlank()) return false
    return blockedOutput.none { hitsRiskyWord(text, it) }
}
```

### ② `ReplyRepository` 的安全校验分支被写反

- ❌ 高层恢复：`if (isOutputSafe(clean)) throw IllegalStateException(...)`
- ✅ 真实逻辑：不安全才抛

```kotlin
check(SafetyFilter.isOutputSafe(cleaned)) { "内容未通过安全校验" }
```

### ③ `ReplyRepository` 的取消处理被写反

- ❌ 高层恢复：`if (e !is CancellationException) throw e`
- ✅ 真实逻辑：**只有** `CancellationException` 才重新抛出

这条很关键 —— 写反了的话，「换一批」取消上一次请求会变成静默吞掉取消信号。

### ④ `OpenAiCompatGateway` 的重试条件被写反

- ❌ 高层恢复：`if (code == 400 || !looksLikeUnsupportedReasoningParam(body))`
- ✅ 真实逻辑：两个条件都要满足

```kotlin
if (response.code == 400 && looksLikeUnsupportedReasoningParam(response.body)) {
    // 去掉 reasoning_effort 重试一次
}
```

### ⑤ `HistoryStore.flush()` 里有个锁 bug（已修）

原始字节码在 `tryLock(50ms)` **失败**时仍然无条件 `unlock()`，会抛 `IllegalMonitorStateException`。本实现改成拿不到锁就直接返回（交给防抖写入器处理）：

```kotlin
val acquired = runCatching { writeLock.tryLock(FLUSH_LOCK_TIMEOUT_MS, TimeUnit.MILLISECONDS) }
    .getOrDefault(false)
if (!acquired) return      // ← 原来的代码在这里会 unlock 一个没持有的锁
```

---

## 四、忠实恢复的几个细节

这些都是工具输出里**看不出来、但字节码里是明确的**，容易写错：

| 细节 | 真实值 | 为什么容易错 |
| --- | --- | --- |
| `StylePreset.temperature` 默认值 | **0.8** | 恢复在 4 个风格处打印 `0.0f` 占位（默认参数掩码 64 造成的假值） |
| `clean()` 的步骤顺序 | trim → 剥「回复：」前缀 → trim → 剥引号 → trim | 原实现就是这个顺序，换序会改变结果 |
| `AppSettings.watermark` 默认值 | **true** | 恢复里 `copy$default` 的 mask 语义与构造器相反，容易看反 |
| 缓存淘汰策略 | 访问序 LRU，上限 200 | `LinkedHashMap(accessOrder = true)` + `removeEldestEntry` |
| 缓存键格式 | `长度:值\|` 七段拼接 | 长度前缀是为了避免分隔符歧义 |
| 意图识别优先级 | APOLOGY → BLAME → INVITE → FLIRT → REQUEST → QUESTION → CHAT | 顺序即优先级，「你怎么又这样，对不起」判成 APOLOGY |
| 「约」字误报 | 回看前 1 个字符组成两字窗口，命中 13 个白名单词则跳过 | 否则「大约」「预约」「签约」都会误判成邀约 |
| 安全前缀豁免 | 回看命中位置**前 3 个字符**，以 16 个否定词结尾则不算命中 | 遍历该词**所有**出现位置，只要有一处没被豁免就算命中 |
| 历史落盘 | 500 ms 防抖 + 临时文件 → 备份 → 改名 的原子写 | |
| 配额跨天重置 | 每次读配额前对比 `quota_date` 与今天 | |

---

## 五、依赖

```kotlin
// :core:model   —— 无依赖（只用 Kotlin 标准库）
// :core:domain  —— api(project(":core:model"))
// :core:data    —— api(project(":core:domain"))
//                  api(libs.androidx.core.ktx)            // FileProvider
//                  api(libs.kotlinx.coroutines.android)   // StateFlow / suspend
```

都不依赖 Compose。`:core:model` 与 `:core:domain` 是纯 Kotlin（零 Android API），可以脱离设备直接跑 JVM 单元测试。

---

## 六、怎么用

### 编译

```bash
cd android-project

./gradlew :core:model:build :core:domain:build    # 不需要 Android SDK
./gradlew :core:data:assembleDebug                # 需要 Android SDK（compileSdk = 36）
```

### 在 app 里使用

`app/build.gradle.kts` 已加 `implementation(project(":core:data"))`，三层会一起带进来：

```kotlin
import com.mouthpiece.app.data.ai.OpenAiCompatGateway
import com.mouthpiece.app.data.repository.ReplyRepository
import com.mouthpiece.app.data.storage.SettingsStore
import com.mouthpiece.app.domain.style.StyleCatalog
import com.mouthpiece.app.model.ReplyRequest

val settings = SettingsStore(context)
val repository = ReplyRepository(
    settingsProvider = { settings.settings.value },
    ai = OpenAiCompatGateway { settings.settings.value },
)
```

### 组装整个应用

`ServiceLocator` 还没重写（它属于下一阶段）。照着原版写即可，原始 Java 在
`restored/source/com/mouthpiece/app/ServiceLocator.java`：

```kotlin
object ServiceLocator {
    private var ready = false
    lateinit var settings: SettingsStore; private set
    lateinit var personas: PersonaStore; private set
    lateinit var history: HistoryStore; private set
    lateinit var repository: ReplyRepository; private set
    lateinit var cardRenderer: ShareCardRenderer; private set

    private val sharedTextChannel = Channel<String>(Channel.BUFFERED)
    val sharedText: Flow<String> = sharedTextChannel.receiveAsFlow()

    fun init(context: Context) {
        if (ready) return
        val ctx = context.applicationContext
        settings = SettingsStore(ctx)
        personas = PersonaStore(ctx)
        history = HistoryStore(ctx)
        repository = ReplyRepository(
            settingsProvider = { settings.settings.value },
            ai = OpenAiCompatGateway { settings.settings.value },
        )
        cardRenderer = ShareCardRenderer(ctx)
        ready = true
    }

    fun emitSharedText(text: String) { sharedTextChannel.trySend(text) }
    fun flushHistory() { if (ready) history.flush() }
}
```

---

## 七、验证结果

不是「写完就交」，是真的编译并跑过了。

### 编译（按依赖顺序）

用 **Kotlin 2.1.20 编译器 + 真实 `android.jar`（API 36）+ androidx.core 1.16.0 + coroutines 1.8.0 + org.json**，`-jvm-target 17`：

```
:core:model   （零依赖）                        →  16 个 class，0 error
:core:domain  （classpath = model）             →   7 个 class，0 error
:core:data    （classpath = model+domain+API36）→  36 个 class，0 error
```

### 单元测试

```
:core:domain   4 个测试类   OK (58 tests)
:core:data     3 个测试类   OK (31 tests)
                           ─────────────
                    合计    OK (89 tests)
```

| 测试类 | 所在模块 | 用例数 | 覆盖 |
| --- | --- | --- | --- |
| `SafetyFilterTest` | `:core:domain` | 15 | 输入/输出校验、否定前缀豁免、回看窗口边界、黑名单精确短语特性 |
| `LocalTemplateEngineTest` | `:core:domain` | 18 | 7 类意图识别、优先级、「约」字误报、模板轮换、负 seed、`{他}` 替换 |
| `StyleCatalogTest` | `:core:domain` | 14 | 12 种风格完整性、**每个风格的 temperature 真实值**、场景分组、场景内选中判定 |
| `PromptBuilderTest` | `:core:domain` | 11 | system 结构、5 档强度、强度越界回退、人设段拼接与空值兜底、user 格式 |
| `ReplyCacheTest` | `:core:data` | 6 | **新增**：LRU 容量淘汰、访问序、clear、默认上限 200 |
| `ReplyCacheKeyTest` | `:core:data` | 11 | **新增**：七段任一变化都 miss、长度前缀消除歧义、trim 归一化 |
| `ReplyRepositoryTest` | `:core:data` | 14 | **新增**：兜底、缓存命中/绕过、安全拦截不进缓存、**取消透传**、输出清洗 |

`:core:data` 的这 31 个用例是本次重构的**回归保护** —— 它们断言的都是「抽出 `ReplyCache` / `ReplyCacheKey` 之前的行为」，证明拆分没有改变语义。

跑法：

```bash
cd android-project && ./gradlew :core:model:test :core:domain:test :core:data:test
```

### 测试过程中发现的两个事实

写测试时踩到两处**反直觉但确实如此**的行为，都是原实现的真实语义，已写进断言和 `../docs/05`：

1. **输入黑名单是 24 条精确短语，没有裸的「开盒」「人肉搜索」。** 所以「开盒」两个字不会被拦，只有「怎么开盒」「开盒教程」这类具体问法才拦。输出黑名单反而更宽（有裸的「开盒」「人肉」）。
2. **否定前缀必须紧贴命中词，回看窗口只有 3 个字符。** 所以「如何防范诈骗话术」**会被误杀**（窗口取到「何防范」而非「防」）—— 原实现并没有真正解决正常讨论被误杀的问题。

### 还没验证的部分

`storage/*` 和 `share/ShareCardRenderer` 依赖 `Context` / `SharedPreferences` / `Canvas` / `FileProvider`，
只做了编译验证（对着真实 android.jar 编译通过），**没有运行时验证**。
这两块建议在接上设备后补集成测试（Robolectric 或 instrumented test）。

`ai/OpenAiCompatGateway` 走真实 `HttpURLConnection`，同理只做了编译验证。
