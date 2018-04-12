package TestRepo

import TestRepo.buildTypes.*
import TestRepo.vcsRoots.*
import TestRepo.vcsRoots.TestRepo_HttpsGithubComPavelsherTestRepoRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "243b65c2-ed3a-4eb4-8945-074e02775acc"
    id = "TestRepo"
    parentId = "_Root"
    name = "Test Repo"

    vcsRoot(TestRepo_HttpsGithubComPavelsherTestRepoRefsHeadsMaster)

    buildType(TestRepo_AllTests)
    buildType(TestRepo_ArtifactDep)
    buildType(TestRepo_Distrib)
    buildType(TestRepo_IntegrationTests)
    buildType(TestRepo_UnitTests)

    features {
        versionedSettings {
            id = "PROJECT_EXT_8"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = TestRepo_HttpsGithubComPavelsherTestRepoRefsHeadsMaster.id
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
    buildTypesOrder = arrayListOf(TestRepo.buildTypes.TestRepo_Distrib, TestRepo.buildTypes.TestRepo_AllTests, TestRepo.buildTypes.TestRepo_IntegrationTests, TestRepo.buildTypes.TestRepo_UnitTests)
})
