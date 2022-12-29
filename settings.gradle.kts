pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
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
