pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

       stage('Checkout') {
    steps {
        git branch: 'main', url: 'https://github.com/dhivyacheuwz/E-commerce-Selenium.git'
    }
}

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}