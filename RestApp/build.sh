#!/bin/sh
mvn clean package
docker build -t jigs4699/RestApp .
