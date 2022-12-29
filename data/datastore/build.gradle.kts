import com.google.protobuf.gradle.builtins
import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("cryptowallet.android.library")
    id("cryptowallet.android.hilt")
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.protobuf)
}

android {
    defaultConfig {
        //It's important adding a rule to proguard to prevent deleting protobuf fields.
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    namespace = "com.semba.cryptowallet.data.datastore"
}

// Setup protobuf configuration, generating lite Java and Kotlin classes
protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                val java by registering {
                    option("lite")
                }
                val kotlin by registering {
                    option("lite")
                }
            }
        }
    }
}

dependencies {

    implementation(project(":data:model"))
    implementation(project(":core:common"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.dataStore.core)
    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.androidx.dataStore.preferences)
    implementation(libs.protobuf.kotlin.lite)
}