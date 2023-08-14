pipeline {
    agent any
    // -- Display a timestamp on the log.
    options{timestamps()}
    stages {
        stage("Initial UI Configuration") {
        steps {

            script {
                // -- Set the Directory of the files in the workspace
                JOB_FILES_DIRECTORY = "${workspace}"+"/src/test/resources/ui/features"
              
            }

            // -- Clean Workspace
            echo "Clean Workspace"
            cleanWs()
        }
    }
    
    // Parameters needed: JOB_GIT_BRANCH, JOB_GIT_URL, GIT_CREDENTIAL
    // --------------------------------
    // -- STAGE: Download GIT Code
    // --------------------------------
    stage("Download GIT Code") {
        steps {
            script {
                try {
                   // -- Download GIT Code 
                    echo "Downloading GIT Code from"

                    //-- Git checkout
                    git "https://tools.publicis.sapient.com/bitbucket/scm/hsbcwcl/testx-web-selenium.git"
                    branch "jenkins_pipeline"

                } catch (err) { 
                    echo "The Download GIT Code Stage failed"                                          
                }
            }   
        }
    }
stage("Build UI Test"){
    steps{
    bat "mvn clean install -DTest=RunUITest"
    
}}
stage("UI Results"){
    steps{
        
publishHTML([allowMissing: false,
         alwaysLinkToLastBuild: true,
         keepAll: true,
         reportDir: 
        '/target/cucumber-html-reports',
         reportFiles: 'overview-features.html',
         reportName: 'overview-features'
         ])
    
}}
         stage("Initial API Configuration") {
        steps {

            script {
                // -- Set the Directory of the files in the workspace
                JOB_FILES_DIRECTORY = "${workspace}"+"/src/test/resources/api/features"
              
            }

            // -- Clean Workspace
            echo "Clean Workspace"
            cleanWs()
        }
    }
    
    // Parameters needed: JOB_GIT_BRANCH, JOB_GIT_URL, GIT_CREDENTIAL
    // --------------------------------
    // -- STAGE: Download GIT Code
    // --------------------------------
    stage("Download API GIT Code") {
        steps {
            script {
                try {
                   // -- Download GIT Code 
                    echo "Downloading GIT Code from"

                    //-- Git checkout
                    git "https://tools.publicis.sapient.com/bitbucket/scm/hsbcwcl/testx-web-selenium.git"
                    branch "jenkins_pipeline"

                } catch (err) { 
                    echo "The Download GIT Code Stage failed"                                          
                }
            }   
        }
    }
stage("Build API Test"){
    steps{
    bat "mvn clean install -DTest=RunAPITest"
}}
 stage(" API Results"){
    steps{
        
publishHTML([allowMissing: false,
         alwaysLinkToLastBuild: true,
         keepAll: true,
         reportDir: 
        '/target/cucumber-html-reports',
         reportFiles: 'overview-features.html',
         reportName: 'overview-features'
         ])
    
}}}
    }
