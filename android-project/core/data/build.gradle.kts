import org.jetbrains.kotlin.gradle.dsl.JvmTarget

/**
 * :core:data —— 数据访问与输出层。
 *
 * 这一层需要 Android API（Context / SharedPreferences / Canvas / FileProvider / org.json），
 * 所以用 Android Library 插件。内部分四个子包，各管一件事：
 *
 * - `ai/`         —— AI 网关：接口、超时、端点拼接、OpenAI 兼容实现
 * - `repository/` —— 生成编排、LRU 缓存、缓存键算法
 * - `storage/`    —— 三个 Store + 历史编解码 + 纯函数变换
 * - `share/`      —— 分享卡片 Canvas 渲染
 *
 * 依赖方向：`:core:data` → `:core:domain` → `:core:model`（单向）。
 */
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.mouthpiece.app.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // 源码放在 src/main/kotlin，需要显式声明
    sourceSets["main"].kotlin.srcDir("src/main/kotlin")
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    // api：把 domain / model 层透传给 :app
    api(project(":core:domain"))

    // FileProvider（ShareCardRenderer 分享图片用）
    api(libs.androidx.core.ktx)

    // StateFlow / suspend / CoroutineScope
    api(libs.kotlinx.coroutines.android)

    testImplementation(libs.junit)
}
