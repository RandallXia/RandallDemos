import com.randallpt.versionplugin.AndroidX
import com.randallpt.versionplugin.BuildConfig
import com.randallpt.versionplugin.Depend
import com.randallpt.versionplugin.Glide
import com.randallpt.versionplugin.Hilt
import com.randallpt.versionplugin.Kt
import com.randallpt.versionplugin.Moshi

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.randalldev.demos"
    compileSdk = BuildConfig.compileSdkVersion

    defaultConfig {
        minSdk = BuildConfig.minSdkVersion
        targetSdk = BuildConfig.targetSdkVersion
        versionCode = Integer.parseInt(System.getenv("VERSION_CODE"))
        versionName = System.getenv("VERSION_NAME")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    signingConfigs {
        create("release") {
            enableV1Signing = true
            enableV2Signing = true
            storeFile = file("../PT_Base_Lib/randallpt.keystore")
            storePassword = System.getenv(" ANDROID_KEYSTORE_PASS ")
            keyAlias = System.getenv("ANDROID_KEY_ALIAS")
            keyPassword = System.getenv("ANDROID_KEY_PASS")
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            // 移除无用的resource文件
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_17)
        targetCompatibility(JavaVersion.VERSION_17)
    }
    kotlin {
        jvmToolchain(17)
    }
    lint {
        lintConfig = file("android-lint.xml")
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/INDEX.LIST" // Add this line
            excludes += "META-INF/DEPENDENCIES" // And this line
        }
    }
}

dependencies {

    implementation(project(":PT_Base_Lib:architecture"))
    implementation(project(":injectcoupon"))
    //implementation(project(":palm2-android"))
    implementation(project(":fiteditor"))

    testImplementation(Depend.junit)
    androidTestImplementation(Depend.androidTestJunit)
    androidTestImplementation(Depend.espressoCore)

    implementation(AndroidX.activityKtx)
    implementation(AndroidX.fragmentKtx)
    implementation(AndroidX.lifecycleLiveData)
    implementation(AndroidX.lifecycleViewModel)
    implementation(AndroidX.paging)
    // DI
    implementation(Hilt.dagger)
    kapt(Hilt.daggerCompiler)
    implementation(Hilt.viewModel)
    kapt(Hilt.compiler)

    kapt(Moshi.codegen)

    kapt(Glide.compiler)
}