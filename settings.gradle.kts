import java.util.Properties

include(":feature:sendcurrency:domain")


include(":feature:sendcurrency:ui")


pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    val properties = Properties()
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { "https://jitpack.io" }
        maven {
            url = uri("https://maven.pkg.github.com/trustwallet/wallet-core")
            credentials {
                username = properties.getProperty("GITHUB_USER")
                password = properties.getProperty("GITHUB_TOKEN")
            }
        }
    }
}
rootProject.name = "cryptowallet"
include(":app")
include(":data:database")
include(":data:repositories")
include(":core:di")
include(":core:common")
include(":feature:createwallet:domain")
include(":feature:wallethistory:domain")
include(":feature:importwallet:domain")
include(":feature:homescreen:domain")
include(":feature:createwallet:ui")
include(":feature:importwallet:ui")
include(":feature:homescreen:ui")
include(":feature:wallethistory:ui")
include(":data:model")
include(":data:datastore")
include(":core:network")
include(":core:design")
include(":feature:userwallets:ui")
include(":feature:userwallets:domain")
