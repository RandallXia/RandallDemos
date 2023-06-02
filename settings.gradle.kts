pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        mavenLocal()
    }
}
rootProject.name = "Demos"
include(":app", ":PT_Base_Lib:architecture", ":injectaweme", ":fiteditor", ":palm2-android")
includeBuild("./PT_Base_Lib/versionPlugin")
