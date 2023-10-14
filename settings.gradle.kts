pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ComposePractice"
include(":app")
include(":core:common")
include(":core:data")
include(":core:network")
include(":core:domain")
include(":feature:login")
include(":feature:introduce")
include(":feature:tour")
include(":feature:settings")
include(":feature:map")
