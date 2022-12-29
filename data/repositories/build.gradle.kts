plugins {
    id("cryptowallet.android.library")
    id("cryptowallet.android.hilt")
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.semba.cryptowallet.data.repositories"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":data:model"))
    implementation(project(":data:database"))
    implementation(project(":data:datastore"))
    implementation(project(":core:network"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization)
}