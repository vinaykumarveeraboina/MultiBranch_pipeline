pipeline{
    agent any
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
       
        stage ('deploy to stage or production ') {
            when {
                expression {
                    BRANCH_NAME ==~ / (production|staging)  /     
                    /*BRANCH_NAME is defualut variable in jenins and only used in multi branch pipeline*/ /* deploy execute this stage only in prodution or staging job ,*/
                } 
                }
             steps{
                  echo " deploying to '${BRANCH_NAME}'"
                  
                }
        }
     }
}
  
