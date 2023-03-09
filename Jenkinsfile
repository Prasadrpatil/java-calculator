@Library("shared-library") _

pipeline {
    agent any
    
    tools {
        maven "maven"
        gradle "gradle"
        ant "ant"
    }
    environment {
        registry = 'prasadrpatil/java-demo'
        registryCredential = 'Dockerhub-Cred'
        COSIGN_PASSWORD=credentials('cosign-password')
        COSIGN_PRIVATE_KEY=credentials('cosign-private-key')
        COSIGN_PUBLIC_KEY=credentials('cosign-public-key')
    }

    stages {
        
        stage('Source Code Checkout') {
            steps{
                script{
                    codeCheckout(repository:"https://github.com/Prasadrpatil/java-calculator",branch:"main" ,credentialsId: "Github-Cred")
                }
            }
        }
        
       
        stage('Build Artifacts') {
            steps {
                script {
                    buildArtifacts(technology:"java" ,buildTool: "maven" , artifactType: "war")
                    //technology:- java/.net/node
                    //buildTool:- maven/gradle/ant/dotnet/npm/yarn
                    //artifactType:- jar/war/exe/dll/js
                }
            }
            post{
                success {
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        
        
        stage('Detect Secrets'){
             steps {
                 script{
                    secretDetect()
                }
             }
        }//whispers
        
    
        stage('SBOM') {
            steps {
                script{
                    sbomAnalysis() 
                    elasticSearchUtility.sbomScan() //Pushing SBOM Scanning logs to Elasticsearch
                }
            }
        }//snyk
        
        stage('SonarQube analysis') {
            steps{
                script{
                    sonarqubeAnalysis()
                }
            }
        }//SAST
        
        stage('Docker File Scan'){
            steps{
                script{
                    dockerFileScan()
                    elasticSearchUtility.dockerFileScan() //Pushing Docker file Scanning logs to Elasticsearch
                }
            }
        }//trivy
        
        stage('Build Docker Image'){
            steps{
                script{
                    dockerUtility.buildDockerImage()
                }
            }
        }
        
        stage('Push Image To Registry') {
            steps{
                script {
                    dockerUtility.pushDockerImage()
                }
            }
        }
      
        
        stage('Docker Image Scanning'){
            steps{
                script{
                    dockerImageScan()
                    elasticSearchUtility.dockerImageScan() //Pushing Image Scanning logs to Elasticsearch
                }
            }
        }//trivy
        
        stage('Image Signing') {
             steps {
                script{
                    cosignUtility.imageSigning()
                }
            }
        }//cosign
        
        stage('Image Verify'){
            steps{
                script{
                    cosignUtility.imageVerify()
                }
            }
        }//cosign
        
        stage('K8 Manifest Scanning'){
            steps{
                script{
                    k8ManifestScan() //elasticSearchUtility.k8ManifestScan()
                }
            }
        }//kubesec     
        
        
        
    }      
}
