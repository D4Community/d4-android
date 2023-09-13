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

rootProject.name = "D4 Community"
include(":app")
include(":core:datastore")
include(":core:common")
include(":data:home")
include(":feature:home")
include(":data:onboarding")
include(":feature:onboarding")
include(":data:auth")
include(":feature:auth")
