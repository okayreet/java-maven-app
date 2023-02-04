def gv

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'choice decription')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'boolean params decription')
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                    echo 'building jar'
                    gv.buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo 'building image'
                    gv.buildImage()
                }
            }
        }
        stage('test') {
            when{
                expression {
                    params.executeTests
                }
            }


            steps {
                script {
                    echo 'testing'
                    gv.testApp()
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo 'deploying'
                    gv.deployApp()
                }
            }
        }
    }   
}