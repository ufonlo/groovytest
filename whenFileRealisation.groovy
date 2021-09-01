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
          }
      }
    }
    stage('Push Artifacts') {
        agent { node { label 'build_ubuntu' }}
            when { expression { enableSWDL != true } }
                steps {
                    script {
                        echo "enableSWDL statu is : ${enableSWDL}"
                        }

      }
    }
  }
}