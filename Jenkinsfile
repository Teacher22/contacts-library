pipeline {
  agent any
  tools {
    maven '3.9.0'
  }
  stages {
      stage('SonarQube Analysis') {
      withSonarQubeEnv() {
        sh "mvn clean verify sonar:sonar -Dsonar.projectKey=Teacher22_contacts-library_AYZ0K_3K1BJcrZbvqrpA"
      }
    }
    stage ('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}