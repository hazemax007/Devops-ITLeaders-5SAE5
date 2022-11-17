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

        stage('MVN BUILD/COMPILE') {
            steps {
                sh "mvn compiler:compile"
                 sh 'mvn  clean install '
            }
        }

        stage('JUNIT/MOCKITO TESTS') {
            steps {
                sh 'mvn test'
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.login=4ff83c8cef6d630c43d7943e114eef445e663fb3"
            }
        }


        stage ('NEXUS DEPLOY') {
            steps {
                sh 'mvn  clean deploy -DskipTests'
            }
        }

        stage ('BUILD DOCKER IMAGES') {
            steps {
                sh 'docker build -t raoudhazid/achat:latest .'

            }
        }

        stage ('Docker Login') {
            steps {
                echo " Docker login ...."
                sh 'docker login -u raoudhazid -p 25412980omi'

            }
        }

        stage ('Docker Push') {

            steps {
                echo "Docker pushing ...."
             	sh 'docker push raoudhazid/achat:latest'
            }
        }
       stage ('Docker Compose') {
            steps {
               sh 'docker-compose up -d'
            }
        }


    }

     post {

                        success {
                            mail to: "raoudha.zid@esprit.tn",
                            body: "Great work ",
                            from: 'raoudha.zid@esprit.tn',
                            subject: "Jenkins is Build "
                        }

                        failure{
                            mail to: "raoudha.zid@esprit.tn",
                            subject: "Jenkins failed",
                            from: 'raoudha.zid@esprit.tn',
                            body: "we are sorry to inform you that your pipeline build has failed.  Keep working ! "
                        }

                        changed{
                            mail to: "raoudha.zid@esprit.tn",
                            subject: "Jenkins build changes",
                            from: 'raoudha.zid@esprit.tn',
                            body: " ther's a changes in ur jenkins build "
                        }

}