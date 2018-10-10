# About
This project perform a construct query on a defined SPARQL endpoint. It is possible to optionally define username and password.

This Docker container is part of the data2services pipeline (https://github.com/MaastrichtU-IDS/data2services-pipeline/).

# Docker
## Build
```shell
docker build -t data-constructor .
```
## Usage
```shell
# docker run -it --rm rdf-upload -?

Usage: rdfupload [-?] [-ep=<endpoint>] -if=<inputFile> [-pw=<passWord>]
                 -rep=<repository> [-uep=<updateEndpoint>] [-un=<userName>]
                 -url=<url>
  -?, --help   display a help message
      -ep, --endPoint=<endpoint>
               SPARQL endpoint URL
      -rq, --request-dir=<RequestDir>
               RDF file path
      -pw, --Password=<passWord>
               Password used for authentication
      -rep, --repository=<repository>
               Repository ID
      -uep, --updateEndPoint=<updateEndpoint>
               SPARQL udpate endpoint
      -un, --userName=<userName>
               Username userd for authentication
      -url, --graphdb-url=<url>
               URL to access GraphDB (e.g.: http://localhost:7200)

```
## Run
### For SPARQLRepository

* Linux / OSX

```shell
docker run -it --rm -v /data/rdfu:/data rdf-upload -rq "/data/rdffile.nt" -ep "http://localhost:7200/sparql"
```
* Windows

```powershell
docker run -it --rm -v /c/data/rdfu:/data rdf-upload -rq "/data/rdffile.nt" -ep "http://localhost:7200/sparql"
```


