#!/bin/bash
#clearing the terminal  
clear
#asuming that the script is on the test-suite folder we should move out from craftercms
echo "[INFO] moving out from craftercms / src / test-suite folder"
cd ../../..
#creating temporal folder
echo "[INFO] creating temp folder to test installation of craftercms"
mkdir temp
#moving to temporal folder
echo "[INFO] moving from temporal folder"
cd temp

if [ -d "craftercms" ]; then
#moving to craftercms folder
    echo "[INFO] craftercms already exists, moving to craftercms folder"
    cd craftercms 
#moving to develop branch
    echo "[INFO] moving to develop branch"
    git checkout develop
#removing all the old enviroments
    echo "[INFO] removing old enviroments"
    rm -rf crafter-*
#executing the ./gradlew selfupdate 
    echo "[INFO] executing gradlew selfupdate process"
    ./gradlew selfupdate 
#executing the ./gradlew init 
    echo "[INFO] executing gradlew init process"
    ./gradlew init 
#executing the ./gradlew update 
    echo "[INFO] executing gradlew update process"
    ./gradlew update 
#executing the ./gradlew build and deploy, using smtp port=2525
    echo "[INFO] executing gradlew build&deploy processes, using smtp port=2525"
    ./gradlew build deploy -Pauthoring.studio.smtp.port=2525 
#here we need to check if the output was success 
    if [ $? -eq 0 ]; then
       echo "[INFO] executed gradlew build&deploy with success"
    else 
      echo "[ERROR] the gradlew build&deploy proccesses failed"
    fi
else 
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
    ./gradlew init
#executing the ./gradlew init and build and deploy
    echo "[INFO] executing gradlew build&deploy process, using smtp port=2525"
    ./gradlew build deploy -Pauthoring.studio.smtp.port=2525
#here we need to check if the output was success 
    if [ $? -eq 0 ]; then
       echo "[INFO] executed gradlew build&deploy with success"
    else 
      echo "[ERROR] the gradlew build&deploy proccesses failed"
    fi
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

#executing the stop of the both envs (delivery and authoring)
echo "[INFO] executing gradlew stop process"
./gradlew stop
#here we need to check if the output was success
if [ $? -eq 0 ]; then
   echo "[INFO] executed stop with success"
   else 
   echo "[ERROR] the stop proccess failed"
fi
#moving out of temporal
echo "[INFO] moving out from temporal"
cd ..

#deleting temporal folder
echo "[INFO] deleting the temporal folder"
rm -rf temp