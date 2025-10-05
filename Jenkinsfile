node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    step {
      sh "mvn clean verify sonar:sonar -Dsonar.projectKey=spring-graphql-demo -Dsonar.projectName='spring-graphql-demo'"
    }
  }
}