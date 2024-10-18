plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    // alias(libs.plugins.google.services)
}

android {
    namespace = "app.uniconteam.fanback"
    compileSdk = 34

    defaultConfig {
        applicationId = "app.uniconteam.fanback"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0-early1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    val globalStoreFile = file("debug.key")
    val globalStorePass = "password1K"
    val globalStoreAlias = "debug"
    signingConfigs {
        getByName("debug") {
            keyAlias = globalStoreAlias
            keyPassword = globalStorePass
            storeFile = globalStoreFile
            storePassword = globalStorePass
        }
        create("release") {
            keyAlias = globalStoreAlias
            keyPassword = globalStorePass
            storeFile = globalStoreFile
            storePassword = globalStorePass
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
        }
    }
}

dependencies {
    // Base
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.legacy)
    implementation(libs.androidx.navigation.compose)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.compose.viewmodel)
    implementation(libs.koin.compose.viewmodel.navigation)
    runtimeOnly(libs.koin.core)
    runtimeOnly(libs.koin.compose)
    runtimeOnly(libs.koin.android)
}