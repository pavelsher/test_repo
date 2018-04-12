package TestRepo.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script

object TestRepo_UnitTests : BuildType({
    uuid = "0ca96317-0481-4392-a8ab-4ca279fb853d"
    id = "TestRepo_UnitTests"
    name = "Unit Tests"

    vcs {
        root(TestRepo.vcsRoots.TestRepo_HttpsGithubComPavelsherTestRepoRefsHeadsMaster)

    }

    steps {
        script {
            scriptContent = """
                echo "##teamcity[testStarted name='unit-test1']"
                echo "##teamcity[testFinished name='unit-test1']"
                
                echo "##teamcity[testStarted name='unit-test2']"
                echo "##teamcity[testFinished name='unit-test2']"
                
                echo "##teamcity[testStarted name='unit-test3']"
                echo "##teamcity[testFinished name='unit-test3']"
                
                echo "##teamcity[testStarted name='unit-test4']"
                echo "##teamcity[testFinished name='unit-test4']"
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "true")
        }
    }

    requirements {
        exists("aaa")
        contains("env.Path", "%")
    }
})
