job('Aplicacion-Nodejs-Docker-DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/puchevcp/nodejs-DSL.git', 'main') { node ->
            node / gitConfigName('puchevcp')
            node / gitConfigEmail('puche.vcp@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('puchevcp/nodejs-DSL')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }

}
