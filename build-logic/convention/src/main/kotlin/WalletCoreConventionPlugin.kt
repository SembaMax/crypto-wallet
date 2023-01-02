import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class WalletCoreConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "implementation"(libs.findLibrary("crypto.tink").get())
                "implementation"(libs.findLibrary("androidx.security.crypto").get())
                "implementation"(libs.findLibrary("trust.wallet.core").get())
            }
        }
    }
}