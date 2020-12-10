#!/bin/sh
mvn clean package && docker build -t jigs4699/SampleProfileApp .
docker rm -f SampleProfileApp 2>/dev/null || true && docker run -it --name SampleProfileApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name SampleProfileApp jigs4699/SampleProfileApp
