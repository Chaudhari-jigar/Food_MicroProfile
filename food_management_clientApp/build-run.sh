#!/bin/sh
mvn clean package && docker build -t jigs4699/food_management_clientApp .
docker rm -f food_management_clientApp 2>/dev/null || true && docker run -it --name food_management_clientApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name food_management_clientApp jigs4699/food_management_clientApp
