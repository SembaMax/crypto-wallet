import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureDomainConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("cryptowallet.android.library")
                apply("cryptowallet.android.hilt")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {

                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":data:model"))
                add("implementation", project(":data:repositories"))
                add("implementation", project(":core:common"))

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}