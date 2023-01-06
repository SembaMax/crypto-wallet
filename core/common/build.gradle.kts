plugins {
    id("cryptowallet.android.library")
    id("cryptowallet.android.hilt")
}

android {
    buildTypes {
        debug {
            buildConfigField("String", "BLOCKCHAIN_NETWORK", "\"Mainnet\"")
        }
        release {
            buildConfigField("String", "BLOCKCHAIN_NETWORK", "\"Testnet\"")
        }
    }
    namespace = "com.semba.cryptowallet.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}