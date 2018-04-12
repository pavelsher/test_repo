package TestRepo.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object TestRepo_AllTests : BuildType({
    uuid = "ab75f8ba-5e22-4f07-af0d-12e33d94ba12"
    id = "TestRepo_AllTests"
    name = "All Tests"

    type = BuildTypeSettings.Type.COMPOSITE

    vcs {
        showDependenciesChanges = true
    }

    triggers {
        vcs {
            enabled = false
            branchFilter = ""
            watchChangesInDependencies = true
        }
    }

    dependencies {
        dependency(TestRepo.buildTypes.TestRepo_IntegrationTests) {
            snapshot {
            }
        }
        dependency(TestRepo.buildTypes.TestRepo_UnitTests) {
            snapshot {
            }
        }
    }
})
