plugins {
    id("cryptowallet.android.library")
    id("cryptowallet.wallet.core")
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.semba.cryptowallet.data.model"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:design"))
    implementation(libs.kotlinx.serialization)
}
