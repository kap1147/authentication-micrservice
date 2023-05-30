pipeline {
  agent any
  parameters {
    booleanParam(name: "IS_CLEANWORKSPACE", defaultValue: "true", description: "Set to false to disable folder cleanup, default true.")
    booleanParam(name: "IS_DEPLOYING", defaultValue: "true", description: "Set to false to skip deployment, default true.")
    booleanParam(name: "IS_TESTING", defaultValue: "false", description: "Set to false to skip testing, default true!")
  }

  stages {
    stage("Maven Test"){
      steps {
        sh "echo 'hello world from Jenkinsfile!'"
      }
    }
  }
}
