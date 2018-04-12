package TestRepo.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object TestRepo_HttpsGithubComPavelsherTestRepoRefsHeadsMaster : GitVcsRoot({
    uuid = "5ae9b5a8-e0f5-43fc-a3a3-ad045432943d"
    id = "TestRepo_HttpsGithubComPavelsherTestRepoRefsHeadsMaster"
    name = "https://github.com/pavelsher/test_repo#refs/heads/master"
    pollInterval = 10
    url = "https://github.com/pavelsher/test_repo"
    authMethod = password {
        userName = "pavelsher"
        password = "credentialsJSON:7c824a97-cbbb-4925-8d7e-f68f09c4ad3b"
    }
})
