#!/bin/sh
mvn clean package && docker build -t dhaval164/TestProductTemp .
docker rm -f TestProductTemp 2>/dev/null || true && docker run -it --name TestProductTemp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name TestProductTemp dhaval164/TestProductTemp
