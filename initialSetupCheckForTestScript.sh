#!/bin/bash
#results file for the executions
FILELOCATION=$(pwd)
FILENAME=$FILELOCATION"/PreTestResults.txt"

if [ -f "PreTestResults.txt" ]; then
    #deleting previous results file
     rm PreTestResults.txt
     else 
     touch PreTestResults.txt
fi

echo "[INFO] Execution outputs will be put on the next file: "$FILENAME

#clearing the terminal  
clear
#asuming that the script is on the test-suite folder we should move out from craftercms
echo "[INFO] moving out from craftercms / src / test-suite folder" | tee $FILENAME
cd ../../..

if [ -d "crafter_cms_temp" ]; then
    #deleting temporary folder
        echo "[INFO] crafter_cms_temp folder already exists, deleting temporary folder" | tee -a $FILENAME
        rm -rf crafter_cms_temp
fi

#creating temporary folder
    echo "[INFO] creating temporary folder to test installation of craftercms" | tee -a $FILENAME
    mkdir crafter_cms_temp
#moving to temporary folder
    echo "[INFO] moving to temporary folder" | tee -a $FILENAME
    cd crafter_cms_temp
#Cloning the craftercms repo to local
    echo "[INFO] cloning the craftercms to local" | tee -a $FILENAME
    git clone https://github.com/craftercms/craftercms.git | tee -a $FILENAME
#changing to the craftercms folder just cloned
    echo "[INFO] moving to craftercms folder" | tee -a $FILENAME
    cd craftercms   
#moving to develop branch
    echo "[INFO] moving to develop branch" | tee -a $FILENAME
    git checkout develop | tee -a $FILENAME
#executing the ./gradlew init
    echo "[INFO] executing gradlew init process" | tee -a $FILENAME
    ./gradlew init -Pcrafter.git.shallowClone=true | tee -a $FILENAME
#executing the ./gradlew init and build and deploy
    echo "[INFO] executing gradlew build&deploy process, using smtp port=2525" | tee -a $FILENAME
    ./gradlew build deploy -Pauthoring.studio.smtp.port=2525 | tee -a $FILENAME
#here we need to check if the output was success 
    if [ $? -eq 0 ]; then
       echo "[INFO] executed gradlew build&deploy with success" | tee -a $FILENAME
    else 
      echo "[ERROR] the gradlew build&deploy proccesses failed" | tee -a $FILENAME
    fi
#executing the start up of the both envs (delivery and authoring)
echo "[INFO] executing gradlew startup process" | tee -a $FILENAME
./gradlew start | tee -a $FILENAME

#waiting for 5 minutes until the studio is totally up
echo "[INFO] waiting until studio is totally up. The Waitime is 5 minutes" | tee -a $FILENAME
sleep 300

echo "[INFO] verifying that the port 8080. Tomcat is listened" | tee -a $FILENAME
netstat -n -a | grep "*.8080"
if [ ! $? -eq 0 ]; then
   echo "[ERROR] the startup process failed Port 8080. Tomcat is not up after 5 minutes" | tee -a $FILENAME
fi

echo "[INFO] verifying that the port 8694. Solr is listened" | tee -a $FILENAME
netstat -n -a | grep "*.8694"
if [ ! $? -eq 0 ]; then
   echo "[ERROR] the startup process failed Port 8694. Solr is not up after 5 minutes" | tee -a $FILENAME
fi

echo "[INFO] verifying that the port 33306. MariaDB is listened" | tee -a $FILENAME
netstat -n -a | grep "*.33306"
if [ ! $? -eq 0 ]; then
   echo "[ERROR] the startup process failed Port 33306. MariaDB is not up after 5 minutes" | tee -a $FILENAME
fi

echo "[INFO] verifying that the port 9191. MariaDB is listened" | tee -a $FILENAME
netstat -n -a | grep "*.9191"
if [ ! $? -eq 0 ]; then
   echo "[ERROR] the startup process failed Port 33306. MariaDB is not up after 5 minutes" | tee -a $FILENAME
fi

echo "[INFO] verifying that the port 27020. MongoDB is listened" | tee -a $FILENAME
netstat -n -a | grep "*.27020"
if [ ! $? -eq 0 ]; then
   echo "[WARN] the startup process failed Port 27020. MongoDB is not up after 5 minutes" | tee -a $FILENAME
fi

#executing the stop of the both envs delivery and authoring
echo "[INFO] executing gradlew stop process" | tee -a $FILENAME
./gradlew stop | tee -a $FILENAME

#waiting for 5 minutes until the studio is totally down
echo "[INFO] waiting until studio is totally down. The Waitime is 5 minutes" | tee -a $FILENAME
sleep 300

echo "[INFO] verifying that the port 8080. Tomcat is not listened" | tee -a $FILENAME
netstat -n -a | grep "*.8080"
if [ $? -eq 0 ]; then
 echo "[ERROR] the stop process failed Port 8080. Tomcat is not down after 5 minutes" | tee -a $FILENAME
fi

echo "[INFO] verifying that the port 8694. Solr is not listened" | tee -a $FILENAME
netstat -n -a | grep "*.8694"
if [ $? -eq 0 ]; then
 echo "[ERROR] the stop process failed Port 8694. Solr is not down after 5 minutes" | tee -a $FILENAME
fi

echo "[INFO] verifying that the port 33306. MariaDB is not listened" | tee -a $FILENAME
netstat -n -a | grep "*.33306"
if [ $? -eq 0 ]; then
 echo "[ERROR] the stop process failed Port 33306. MariaDB is not down after 5 minutes" | tee -a $FILENAME
fi

echo "[INFO] verifying that the port 9191. MariaDB is not listened" | tee -a $FILENAME
netstat -n -a | grep "*.9191"
if [ $? -eq 0 ]; then
 echo "[ERROR] the stop process failed Port 9191. MariaDB is not down after 5 minutes" | tee -a $FILENAME
fi

echo "[INFO] verifying that the port 27020. MongoDB is not listened" | tee -a $FILENAME
netstat -n -a | grep "*.27020"
if [ $? -eq 0 ]; then
 echo "[WARN] the stop process failed Port 27020. MongoDB is not down after 5 minutes" | tee -a $FILENAME
fi

#moving out from temporary
echo "[INFO] moving out from temporary" | tee -a $FILENAME
cd ../..

#deleting temporary folder
echo "[INFO] deleting the temporary folder" | tee -a $FILENAME
rm -rf crafter_cms_temp