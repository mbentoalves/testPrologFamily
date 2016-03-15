package testprologfamily;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mba
 */
public class TestJenaPrologGen  extends TestJenaPrologBase {
    public void run() {
        String sparqlCmd = 
            "prefix : <http://www.example.org/family#> \n" +
            "Select ?x ?y \n" +
            "where { \n" +
            "	?x :hasParent ?z . \n" +
            "	?y :hasParent ?z . \n" +
            "	filter(?x != ?y) . \n" +
            "}";
        
        Query query = QueryFactory.create(sparqlCmd) ;
        QueryExecution qexec = QueryExecutionFactory.create(query, infModel);
        ResultSet results = qexec.execSelect() ;
        ResultSetFormatter.out(results);
    }
    
}
