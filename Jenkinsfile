pipeline {
    agent any

    stages {

        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps {
                bat 'docker build -t asv/orange:latest .'
            }
        }

        stage('Push Image') {
            environment {
                DOCKER_HUB = credentials('dockerhub-creds')
            }
            steps {
                bat '''
                echo %DOCKER_HUB_PSW% | docker login -u %DOCKER_HUB_USR% --password-stdin
                docker push asv/orange:latest
                docker tag asv/orange:latest asv/orange:%BUILD_NUMBER%
                docker push asv/orange:%BUILD_NUMBER%
                '''
            }
        }
    }

    post {
        always {
            bat 'docker logout'
        }
    }
}