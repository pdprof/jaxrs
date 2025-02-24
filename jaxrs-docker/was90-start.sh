#!/bin/bash
#if [ `docker network ls | grep pdprof-network | wc -l` == 0 ]; then
#	echo "Create pdprof-network..."
#	docker create network pdprof-network
#else
#	echo "pdprof-network exists."
#fi
docker run -d -p 9060:9060 -p 9043:9043 -p 9080:9080 -p 9443:9443 --name was90-jaxrs was90-jaxrs
