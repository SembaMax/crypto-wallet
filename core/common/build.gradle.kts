plugins {
    id("cryptowallet.android.library")
    id("cryptowallet.android.hilt")
}

android {
    namespace = "com.semba.cryptowallet.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}