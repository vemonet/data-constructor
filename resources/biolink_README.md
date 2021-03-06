http://docs.rdf4j.org/programming/#_accessing_a_sparql_endpoint_2

http://docs.rdf4j.org/programming/#_evaluating_a_graph_query



## KGX validation

```shell
# Activate env
source env/bin/activate
kgx validate file.ttl
```



## Valid BioLink

* Valid prefix for CURIE

https://github.com/monarch-initiative/dipper/blob/master/dipper/curie_map.yaml

* Spec

https://docs.google.com/document/d/1TrvqJPe_HwmRJ5HCwZ7fsi9_mwGcwLOZ53Fnjo8Sh4E/edit

Required for nodes: id, name, category



# RML

* Run it:

```shell
# HGNC
java -jar /home/vemonet/sandbox/rmlmapper-java/target/rmlmapper-4.0.0-r50-jar-with-dependencies.jar -c /home/vemonet/sandbox/rml_vs_sparql/rml/hgnc_config.properties

# DrugBank. Java heap space outOfMemory error (for 900M)
java -jar /home/vemonet/sandbox/rmlmapper-java/target/rmlmapper-4.0.0-r50-jar-with-dependencies.jar -c /home/vemonet/sandbox/rml_vs_sparql/rml/drugbank_config.properties
```



# SPARQL

Generating 2 types of generic SPARQL:

* From tabular (csv, tsv, RDBMS)
* From complex structure (XML, JSON, YAML)



### How we do

* For each attribute/node extracted we look for corresponding classes in BioLink Ontology

https://biolink.github.io/biolink-model/

https://raw.githubusercontent.com/biolink/biolink-model/master/ontology/biolink.ttl

https://bioportal.bioontology.org/ontologies/BLM

* TSV
  * Opening TSV file with calc and looking for concept matching columns in BioLink ontology
  * Opening  the Mapping file to get the exact URI of the column
* XML: using the schema printed by xml2rdf and the original XML file to look for matching concepts in BioLink ontology



### Limitations

* Needs to know really well the BioLink model
  * Can be hard to find some matching concepts in BioLink
  * What to do if no matching concept in BioLink?

* We can't build one big construct query. It needs to be divided in little construct queries with a focused goal
  * E.g.: getting targets infos
  * We need to avoid having too much query getting different arrays (result is a cartesian product)
* Problem: we first get all the hasChild and then filter on the type
  * **Why not putting the XPath directly in the predicate?**

### Enhancement

Also generating a generic construct query when generating the generic RDF (with AutoR2RML and xml2rdf) 

Then we "just" have to match it with the right bioentity class



* Automatically generate SPARQL query

The programs that do the generic RDF transformation should generate a file formally describing the data structure that is then used to generate the SPARQL construct query 



* Recommend class from an existing datamodel
  * Based on attribute name in the original file
  * Based on data 



* Create new nodes from the values? Example: Status in HGNC
  * Translate to ConfidenceLevel https://biolink.github.io/biolink-model/docs/ConfidenceLevel.html
  * We need to create 3 ConfidenceLevel for genes: Approved, Symbol Withdrawn, Entry Withdrawn. And then point the gene to this level with bioentity:related_to 









































