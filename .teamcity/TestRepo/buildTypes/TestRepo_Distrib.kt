package TestRepo.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildFeatures.swabra
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object TestRepo_Distrib : BuildType({
    uuid = "9bea9c62-c8f5-44c9-b0c7-f21bc7b23a7b"
    id = "TestRepo_Distrib"
    name = "Distrib"
    description = "test"

    artifactRules = """D:\tmp\demo\artifact.zip"""

    params {
        param("aaa", "")
    }

    vcs {
        root(TestRepo.vcsRoots.TestRepo_HttpsGithubComPavelsherTestRepoRefsHeadsMaster)

        showDependenciesChanges = true
    }

    steps {
        script {
            scriptContent = "ping -t -n 5 127.0.0.1"
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "true")
        }
    }

    triggers {
        vcs {
            enabled = false
            branchFilter = ""
            enableQueueOptimization = false
        }
    }

    features {
        swabra {
        }
    }

    dependencies {
        dependency(TestRepo.buildTypes.TestRepo_AllTests) {
            snapshot {
            }
        }
        artifacts(TestRepo.buildTypes.TestRepo_ArtifactDep) {
            buildRule = lastSuccessful()
            artifactRules = ".teamcity/settings/digest.txt"
        }
    }

    requirements {
        exists("dd", "RQ_10")
        equals("aaa", "%")
        contains("fff", "11%%rrr%%22")
    }
    
    disableSettings("RQ_10")
})
