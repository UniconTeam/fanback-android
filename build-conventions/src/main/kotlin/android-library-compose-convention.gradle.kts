import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("android-library-convention")
}

val libs = the<LibrariesForLibs>()

android {
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeBom.get()
    }
    buildFeatures {
        compose = true
    }
}