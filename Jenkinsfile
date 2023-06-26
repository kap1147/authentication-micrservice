pipeline {
  agent any
  parameters {
    booleanParam(name: "IS_CLEANWORKSPACE", defaultValue: "true", description: "Set to false to disable folder cleanup, default true.")
    booleanParam(name: "IS_DEPLOYING", defaultValue: "true", description: "Set to false to skip deployment, default true.")
    booleanParam(name: "IS_TESTING", defaultValue: "true", description: "Set to false to skip testing, default true!")
  }
  environment {
    DB_AUTH_DB = credentials("MONGODB_AUTH_SERVER")
    DB_NAME = credentials("MONGODB_DB_NAME")
    DB_USER = credentials("MONGODB_USER")
    DB_PASSWD = credentials("MONGODB_PASS")
    DB_HOST = credentials("MONGODB_HOST")
    DB_PORT = credentials("MONGODB_PORT")
    COMMIT_HASH = "${sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()}"
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
