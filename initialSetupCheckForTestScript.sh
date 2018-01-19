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

#executing the stop of the both envs (delivery and authoring)
echo "[INFO] executing gradlew stop process"
./gradlew stop
#here we need to check if the output was success
if [ $? -eq 0 ]; then
   echo "[INFO] executed stop with success"
   else 
   echo "[ERROR] the stop proccess failed"
fi

#moving out from temporary
echo "[INFO] moving out from temporary"
cd ../..

#deleting temporary folder
echo "[INFO] deleting the temporary folder"
rm -rf crafter_cms_temp
