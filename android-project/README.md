# android-project — 重建的 Gradle 工程（模块化结构）

这个目录下有**四个模块**，按职责分层，依赖方向单向向下。

| 模块 | 插件 | 内容 | 能否编译 |
| --- | --- | --- | --- |
| **`:core:model`** | `kotlin("jvm")` | 纯数据模型（11 个类型） | ✅ 纯 JVM，无需 Android SDK |
| **`:core:domain`** | `kotlin("jvm")` | 业务规则（风格目录 / 提示词 / 安全过滤 / 离线模板） | ✅ 纯 JVM，无需 Android SDK |
| **`:core:data`** | `com.android.library` | AI 网关 / 生成编排 / 持久化 / 分享卡片 | ✅ 需要 Android SDK |
| `:app` | `com.android.application` | 恢复出的源码（Java），UI / ViewModel / 推送层 | ❌ 不能，需按 Kotlin 重写 |

```
android-project/
├── settings.gradle.kts              include(":core:model", ":core:domain", ":core:data", ":app")
├── build.gradle.kts
├── gradle.properties
├── gradle/libs.versions.toml        依赖版本（全部来自 APK 实测）
│
├── core/
│   ├── README.md                    ← 模块划分、文件对照表、5 处工具输出错误修正、验证结果
│   │
│   ├── model/                       ★ 纯 Kotlin 数据模型（零 Android 依赖）
│   │   ├── build.gradle.kts
│   │   └── src/main/kotlin/com/mouthpiece/app/model/
│   │       ├── Scene.kt  Persona.kt  AppSettings.kt  StylePreset.kt
│   │       ├── ReplyRequest.kt  Reply.kt  ReplySource.kt  ReplyKey.kt
│   │       └── GenState.kt  QuotaState.kt  HistoryItem.kt
│   │
│   ├── domain/                      ★ 纯 Kotlin 业务规则（零 Android 依赖）
│   │   ├── build.gradle.kts
│   │   └── src/
│   │       ├── main/kotlin/com/mouthpiece/app/domain/
│   │       │   ├── style/StyleCatalog.kt            12 种风格（原文照录）
│   │       │   ├── prompt/PromptBuilder.kt          提示词组装
│   │       │   ├── prompt/LocalTemplateEngine.kt    离线兜底 + 意图识别
│   │       │   └── safety/SafetyFilter.kt           三层安全过滤
│   │       └── test/kotlin/com/mouthpiece/app/domain/  4 个测试类 / 58 用例
│   │
│   └── data/                        ★ Android 数据层
│       ├── build.gradle.kts
│       └── src/
│           ├── main/kotlin/com/mouthpiece/app/data/
│           │   ├── ai/AiGateway.kt                  网关接口
│           │   ├── ai/AiTimeouts.kt                 超时预算
│           │   ├── ai/ChatCompletionsEndpoint.kt    端点拼接
│           │   ├── ai/JsonExtensions.kt             optNullableString
│           │   ├── ai/OpenAiCompatGateway.kt        OpenAI 兼容实现（含重试策略）
│           │   ├── repository/ReplyRepository.kt    生成编排
│           │   ├── repository/ReplyCache.kt         访问序 LRU 缓存
│           │   ├── repository/ReplyCacheKey.kt      缓存键算法
│           │   ├── storage/SettingsStore.kt         设置 + 配额
│           │   ├── storage/PersonaStore.kt          说话对象档案
│           │   ├── storage/HistoryStore.kt          历史（文件 + 原子写）
│           │   ├── storage/HistoryCodec.kt          JSON 编解码
│           │   ├── storage/HistoryMutations.kt      纯函数变换
│           │   └── share/ShareCardRenderer.kt       Canvas 手绘分享卡片
│           └── test/kotlin/com/mouthpiece/app/data/   3 个测试类 / 31 用例
│
└── app/                             ⚠️ 恢复 Java，参考用
    ├── build.gradle.kts             已依赖 :core:data
    ├── proguard-rules.pro
    └── src/main/
        ├── AndroidManifest.xml
        ├── java/com/mouthpiece/app/ 76 个 .java（ui / vm / push / 入口）
        └── res/
```

