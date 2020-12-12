#!/bin/sh
mvn clean package && docker build -t jigs4699/uiAPP .
docker rm -f uiAPP 2>/dev/null || true && docker run -it --name uiAPP -p 8080:8080 -p 4848:4848 -p 8181:8181 --name uiAPP jigs4699/uiAPP
