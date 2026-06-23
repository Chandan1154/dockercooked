pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }


        stage('Maven Check') {
            steps {
                sh 'mvn -version'
            }
        }


        stage('Build Maven') {
            steps {
                sh 'mvn clean package'
            }
        }


        stage('Docker Build') {
            steps {
                sh 'docker build -t dockercooked-app .'
            }
        }


        stage('Deploy') {
            steps {

                sh '''
                echo "Stopping old container..."

                docker stop dockercooked-app || true
                docker rm dockercooked-app || true


                echo "Starting new container..."

                docker run -d \
                --name dockercooked-app \
                -p 8081:8081 \
                dockercooked-app


                echo "Deployment completed"
                '''
            }
        }

    }
}