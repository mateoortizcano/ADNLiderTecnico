pipeline {
	agent {
		label 'Slave_Induccion'
	}
	options {
		buildDiscarder(logRotator(numToKeepStr: '3'))
		disableConcurrentBuilds()
	}
	tools {
		jdk 'JDK13_Centos'
	}
	stages{
		stage('Checkout') {
			steps {
				echo "-------------------->Checkout<--------------------"
				checkout([
					$class: 'GitSCM', 
					branches: [[name: '*/develop']], 
					doGenerateSubmoduleConfigurations: false, 
					extensions: [], 
					gitTool: 'Default', 
					submoduleCfg: [], 
					userRemoteConfigs: [[
						credentialsId: 'GitHub_mateoortizcano', 
						url:'https://github.com/mateoortizcano/ADNLiderTecnico'
					]]
				])
			}
		}
		stage('Clean project') {
			steps {
				sh 'chmod +x comun/gradlew'
				echo "-------------------->Clean project<--------------------"
				dir("microservicio") {
					sh '../comun/gradlew clean'
				}
			}
		}
		stage('Compile project') {
			steps {
				echo "-------------------->Compile project<--------------------"
				dir("microservicio") {
					sh '../comun/gradlew build -x test -x bootJar'
				}
			}
		}
		stage('Test project and code coverage') {
			steps {
				echo "-------------------->Test project and code coverage<--------------------"
				dir("microservicio") {
					sh '../comun/gradlew test jacocoTestReport'
				}
			}
		}
		stage('Sonar Analysis'){
			steps{
				echo '-------------------->Sonar analysis<--------------------'
				  withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dsonar.projectKey=co.com.ceiba:adn.mateo.ortiz.backend -Dsonar.projectName=Ceiba-ADN\(mateo.ortiz\).Backend -Dproject.settings=./sonar-project.properties"
				 }
			}
		}
	}
}
