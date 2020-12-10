#!/bin/sh
#deploy="false"
deploy="true"

image=SampleProfileApp
version=1.0-SNAPSHOT
latest=true

#OPTIONS="--no-cache --force-rm"
#OPTIONS="--no-cache"
#OPTIONS="--force-rm"
OPTIONS=""

docker build ${OPTIONS} -t jigs4699/${image}:1.0-SNAPSHOT .
if [ "$?" -eq 0 ] && [ ${deploy} == "true" ]; then
    docker push jigs4699/${image}:1.0-SNAPSHOT
    if [ "$latest" == "true" ]; then
        docker tag jigs4699/${image}:1.0-SNAPSHOT jigs4699/${image}:latest
        docker push jigs4699/${image}:latest
    fi
fi