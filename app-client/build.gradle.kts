plugins {
    kotlin("android") version "2.0.0"
    kotlin("plugin.compose") version "2.0.0"
    id("com.android.application") version "8.5.0"
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "aandrosov.app.client"

    compileSdk = 34

    defaultConfig {
        applicationId = "aandrosov.app.client"

        minSdk = 29
        targetSdk = 34

        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
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

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))

    implementation("androidx.compose.material3:material3")

    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")

    implementation("com.google.android.material:material:1.12.0")
}