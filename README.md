# About
A project to execute a set of SPARQL queries using rdf4j. 

The user has to provide the path to the directory where the queries are stored in `.rq` text files.

*Insert* and *construct* queries are currently supported, *select* to come soon. 

It is possible to optionally define username and password for the SPARQL endpoint.

# Docker
## Build
```shell
docker build -t data-constructor .
```
## Usage
```shell
docker run -it --rm data-constructor -?
```
## Run
```shell
# Insert on graphdb.dumontierlab.com 
# GraphDB requires to add /statements at the end of the endpoint URL for INSERT
docker run -it --rm -v /data/data-constructor:/data data-constructor -rq "/data" -url "http://graphdb.dumontierlab.com/repositories/test/statements" -un username -pw password

# Construct using local SPARQL endpoint
docker run -it --rm -v /data/data-constructor:/data data-constructor -rq "/data" -url "http://localhost:7200/repositories/test" -op "construct"

# Using GraphDB docker
docker run -it --rm --link graphdb:graphdb -v /data/data-constructor:/data data-constructor -rq "/data" -url "http://graphdb:7200/repositories/test"
```
