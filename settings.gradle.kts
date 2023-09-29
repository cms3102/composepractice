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
include(":core:theme")
include(":core:data")
include(":core:network")
include(":core:domain")
include(":feature:login")
include(":feature:introduce")
include(":feature:tour")
