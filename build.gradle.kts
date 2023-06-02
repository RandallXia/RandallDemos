// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.0" apply false
    id("com.android.library") version "8.0.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.owasp.dependencycheck") version "8.2.1"
    id("plugin.version") apply false
}

subprojects {
    // 默认应用所有子项目中
    apply(plugin = "plugin.version")
}