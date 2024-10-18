import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("com.android.library")
}

val libs = the<LibrariesForLibs>()

dependencies {
    implementation(libs.mockk)
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}