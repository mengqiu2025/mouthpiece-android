# 嘴替 (mouthpiece) v0.1.4 — Android 客户端源码

嘴替 v0.1.4 的完整项目资料。**本项目是作者本人的个人项目**；v0.1.4 的原始工程已丢失，本仓库内容从该版本的发布包恢复并重新整理，用于后续继续开发。

---

## 一、项目速览

| 项目 | 值 |
| --- | --- |
| 应用名 | 嘴替 |
| 包名 | `com.mouthpiece.app` |
| versionName / versionCode | `0.1.4` / `5` |
| minSdk / targetSdk / compileSdk | 26 / 36 / 36 |
| 技术栈 | Kotlin + Jetpack Compose（单 Activity，无 Fragment、无 XML 布局） |
| 构建环境 | Gradle 8.14.3、AGP 8.12.0、Kotlin 2.1.20、Java 17 |
| 架构 | 简化 MVVM + 手写 ServiceLocator 依赖容器 |
| 数据层 | SharedPreferences + `org.json` 手工序列化（**未使用 Room 存储业务数据**） |
| 网络层 | `HttpURLConnection` 直连 OpenAI 兼容 `/chat/completions` |
| 应用自身代码 | 310 个类 / 1604 个方法 |

### 两个构建变体的差异（决定以哪个为恢复来源）

| | debug 包 | release 包 |
| --- | --- | --- |
| 体积 | 11.0 MB | 1.3 MB |
| dex 数量 | 10 | 1 |
| 总类数 | 15,160 | 2,928 |
| **应用自身类数** | **310（类名完整）** | **3（`A/a`、`d2/c` 之类，release 构建被 R8 全量重命名）** |
| 可否作为恢复来源 | ✅ 可以 | ❌ 不可用 |

> **结论：debug 包未做名称混淆，是唯一可用于源码恢复的构建变体。**
> release 包保留了完整依赖清单（`META-INF/*.version`），但业务代码的类名与方法名已被 R8 重写。

---

## 二、这个 App 是做什么的

一句话：**「不知道怎么回消息？粘过来，三秒给你几个版本。」**

用户把对方发来的话粘贴进 App → 选择场景（职场/恋爱/社交/通用）+ 风格（最多 5 种）+ 表达强度（1–5 档）→ App 组装提示词调用用户自带的 OpenAI 兼容大模型 → 生成多条可直接发送的回复 → 可复制、收藏、生成分享卡片。

核心业务规则（细节见 `docs/05-功能规则清单.md`）：

- **自带 Key 模式**：不内置任何 API Key，用户在「设置」里填接口地址 + Key + 模型名；未配置时全部走**内置离线模板**，功能可用但不够贴合语境。
- **免费额度**：每天 10 次（`FREE_DAILY_QUOTA = 10`），跨天自动重置；`isPro` 开关可解锁无限次（会员逻辑**未实现支付**，仅本地开关）。
- **安全过滤**：输入 24 个违规词黑名单 + 输出 8 个黑名单，带「否定前缀白名单」（如「不要开盒」不会被拦）。
- **无痕模式**：开启后不写入本地历史。
- **每日推送**：WorkManager 每 24h 推一条沟通话术；另有「断签提醒」（当天一次都没用才发）。
- **分享入口**：支持系统分享（`ACTION_SEND`）和选中文本菜单（`ACTION_PROCESS_TEXT`），把外部文本直接灌进输入框。

---

## 三、目录说明

```
.
├── README.md                     ← 你正在看的文件
├── 项目说明.html                  ← 可读性更好的图文版总览
├── docs/                         ← 项目文档（建议按顺序读）
│   ├── 01-架构与模块.md
│   ├── 02-数据模型与持久化.md
│   ├── 03-AI网关与提示词.md
│   ├── 04-风格场景人设目录.md
│   ├── 05-功能规则清单.md
│   ├── 06-重建与重启指南.md
│   └── 07-源码完整性与已知限制.md  ← 重要：先看这个再动手
├── source/                       ← 恢复出的应用源码（Java，104 个文件，完整参考）
│   └── com/mouthpiece/app/...
├── resources/                    ← 从发布包中取出的资源
│   ├── AndroidManifest.xml       ← 可直接阅读的明文清单
│   └── res/                      ← 图标、通知栏样式、file_paths 等
└── android-project/              ← 重建的 Gradle 工程（模块化：4 个模块）
    ├── settings.gradle.kts        include(":core:model", ":core:domain", ":core:data", ":app")
    ├── build.gradle.kts
    ├── gradle.properties
    ├── gradle/libs.versions.toml ← 版本号全部为实测值
    │
    ├── core/                     ★ 已用 Kotlin 重写，模块化（29 文件 / ~2000 行）
    │   ├── README.md             模块划分 + 文件对照表 + 5 处已修正问题 + 用法
    │   ├── model/                :core:model   纯 Kotlin 数据模型（零 Android 依赖）
    │   │   └── src/main/kotlin/com/mouthpiece/app/model/   11 个单职责文件
    │   ├── domain/               :core:domain  纯 Kotlin 业务规则（零 Android 依赖）
    │   │   └── src/{main,test}/kotlin/com/mouthpiece/app/domain/
    │   │       ├── style/   prompt/   safety/              4 个文件 + 58 个测试用例
    │   └── data/                 :core:data    Android 数据层
    │       └── src/{main,test}/kotlin/com/mouthpiece/app/data/
    │           ├── ai/  repository/  storage/  share/       14 个文件 + 31 个测试用例
    │
    └── app/                      ⚠️ 恢复出的 Java 参考代码（ui / vm / push），待重写
        ├── build.gradle.kts       已依赖 :core:data
        ├── proguard-rules.pro
        └── src/main/
            ├── AndroidManifest.xml
            ├── java/com/mouthpiece/app/   76 个 .java
            └── res/
```

