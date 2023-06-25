pipeline {
  agent any
  parameters {
    booleanParam(name: "IS_CLEANWORKSPACE", defaultValue: "true", description: "Set to false to disable folder cleanup, default true.")
    booleanParam(name: "IS_DEPLOYING", defaultValue: "true", description: "Set to false to skip deployment, default true.")
    booleanParam(name: "IS_TESTING", defaultValue: "true", description: "Set to false to skip testing, default true!")
  }

  stages {
    stage("Maven Test"){
      steps {
        script {
          if (params.IS_TESTING) {
            sh "mvn clean test"
          }
        }
      }
    }
    stage("Package Artifact") {
      steps {
        sh "mvn package"
      }
    } 
  }
}
