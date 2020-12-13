#!/bin/sh
#deploy="false"
deploy="true"

image=TestProductTemp
version=1.0-SNAPSHOT
latest=true

#OPTIONS="--no-cache --force-rm"
#OPTIONS="--no-cache"
#OPTIONS="--force-rm"
OPTIONS=""

docker build ${OPTIONS} -t dhaval164/${image}:1.0-SNAPSHOT .
if [ "$?" -eq 0 ] && [ ${deploy} == "true" ]; then
    docker push dhaval164/${image}:1.0-SNAPSHOT
    if [ "$latest" == "true" ]; then
        docker tag dhaval164/${image}:1.0-SNAPSHOT dhaval164/${image}:latest
        docker push dhaval164/${image}:latest
    fi
fi