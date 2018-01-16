@echo off
@rem clearing the terminal 
cls

@rem asuming that the script is on the test-suite folder we should move out from craftercms
echo [INFO] moving out from craftercms / src / test-suite folder
cd ../../..

IF EXIST crafter_cms_temp (
    @rem crafter_cms_temp folder already exists, deleting temporary folder
	echo [INFO] crafter_cms_temp folder already exists, deleting the temporary folder
	rd /s /q crafter_cms_temp
) 

@rem creating temporary folder
echo [INFO] creating crafter_cms_temp folder to test installation of craftercms
mkdir crafter_cms_temp

@rem moving to temporary folder
echo [INFO] moving to temporary folder
cd crafter_cms_temp

@rem Cloning the craftercms repo to local
echo [INFO] cloning the craftercms to local
git clone https://github.com/craftercms/craftercms.git

@rem changing to the craftercms folder just cloned
echo [INFO] moving to craftercms folder
cd craftercms

@rem moving to develop branch
echo [INFO] moving to develop branch
git checkout develop

@rem executing the .\gradlew.bat init 
echo [INFO] executing gradlew init process
gradlew.bat init 

@rem executing the .\gradlew.bat init
echo [INFO] executing gradlew build and deploy processes, using smtp port=2525
gradlew.bat build deploy -P"authoring.studio.smtp.port=2525" 

@rem here we need to check if the output was success 
IF /I "%ERRORLEVEL%" NEQ "0" (
echo [ERROR] the gradlew build and deploy processes failed
) ELSE (
echo [INFO] executed gradlew build and deploy processes with success
)  

@rem executing the start up of the both envs delivery env and authoring env
echo [INFO] executing gradlew startup process
gradlew.bat start

@rem here we need to check if the output was success
IF /I "%ERRORLEVEL%" NEQ "0" (
echo [ERROR] the startup process failed
) ELSE (
echo [INFO] executed gradlew start process with success
)

@rem executing the stop of the both envs delivery env and authoring env
echo [INFO] executing gradlew stop process
gradlew.bat stop

@rem here we need to check if the output was success
IF /I "%ERRORLEVEL%" NEQ "0" (
echo [ERROR] the stop process failed
) ELSE (
echo [INFO] executed gradlew stop process with success
)

@rem moving out of temporary folder
echo [INFO] moving out from temporary folder
cd ..

@rem deleting temporary folder
echo [INFO] deleting the temporary folder
rd /s /q crafter_cms_temp




