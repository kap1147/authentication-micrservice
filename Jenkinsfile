pipeline {
  tools {
    maven 'Maven'
  }
  parameters {
    booleanParam(name: "IS_CLEANWORKSPACE", defaultValue: "true", description: "Set to false to disable folder cleanup, default true.")
    booleanParam(name: "IS_DEPLOYING", defaultValue: "true", description: "Set to false to skip deployment, default true.")
    booleanParam(name: "IS_TESTING", defaultValue: "false", description: "Set to false to skip testing, default true!")
  }

  stages {
    stage("Deploy to ECS"){
      steps {
        sh "echo 'hello world from Jenkinsfile!"
      }
    }
  }
}
