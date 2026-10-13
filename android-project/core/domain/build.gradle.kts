import org.jetbrains.kotlin.gradle.dsl.JvmTarget

/**
 * :core:domain —— 业务规则层。
 *
 * 纯 Kotlin，**零 Android 依赖**：只放与「怎么回消息」有关的规则 ——
 * 风格目录、提示词组装、离线模板引擎、安全过滤。这些规则都是纯函数式的，
 * 不碰 IO、不碰 Context，因此单元测试跑在普通 JVM 上。
 *
 * 依赖方向：`:core:domain` → `:core:model`（单向，不反向）。
 */
plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-library`
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // api：把模型层透传给下游（:core:data / :app 无需重复声明）
    api(project(":core:model"))

    testImplementation(libs.junit)
}
