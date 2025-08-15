@Library('sharedlibrary2') _

pipeline 
{
    agent any
    stages
    {
        stage('git download')
        {
            steps 
            {
                script 
                {
                    cicd.gitdownload('Maven1')
                }
            }
        }
        
        stage('git build')
        {
            steps 
            {
                script 
                {
                    cicd.build()
                }
            }
        }
        
        stage('git deployment')
        {
            steps 
            {
                script 
                {
                        cicd.deployment('pipeline shared', '172.31.12.169')
                }
            }
        }
        
        stage('git testing')
        {
            steps 
            {
                script 
                {
                  cicd.test('pipeline shared')
                }
            }
        }
        
        
      stage('git release')
        {
            steps 
            {
                script 
                {
                        cicd.release('pipeline shared', '172.31.9.223')
                }
            }
        }
        
        
        
        
        
    }
}