---

## 四、怎么继续这个项目

### 已完成：核心层（模块化为 model / domain / data 三层）

`android-project/core/` 是**用 Kotlin 重写并模块化好的核心层**，29 个单职责文件、约 2000 行主源码，并且**已经过验证**：

```
编译：Kotlin 2.1.20 + 真实 android.jar (API 36)  →  59 个 class，0 error
测试：JUnit 4.13.2                              →  OK (89 tests)
```

包括 12 种风格目录、提示词组装、三层安全过滤、离线模板引擎、AI 网关（含重试策略）、
生成编排与 LRU 缓存、三个持久化 Store、分享卡片渲染。

详见 `android-project/core/README.md` —— 里面有**模块划分依据**、**旧文件 → 新文件的拆分明细**、**5 处已修正问题的说明**。

### 待完成：UI / ViewModel / 推送

`:app` 里的 76 个 Java 文件是**从发布包恢复出的参考代码，不能直接编译**。原因见 `docs/07-源码完整性与已知限制.md`：原项目是 **Kotlin + Compose**，恢复出的 Java 里 Kotlin 语法糖已被展开（`suspend` 状态机变成 `switch(label)`、`data class` 变成手写的 `copy/equals/hashCode`、`@Composable` 变成普通静态方法 + `Composer` 参数）。逻辑完整可读，但形态必须按 Kotlin 重写。

建议顺序（都可以立刻开写，只依赖 `:core:data`）：

| 顺序 | 内容 | 参考 |
| --- | --- | --- |
| 1 | `ServiceLocator` + `MouthpieceApp` | `source/com/mouthpiece/app/ServiceLocator.java` |
| 2 | `MainUiState` + `MainViewModel` | `source/.../vm/`、`docs/05` §5.2 |
| 3 | `HistoryViewModel` / `PersonaViewModel` / `SettingsViewModel` / `VmFactory` | `source/.../vm/` 里对应的 4 个类 |
| 4 | `push/*`（5 个，完全独立） | `source/.../push/`、`docs/05` §5.7 |
| 5 | `ui/*`（7 个 Compose 文件，工作量最大） | `source/.../ui/` |

`docs/04` 里的风格目录可以**直接复制使用**，是原样文本（已经在 `:core:domain` 里了）。

### 打开工程

用 Android Studio 打开 `android-project/`：`:core:*` 正常，`:app` 满屏报错但可当参考文档用。

```bash
./gradlew :core:model:test :core:domain:test    # 纯 Kotlin，不需要 Android SDK
./gradlew :core:data:assembleDebug              # 需要 Android SDK（compileSdk = 36）
```

---

## 五、资料来源与可信度

| 证据类型 | 说明 |
| --- | --- |
| 源码恢复 | jadx 1.5.6 对 debug 包 10 个 dex 的处理，`--show-bad-code` 保留不完整代码 |
| 清单/资源 | 解码 `resources.arsc` 与二进制 AXML |
| 结构清点 | androguard 4.1.4 统计类/方法/包分布 |
| 依赖版本 | 包内 `META-INF/*.version`（Google 官方写入）+ `kotlin-tooling-metadata.json` |
| 字符串 | 从 dex 字符串池提取（含全部中文文案、system prompt、离线话术） |

**所有版本号、常量、文案均为实测值，不是推测值。** 少数无法从静态分析确定的点（如 UI 交互细节、动画参数）已在 `docs/07` 中逐条标注。

---

## 六、构建产物与校验

| 文件 | SHA-256 |
| --- | --- |
| `mouthpiece-0.1.4-debug.apk` | `9247df2367b68c00015c0ed8de20098d940d573b60916985c3844061724ddfd4` |
| `mouthpiece-0.1.4-release.apk` | `9b0b137681d0808ce7b9abe96fa000cd6e072c712067a4e20595646f3b90f26d` |

两个包体积较大，未随仓库提交。工作区另有 `_reverse/` 目录保留原始包与所用工具链和中间产物，可复现整个恢复流程。
