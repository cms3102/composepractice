@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.ksp.plugin)
    alias(libs.plugins.hilt.plugin)
}

android {
    namespace = "com.csergio.feature.settings"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures { // added to fix backend internal error
        compose = true
    }
    composeOptions { // added to fix compose compiler compatibility error
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))

    ksp(libs.hilt.compiler)
    implementation(libs.hilt.android)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(platform(libs.compose.bom))
    implementation(libs.hilt.navigation.compose)
    implementation(libs.ui)
    implementation(libs.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.lottie)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}