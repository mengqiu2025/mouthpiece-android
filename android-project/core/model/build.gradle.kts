import org.jetbrains.kotlin.gradle.dsl.JvmTarget

/**
 * :core:model —— 数据模型层。
 *
 * 纯 Kotlin，**零 Android 依赖**：本模块只放数据结构（场景、风格、请求、回复、
 * 配额、历史、设置……），不含任何行为，也不引用 `android.*`。
 *
 * 因此它可以用最普通的 JVM 插件，单元测试不需要 Android 运行时。
 * 这是整个工程里依赖最少的一层，所有其他模块都依赖它。
 */
plugins {
    alias(libs.plugins.kotlin.jvm)
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
    testImplementation(libs.junit)
}
