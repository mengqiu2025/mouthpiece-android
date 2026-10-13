pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "mouthpiece"

// 分层模块化：core 下按职责再拆三层，依赖方向单向向下
//   :core:model     纯 Kotlin 数据模型（零 Android 依赖）
//   :core:domain    纯 Kotlin 业务规则（风格目录 / 提示词 / 安全过滤 / 离线模板）
//   :core:data      Android 数据层（AI 网关 / 仓储 / 存储 / 分享卡片）
//   :app            应用壳（反编译 Java，参考用；UI / ViewModel / 推送层待重写）
include(":core:model")
include(":core:domain")
include(":core:data")
include(":app")
