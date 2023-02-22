pipeline {
  agent any
  tools {
    maven '3.9.0'
  }
  stages {
      stage('SonarQube Analysis') {
      steps{
      withSonarQubeEnv(installationName: 'Sonar qube', envOnly: true)  {
        sh "mvn clean verify sonar:sonar -Dsonar.projectKey=Teacher22_contacts-library_AYZ0K_3K1BJcrZbvqrpA"
      }
      }
    }
    stage ('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}
