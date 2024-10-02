pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "PokemonCardsApp"
include(":app")
include(":base:core")
include(":base:database")
include(":base:network")
include(":base:di")
include(":base:ui")
include(":feature:home")
include(":feature:detail")
include(":feature:common:data")
include(":feature:common:domain")
