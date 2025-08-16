def gitdownload(repo)
{
  git branch: 'main', url: "https://github.com/Surja07/${repo}.git"
}


def mvnbuild()
{
  sh "mvn clean package"
}



def deployment(jobname, ip)
{
    sh """
        scp '${env.WORKSPACE}/${jobname}/target/*.jar' \
        ubuntu@${ip}:/home/ubuntu/demo3/
    """
}



def test(jobname)
{
    sh """
        javac '${env.WORKSPACE}/${jobname}/HelloWorld.java'
        java -cp '${env.WORKSPACE}/${jobname}' HelloWorld > '${env.WORKSPACE}/${jobname}/test_output.txt'
    """
}


def release (jobname,ip) 
{
  sh "scp '${env.WORKSPACE}/${jobname}/target/*.jar' ubuntu@${ip}:/home/ubuntu/demo3"
}
