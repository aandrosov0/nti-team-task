plugins {
    kotlin("android")
    id("com.android.application")
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "aandrosov.app.server"

    compileSdk = 34

    defaultConfig {
        applicationId = "aandrosov.app.server"

        minSdk = 29
        targetSdk = 34

        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

repositories {
    google()
    mavenCentral()
}