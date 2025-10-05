pipeline {
    agent any // Specifies where the pipeline will run (e.g., any available agent)

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...' // A simple step to print a message
                // Add your build commands here, e.g., sh 'mvn clean install'
                sh 'mvn clean compile'
            }
        }

        stage('Sonar') {
                        steps {
                            echo 'Running Sonar...'
                            // Add your test commands here, e.g., sh 'mvn test'
                            sh 'mvn compile sonar:sonar'
                        }
                    }

        stage('Manual Approval for Deployment') {
            steps {
                script {
                    def userInput =
                     input (id: 'DeployApproval',
                            message: 'Proceed with deployment to TEST env?',
                            ok: 'Deploy',
                            submitter: 'admin',
                            parameters: [
                                [
                                    $class: 'ChoiceParameterDefinition',
                                    name: 'DecisionForApproval-Name',
                                    choices: 'Approved\nRejected',
                                    description: 'Description'
                                ]
                            ])
                    echo "Deployment approved for environment : $userInput"
                    if (userInput == "Approved") {
                      echo "... Deployment - Approved ..."
                    }
                     else if (userInput == "Rejected") {
                      echo "... Deployment - Rejected ..."
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Add your deployment commands here, e.g., sh 'deploy_script.sh'
            }
        }
    }
}