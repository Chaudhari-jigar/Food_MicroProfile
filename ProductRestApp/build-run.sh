#!/bin/sh
mvn clean package && docker build -t jigs4699/ProductRestApp .
docker rm -f ProductRestApp 2>/dev/null || true && docker run -it --name ProductRestApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name ProductRestApp jigs4699/ProductRestApp
