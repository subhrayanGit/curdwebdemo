pipeline {
    agent any
    stages {
        stage('Compile and Clean') {
            steps {
                // Run Maven on a Unix agent.

                sh "mvn clean compile"
            }
        }
        stage('deploy') {

            steps {
                sh "mvn package"
            }
        }
        stage('Build Docker image'){

            steps {
                echo "Building docker image"
                sh 'ls'
                sh 'docker build -t dcpdocker1/dcpimage:${BUILD_NUMBER} .'
            }
        }
        stage('Docker Login'){

            steps {
                 withCredentials([string(credentialsId: 'dcpdocker1', variable: 'dcpdocker1')]) {
                    sh "docker login -u dcpdocker1 -p ${dcpdocker1}"
                }
            }
        }
        stage('Docker Push'){
            steps {
                sh 'docker push dcpdocker1/dcpimage:${BUILD_NUMBER}'
            }
        }
        stage('Docker deploy'){
            steps {

                sh 'docker run -itd -p  8081:8080 dcpdocker1/dcpimage:${BUILD_NUMBER}'
            }
        }
        stage('Archving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}