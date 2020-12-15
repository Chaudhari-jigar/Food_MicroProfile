#!/bin/sh
mvn clean package
docker build -t dhaval164/TestUserTemp .
