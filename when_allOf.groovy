pipeline{
    agent any
    environment{
        DEPLOY_to = 'develop'
    }
    stages{
        
        stage ('deploy to dev'){  //we are saying excute this job only in develop (job)
            when {
                expression {
                    BRANCH_NAME == "develop" 
                }
              }  
              steps{
                echo "deploying to develop branch "
              }
          
            }
       
        stage ('testing all off condition') {
            when {
                anyOf { //any of the below condition can be satisfied 
                   branch 'develop' 
                   environment name :'DEPLOY_to', value : 'develop'
                } 
                }
             steps{
                  echo " deploying to '${BRANCH_NAME}'"
                  
                }
        }
     }
}
  
