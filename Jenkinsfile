 pipeline {
    agent any
      tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
          
      }
      
    stages {
        stage('Git Checkout') {
            steps {
                echo 'Pulling...';
                git branch: 'RaoudhaZid',
                url: 'https://github.com/hazemax007/Devops-ITLeaders-5SAE5.git'
            }
        }
        
        stage('Testing maven') {
       
            steps {
                sh "mvn -version"
            }
        }
        
         stage('maven clean'){
            steps{
                sh 'mvn clean'
            }
        }
        
        stage('MVN COMILE') {
            steps {
                sh "mvn compiler:compile"
            }
        }
        
        stage('MVN SONARQUBE') {
            steps {
                sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.login=6f869e6b71a5beeedcb1753d2ec23bb499eb5c41" 
            }
        }
        
        stage('Build Maven Spring'){
            steps{
                sh 'mvn  clean install '
         }
        }
         

        stage ('NEXUS DEPLOY') {
            steps {
                sh 'mvn  clean deploy -DskipTests'
            }
        }
        
        stage ('BUILD  ') {
            steps {
                sh 'docker build -t raoudhazid/achat:latest .'
                sh 'docker build -t raoudhazid/mysql:5.7 .'
            }
        }
        
        
        
        stage('DOCKER LOGIN'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'raoudhazid', variable: 'dockerhub')]) {
                        sh 'docker login -u raoudhazid -p ${dockerhub}'
                    }
                }
            }
        }

        stage ('Docker Push') {
            steps {
                echo "Docker pushing ...."
                sh 'docker push raoudhazid/achat:latest'
                sh 'docker push raoudhazid/mysql:5.7'
            }
        }  
        
        stage ('Docker Compose') {
            steps {
               sh 'docker-compose up -d'
            }
        } }
}