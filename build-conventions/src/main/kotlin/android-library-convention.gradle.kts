import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

val libs = the<LibrariesForLibs>()

android {
    namespace = "app.uniconteam.dux"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.compose.viewmodel)
    implementation(libs.koin.compose.viewmodel.navigation)
    runtimeOnly(libs.koin.core)
    runtimeOnly(libs.koin.compose)

    implementation(libs.kotlin.coroutines)
}