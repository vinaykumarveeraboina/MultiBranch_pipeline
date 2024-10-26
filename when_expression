pipeline{
    agent any
    
    stages{
        
        stage ('deploy to dev'){  /*If we want to execute the stage env , when branch is with release*/
            when {
                    branch 'release-*' 
            }
        }  
            steps{
                echo "deploying to stage env "
            }
          
    }
       
 }
