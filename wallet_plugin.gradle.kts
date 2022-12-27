
dependencies {
    //Crypto libs
    implementation(libs.crypto.tink)
    implementation(libs.androidx.security.crypto)
    implementation("com.trustwallet:wallet-core:3.1.7")

    implementation("com.esaulpaugh:headlong:5.4.0")
    implementation("com.lzy.net:okgo:3.0.4")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")

}