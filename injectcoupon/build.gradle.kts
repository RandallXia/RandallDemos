import com.randallpt.versionplugin.BuildConfig
import com.randallpt.versionplugin.Depend

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.randalldev.injectcoupon"
    compileSdk = BuildConfig.compileSdkVersion

    defaultConfig {
        minSdk = BuildConfig.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

dependencies {

    implementation(project(":PT_Base_Lib:architecture"))
    implementation(project(":CpFastAccessibility:cp-fast-accessibility"))

    testImplementation(Depend.junit)
    androidTestImplementation(Depend.androidTestJunit)
    androidTestImplementation(Depend.espressoCore)
}