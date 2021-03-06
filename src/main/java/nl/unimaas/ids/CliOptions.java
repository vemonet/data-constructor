package nl.unimaas.ids;

import nl.unimaas.ids.sparql.QueryOperations;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "dataconstructor")
public class CliOptions {
	@Option(names = { "-?", "--help" }, usageHelp = true, description = "Display a help message")
	boolean help = false;
	
	@Option(names= {"-rq", "--request-dir"}, description = "RDF file path.", required = true)
	String inputFile = null;
	
	@Option(names= {"-op", "--operation"}, description = "SPARQL query operation (select, construct, insert). Default is insert")
	QueryOperations queryOperation = QueryOperations.insert;

	@Option(names= {"-url", "--database-url"}, description = "URL for Repository/Endpoint", required = true)
	String dbUrl = null;

	@Option(names= {"-rep", "--repositoryId"}, description = "RDF4J Repository ID for HTTPRepository file upload (only required in case of RDF4JSPARQL or HTTP method)")
	String repositoryId = null;

	@Option(names= {"-un", "--username"}, description = "Username used for authentication")
	String username = null;

	@Option(names= {"-pw", "--password"}, description = "Password used for authentication")
	String password = null;


}