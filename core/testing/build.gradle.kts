plugins {
    id("cryptowallet.android.library")
    id("cryptowallet.android.hilt")
}

android {

    namespace = "com.semba.cryptowallet.core.testing"
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":data:datastore"))

    implementation(libs.androidx.dataStore.core)

    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)

    api(libs.androidx.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test)
    api(libs.hilt.android.testing)

    debugApi(libs.androidx.compose.ui.testManifest)
}