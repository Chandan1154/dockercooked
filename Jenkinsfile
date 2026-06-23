pipeline {

    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-17'
        }
    }


    stages {


        stage('Checkout') {
            steps {
                checkout scm
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
                docker rm -f dockercooked-app || true

                docker run -d \
                --name dockercooked-app \
                -p 8081:8081 \
                dockercooked-app
                '''

            }
        }

    }
}