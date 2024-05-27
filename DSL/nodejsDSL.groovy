job('Aplicacion-Nodejs-DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
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
        shell("npm install")
    }

}
