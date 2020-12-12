#!/bin/sh
mvn clean package && docker build -t jigs4699/RestApp .
docker rm -f RestApp 2>/dev/null || true && docker run -it --name RestApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name RestApp jigs4699/RestApp
