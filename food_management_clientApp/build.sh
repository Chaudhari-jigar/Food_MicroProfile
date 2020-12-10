#!/bin/sh
mvn clean package
docker build -t jigs4699/food_management_clientApp .
