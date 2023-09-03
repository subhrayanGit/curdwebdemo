pipeline {
    agent any
    environment {
                // Define environment variables here
                PREV_BUILD_NUMBER = ${BUILD_NUMBER-1}
    }

    stages {

        stage('Compile and Clean') {
            steps {
                // Run Maven on a Unix agent.

                sh "mvn clean compile"
            }
        }
        stage('Maven packaging') {

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
                 withCredentials([string(credentialsId: 'dcpdocker1', variable: 'Dockerpwd')]) {
                    sh "docker login -u dcpdocker1 -p ${Dockerpwd}"
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
                sh 'docker stop demo_container${PREV_BUILD_NUMBER} || true'
                sh 'docker run -itd --name demo_container${BUILD_NUMBER} -p  8081:8081 dcpdocker1/dcpimage:${BUILD_NUMBER}'
            }
        }
        stage('Archving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }


    }
}