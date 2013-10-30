package org.mule.transport.cutome.transformers;
//author: NHC
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.ModelFactory;

@ContainsTransformerMethods 
public class SemanticTranslator{
	@Transformer
	  public String translate(String s) throws MalformedURLException
	  {
		//1. parse input
		OntModel input = ModelFactory.createOntologyModel();
		input.read(s,null);
		
		String mapping_URL = "";
		String queryString = "";
		InputStream in_mapping = null;
		//2. retrieve mapping
		try {
			in_mapping = new FileInputStream(new File(mapping_URL));
			//merge the input with the mapping
			input.add(ModelFactory.createDefaultModel().read(in_mapping,null));
			in_mapping.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3. reasoning with Pellet
		OntModel inferred = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC, input);
		inferred.prepare();
		//4. serialization result
		Query query = QueryFactory.create(queryString);
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, inferred);
		ResultSet results = qe.execSelect();
		// Output query results	
	    return ResultSetFormatter.asXMLString(results);
	  }
}
