@Library('SharedLibriary@dev')_
Boolean enableSWDL = false
String testsvalue = ""
pipeline {
  agent { node { label 'build_ubuntu' }}
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
            //when { expression { enableSWDL } }
                steps {
                    script {
                        echo "enableSWDL statu is : ${enableSWDL}"
                        if (!enableSWDL){
                        echo "enableSWDL statu is : ${enableSWDL}"
                        testsvalue = "\n\n====  Attention!!! ====\nYou have disabled enableSWDL options - skip downloading artifacts!\nTesting will take place with the current artifacts that are already flashed on HIL"
                        }
                        println("Test value is\n${testsvalue}")
        }

      }
    }
  }
}