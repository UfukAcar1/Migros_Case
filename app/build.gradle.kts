plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.compose")
}

android {
    namespace = "com.example.spaceflightnewsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.spaceflightnewsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    kapt {
        javacOptions {
            option("-source", "17")
            option("-target", "17")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}

dependencies {
    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Material3
    implementation(libs.androidx.material3)

    // JetBrains Compose
    implementation("org.jetbrains.compose.ui:ui:1.5.2")
    implementation("org.jetbrains.compose.material:material:1.5.2")
    implementation("org.jetbrains.compose.foundation:foundation:1.5.2")

    // Gson Dependency
    implementation("com.google.code.gson:gson:2.8.9")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Coil Compose
    implementation("io.coil-kt:coil-compose:2.2.2")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.6.0")
}