---

## 一、模块依赖方向

```
:app
 └── :core:data  ── api ──▶  :core:domain  ── api ──▶  :core:model
```

单向、无环。三条硬约束：

- **`:core:model` 不依赖任何东西**（连 Kotlin 标准库以外都没有），所以它可以被任何层引用。
- **`:core:domain` 不碰 Android**（不引用 `android.*` / `Context` / IO），所以它的单元测试跑在普通 JVM 上，不需要设备。
- **`:core:data` 是唯一接触 Android API 的 core 模块**（`Context` / `SharedPreferences` / `Canvas` / `FileProvider` / `org.json`）。

用 `api` 而不是 `implementation` 声明向下依赖，是为了让 `:app` 只写一行 `implementation(project(":core:data"))` 就能拿到全部三层。

---

## 二、`:core:*` 能编译，`:app` 不能

`:app` 里的 76 个 Java 文件是 jadx 从 **Kotlin 字节码**恢复出来的。原项目是 Kotlin + Compose，编译后语法糖已被抹平：

- `suspend` → 带 `label` 字段的 `switch(label)` 状态机
- `@Composable` → 带 `Composer` 参数的静态方法
- `data class` → 手写的 `copy/equals/hashCode`
- Compose lambda → `ComposableSingletons$XxxKt$lambda$<哈希>$1` 这类编译器生成类

所以这些文件**能读不能编**。`:app` 的作用是「带索引的参考文档」——跳转、搜索、看结构都正常，只是满屏红色报错。

**`domain` 和 `data` 的 Java 已从 `:app` 移除**（改由 `:core:*` 提供），避免同名类冲突。完整 Java 参考在 `../source/`。

---

## 三、怎么用

### 编译

```bash
cd android-project

# 纯 Kotlin 两层 —— 不需要 Android SDK
./gradlew :core:model:build :core:domain:build

# 数据层 + 单元测试 —— 需要 Android SDK（compileSdk = 36）
./gradlew :core:data:assembleDebug :core:data:test

# 三个模块的测试一起跑
./gradlew :core:model:test :core:domain:test :core:data:test
```

### 在 Android Studio 里浏览恢复源码

直接打开这个目录。`:core:*` 正常，`:app` 会有大量报错 —— 把它当参考文档用。

### 继续重写剩下的部分

按依赖顺序，下面这些都可以立刻开写（它们只依赖 `:core:data`）：

| 顺序 | 文件 | 原 Java 参考 |
| --- | --- | --- |
| 1 | `ServiceLocator.kt` + `MouthpieceApp.kt` | `../source/com/mouthpiece/app/ServiceLocator.java` |
| 2 | `AppInfo.kt` | `../source/com/mouthpiece/app/AppInfo.java` |
| 3 | `vm/MainUiState.kt` + `MainViewModel.kt` | `../source/com/mouthpiece/app/vm/` |
| 4 | `vm/AppViewModels.kt`（History / Persona / Settings VM + VmFactory） | 同上 |
| 5 | `push/*.kt`（5 个，完全独立） | `../source/com/mouthpiece/app/push/` |
| 6 | `ui/*.kt`（7 个 Compose 文件，工作量最大） | `../source/com/mouthpiece/app/ui/` |

`MainViewModel` 的生成流程（并发、计费时机、错误收集）已经完整恢复，见 `../docs/05-功能规则清单.md` §5.2。

---

## 四、关键版本（勿随意改动）

```
AGP            8.12.0
Gradle         8.14.3
Kotlin         2.1.20
Java           17
compileSdk     36
minSdk         26
targetSdk      36
```

Compose 版本是**显式指定**的（原项目没有用 BOM）：`ui / foundation / runtime / animation = 1.8.0`、`material3 = 1.3.2`、`material-icons-core = 1.7.8`。

> 观测到的 compose 版本是 `1.8.0`，而 `compose-bom:2025.05.00` 对应 `1.8.1`、`2025.04.00` 对应 `1.7.8`，都对不上 —— 所以原项目是逐个显式指定版本的。
