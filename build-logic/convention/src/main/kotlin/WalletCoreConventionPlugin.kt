import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.repositories

class WalletCoreConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "implementation"(libs.findLibrary("crypto.tink").get())
                "implementation"(libs.findLibrary("androidx.security.crypto").get())
                "implementation"(libs.findLibrary("trust.wallet.core").get())
                "implementation"(libs.findLibrary("esaulpaugh-headlong").get())
                "implementation"(libs.findLibrary("gson").get())
            }
        }
    }
}