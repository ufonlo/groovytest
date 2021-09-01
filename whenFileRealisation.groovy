@Library('SharedLibriary@dev')_
Boolean enableSWDL = true
pipeline {
  agent { node { label 'HIL2' }}
  stages {
    stage('Get Artifacts') {
      steps {
          script {
                echo "------------------Start pipeline target variable------"
                echo "variable is : ${enableSWDL}"
                /* …or create a new repository on the command line
                echo "# groovytest" >> README.md
                git init
                git add README.md
                git commit -m "first commit"
                git branch -M main
                git remote add origin git@github.com:ufonlo/groovytest.git
                git push -u origin main
                …or push an existing repository from the command line


                dsdsd
                dsds
                dsdsgit s
                */
          }
      }
    }
    stage('Push Artifacts') {
        agent { node { label 'build_ubuntu' }}
            when { expression { enableSWDL != true } }
                steps {
                    script {
                        echo "enableSWDL statu is : ${enableSWDL}"
                        if (enableSWDL){
                        echo "enableSWDL statu is : ${enableSWDL}"
                        } else {
                        echo "enableSWDL statu is : ${enableSWDL}"
                        }
                        }

      }
    }
  }
}