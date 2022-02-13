# JAX-RS Application

## Requirements

- [Docker](https://www.docker.com/)

## Test on Docker

### Build docker image

```
./setup-docker.sh
```

### Start docker 

```
./jaxrs-start.sh
```

Now you can access http://localhost:9080/jaxrs.client/


## Test on OpenShift

After you setup CRC described at [icp4a-helloworld](https://github.com/pdprof/icp4a-helloworld)

You can use following script. 
```
setup-openshift.sh
```

Now you can access to follow URLs.

- [jaxrs.client](http://jaxrs-route-default.apps-crc.testing/jaxrs.client/)

Other test steps are same with docker.
