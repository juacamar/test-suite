#!/bin/bash
#clearing the terminal  
clear
#asuming that the script is on the test-suite folder we should move out from craftercms
echo "[INFO] moving out from craftercms / src / test-suite folder"
cd ../../..

if [ -d "crafter_cms_temp" ]; then
    #deleting temporary folder
        echo "[INFO] crafter_cms_temp folder already exists, deleting temporary folder"
        rm -rf crafter_cms_temp
fi

#creating temporary folder
    echo "[INFO] creating temporary folder to test installation of craftercms"
    mkdir crafter_cms_temp
#moving to temporary folder
    echo "[INFO] moving to temporary folder"
    cd crafter_cms_temp
#Cloning the craftercms repo to local
    echo "[INFO] cloning the craftercms to local"
    git clone https://github.com/craftercms/craftercms.git
#changing to the craftercms folder just cloned
    echo "[INFO] moving to craftercms folder"
    cd craftercms   
#moving to develop branch
    echo "[INFO] moving to develop branch"
    git checkout develop
#executing the ./gradlew init
    echo "[INFO] executing gradlew init process"
    ./gradlew init -Pcrafter.git.shallowClone=true
#executing the ./gradlew init and build and deploy
    echo "[INFO] executing gradlew build&deploy process, using smtp port=2525"
    ./gradlew build deploy -Pauthoring.studio.smtp.port=2525
#here we need to check if the output was success 
    if [ $? -eq 0 ]; then
       echo "[INFO] executed gradlew build&deploy with success"
    else 
      echo "[ERROR] the gradlew build&deploy proccesses failed"
    fi
#executing the start up of the both envs (delivery and authoring)
echo "[INFO] executing gradlew startup process"
./gradlew start

#here we need to check if the output was success
if [ $? -eq 0 ]; then
   echo "[INFO] executed startup with success"
   else 
   echo "[ERROR] the startup proccess failed"
fi

#waiting for 5 minutes until the studio is totally up
echo "[INFO] waiting until studio is totally up. The Waitime is 5 minutes"
sleep 300

echo "[INFO] verifying that the port 8080 (Tomcat) is listened"
netstat -n -a | grep "*.8080"
if [ ! $? -eq 0 ]; then
   echo "[ERROR] the startup process failed Port 8080 (Tomcat) is not up after 5 minutes"
fi

echo "[INFO] verifying that the port 8694 (Solr) is listened"
netstat -n -a | grep "*.8694"
if [ ! $? -eq 0 ]; then
   echo "[ERROR] the startup process failed Port 8694 (Solr) is not up after 5 minutes"
fi

echo "[INFO] verifying that the port 33306 (MariaDB) is listened"
netstat -n -a | grep "*.33306"
if [ ! $? -eq 0 ]; then
   echo "[ERROR] the startup process failed Port 33306 (MariaDB) is not up after 5 minutes"
fi

echo "[INFO] verifying that the port 9191 (MariaDB) is listened"
netstat -n -a | grep "*.9191"
if [ ! $? -eq 0 ]; then
   echo "[ERROR] the startup process failed Port 33306 (MariaDB) is not up after 5 minutes"
fi

echo "[INFO] verifying that the port 27020 (MongoDB) is listened"
netstat -n -a | grep "*.27020"
if [ ! $? -eq 0 ]; then
   echo "[WARN] the startup process failed Port 27020 (MongoDB) is not up after 5 minutes"
fi


#executing the stop of the both envs (delivery and authoring)
echo "[INFO] executing gradlew stop process"
./gradlew stop

#here we need to check if the output was success
if [ $? -eq 0 ]; then
   echo "[INFO] executed stop with success"
   else 
   echo "[ERROR] the stop proccess failed"
fi

#waiting for 5 minutes until the studio is totally down
echo "[INFO] waiting until studio is totally down. The Waitime is 5 minutes"
sleep 300

echo "[INFO] verifying that the port 8080 (Tomcat) is not listened"
netstat -n -a | grep "*.8080"
if [ $? -eq 0 ]; then
 echo "[ERROR] the stop process failed Port 8080 (Tomcat) is not down after 5 minutes"
fi

echo "[INFO] verifying that the port 8694 (Solr) is not listened"
netstat -n -a | grep "*.8694"
if [ $? -eq 0 ]; then
 echo "[ERROR] the stop process failed Port 8694 (Solr) is not down after 5 minutes"
fi

echo "[INFO] verifying that the port 33306 (MariaDB) is not listened"
netstat -n -a | grep "*.33306"
if [ $? -eq 0 ]; then
 echo "[ERROR] the stop process failed Port 33306 (MariaDB) is not down after 5 minutes"
fi

echo "[INFO] verifying that the port 9191 (MariaDB) is not listened"
netstat -n -a | grep "*.9191"
if [ $? -eq 0 ]; then
 echo "[ERROR] the stop process failed Port 9191 (MariaDB) is not down after 5 minutes"
fi

echo "[INFO] verifying that the port 27020 (MongoDB) is not listened"
netstat -n -a | grep "*.27020"
if [ $? -eq 0 ]; then
 echo "[WARN] the stop process failed Port 27020 (MongoDB) is not down after 5 minutes"
fi

#moving out from temporary
echo "[INFO] moving out from temporary"
cd ../..

#deleting temporary folder
echo "[INFO] deleting the temporary folder"
rm -rf crafter_cms_temp
