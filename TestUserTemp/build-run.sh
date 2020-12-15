#!/bin/sh
mvn clean package && docker build -t dhaval164/TestUserTemp .
docker rm -f TestUserTemp 2>/dev/null || true && docker run -it --name TestUserTemp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name TestUserTemp dhaval164/TestUserTemp
