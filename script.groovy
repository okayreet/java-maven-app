def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo 'building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credential', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t darkerror/react-java-app:jma-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push darkerror/react-java-app:jma-1.0'
    }
}
def testApp() {
    echo 'testing the application...'
    sh 'mvn test'
}

def deployApp() {
    echo 'deploying the application...'
}

return this
