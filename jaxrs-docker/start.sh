#!/bin/bash
if [ ! -d ~/pdprof ]; then
    mkdir ~/pdprof
fi
docker run -d --name jaxrs -p 9080:9080 -p 9443:9443 -v ~/pdprof:/pdprof jaxrs
