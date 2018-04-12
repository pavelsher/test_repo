package TestRepo.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script

object TestRepo_IntegrationTests : BuildType({
    uuid = "0b23f685-c750-4e5a-9d88-e939945417f1"
    id = "TestRepo_IntegrationTests"
    name = "Integration Tests"

    vcs {
        root(TestRepo.vcsRoots.TestRepo_HttpsGithubComPavelsherTestRepoRefsHeadsMaster)

    }

    steps {
        script {
            scriptContent = """
                echo "##teamcity[testStarted name='int-test1']"
                echo "##teamcity[testFinished name='int-test1']"
                
                echo "##teamcity[testStarted name='int-test2']"
                echo "##teamcity[testFinished name='int-test2']"
                
                echo "##teamcity[testStarted name='int-test3']"
                echo "##teamcity[testFinished name='int-test3']"
                
                echo "##teamcity[testStarted name='int-test4']"
                echo "##teamcity[testFinished name='int-test4']"
                
                ping -t -n 20 127.0.0.1
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "true")
        }
        script {
            scriptContent = """echo "##teamcity[buildStatus status='NORMAL' text=' 	Build chain finished (success: 140, failed: 36); Tests failed: 114 (24 new), passed: 35567, ignored: 355, muted: 38']""""
        }
    }

    requirements {
        exists("%%PATH%%")
    }
})
