
def gitdownload(repo)
{
git branch: 'main', url: "https://github.com/Surja07/${repo}.git"
}
def build() {
echo 'Building the project using Maven...'
}

def deployment(jobname, ip)
{
    sh "scp '/var/lib/jenkins/workspace/${jobname}/HelloWorld.java' ubuntu@${ip}:/home/ubuntu/demo3"
}



def test(jobname) 
{
    sh """
        javac '${env.WORKSPACE}/HelloWorld.java'
        java -cp '${env.WORKSPACE}' HelloWorld > '${env.WORKSPACE}/test_output.txt'
    """
}


}

def release(jobname, ip) {
sh "scp /var/lib/jenkins/workspace/${jobname}/HelloWorld.java ubuntu@${ip}:/var/lib/tomcat10/webapps/"
}

