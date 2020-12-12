#!/bin/sh
mvn clean package && docker build -t jigs4699/TestCategoryTemp .
docker rm -f TestCategoryTemp 2>/dev/null || true && docker run -it --name TestCategoryTemp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name TestCategoryTemp jigs4699/TestCategoryTemp
