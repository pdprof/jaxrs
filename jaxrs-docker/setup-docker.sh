#!/bin/bash
# if docker is used, you can use docker network
#network=`docker network ls | grep pdprof-network | wc -l`
#if test $network -lt 1; then
#    docker network create pdprof-network
#fi

# DOCKER_HOST=192.168.122.1

# Setup for SIBus
docker build -t jaxrs-client -f Dockerfile.jaxrs-client .

