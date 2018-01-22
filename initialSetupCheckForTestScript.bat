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
call git checkout develop

@rem executing the gradlew.bat init 
echo [INFO] executing gradlew init process
call gradlew.bat init -P"crafter.git.shallowClone=true"

@rem executing the gradlew.bat build and deploy
echo [INFO] executing gradlew build and deploy processes, using smtp port=2525
call gradlew.bat build deploy -P"authoring.studio.smtp.port=2525"

@rem here we need to check if the output was success 
IF /I "%ERRORLEVEL%" NEQ "0" (
echo [ERROR] the gradlew build and deploy processes failed
) ELSE (
echo [INFO] executed gradlew build and deploy processes with success
)  

@rem executing the start up of the both envs delivery env and authoring env
echo [INFO] executing gradlew startup process
call gradlew.bat start

@rem waiting for 5 minutes until the studio is totally up
echo [INFO] waiting until studio is totally up. The Waitime is 5 minutes
timeout 300

echo [INFO] verifying that the port 8080 (Tomcat) is listened
netstat -o -n -a | findstr "0.0.0.0:8080"
IF %ERRORLEVEL% NEQ 0 echo [ERROR] the startup process failed Port 8080 (Tomcat) is not up after 5 minutes

echo [INFO] verifying that the port 8694 (Solr) is listened
netstat -o -n -a | findstr "0.0.0.0:8694"
IF %ERRORLEVEL% NEQ 0 echo [ERROR] the startup process failed Port 8694 (Solr) is not up after 5 minutes

echo [INFO] verifying that the port 33306 (MariaDB) is listened
netstat -o -n -a | findstr "0.0.0.0:33306"
IF %ERRORLEVEL% NEQ 0  echo [ERROR] the startup process failed Port 33306 (MariaDB) is not up after 5 minutes

echo [INFO] verifying that the port 9191 (MariaDB) is listened
netstat -o -n -a | findstr "0.0.0.0:9191"
IF %ERRORLEVEL% NEQ 0  echo [ERROR] the startup process failed Port 33306 (MariaDB) is not up after 5 minutes

echo [INFO] verifying that the port 27020 (MongoDB) is listened
netstat -o -n -a | findstr "0.0.0.0:27020"
IF %ERRORLEVEL% NEQ 0  echo [WARN] the startup process failed Port 27020 (MongoDB) is not up after 5 minutes

@rem executing the stop of the both envs delivery env and authoring env
echo [INFO] executing gradlew stop process
call gradlew.bat stop

@rem waiting for 5 minutes until the studio is totally down
echo [INFO] waiting until studio is totally down. The Waitime is 5 minutes
timeout 300

echo [INFO] verifying that the port 8080 (Tomcat) is not listened
netstat -o -n -a | findstr "0.0.0.0:8080"
IF %ERRORLEVEL% equ 0  echo [ERROR] the stop process failed Port 8080 (Tomcat) is not down after 5 minutes

echo [INFO] verifying that the port 8694 (Solr) is not listened
netstat -o -n -a | findstr "0.0.0.0:8694"
IF %ERRORLEVEL% equ 0 echo [ERROR] the stop process failed Port 8694 (Solr) is not down after 5 minutes

echo [INFO] verifying that the port 33306 (MariaDB) is not listened
netstat -o -n -a | findstr "0.0.0.0:33306"
IF %ERRORLEVEL% equ 0 echo [ERROR] the stop process failed Port 33306 (MariaDB) is not down after 5 minutes

echo [INFO] verifying that the port 9191 (MariaDB) is not listened
netstat -o -n -a | findstr "0.0.0.0:9191"
IF %ERRORLEVEL% equ 0 echo [ERROR] the stop process failed Port 33306 (MariaDB) is not down after 5 minutes

echo [INFO] verifying that the port 27020 (MongoDB) is not listened
netstat -o -n -a | findstr "0.0.0.0:27020"
IF %ERRORLEVEL% equ 0 echo [WARN] the stop process failed Port 27020 (MongoDB) is not down after 5 minutes

@rem moving out of temporary folder
echo [INFO] moving out from temporary folder
cd ../..

echo "Please close all terminal windows (but this one) to continue
pause
@rem deleting temporary folder
echo [INFO] deleting the temporary folder
rd /s /q crafter_cms_temp