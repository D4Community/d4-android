plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.auth"
    compileSdk = 33

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //ui TODO: Remove it later, SHOULD BE FROM designsystem ONLY
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.material3:material3")

    //compose navigation
    implementation("androidx.navigation:navigation-common-ktx:2.7.2")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.2")
    implementation("androidx.navigation:navigation-compose:2.7.2")

    //appwrite
    implementation("io.appwrite:sdk-for-android:1.1.0")
}