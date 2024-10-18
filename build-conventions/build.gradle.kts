plugins {
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    api(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    api(libs.kotlin.plugin)
    api(libs.android.gradle.plugin)
    api(libs.ksp.plugin)
    api(libs.koin.core)
}