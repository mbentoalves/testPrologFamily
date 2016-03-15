/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprologfamily;

import IP_Jena.PrologCall;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.rulesys.BuiltinRegistry;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import java.util.ArrayList;
import static testprologfamily.Constants.getJenaRulesFile;
import static testprologfamily.Constants.getPrologFile;
import static testprologfamily.Constants.getXSBloc;

/**
 *
 * @author mba
 */
public class TestJenaPrologContext  extends TestJenaPrologBase {

    private ArrayList<String> sparqlCmds;
    
    IsSibling1 vIsSibling1;
    IsSibling2 vIsSibling2;
    PrologCall vPrologCall;
    
    public TestJenaPrologContext() {
        super();
        
        GenericRuleReasoner reasonerRules = new GenericRuleReasoner(Rule.rulesFromURL(getJenaRulesFile()));
        reasonerRules.setOWLTranslation(true);               // not needed in RDFS case
        reasonerRules.setTransitiveClosureCaching(true);
        
        infModel = ModelFactory.createInfModel(reasonerRules, infModel);
        
        /*
        BuiltinRegistry.theRegistry.register(new IsSibling1(getXSBloc(), getPrologFile()));
        BuiltinRegistry.theRegistry.register(new IsSibling2(getXSBloc(), getPrologFile()));
        BuiltinRegistry.theRegistry.register(new PrologCall(getXSBloc(), getPrologFile()));
        */
        
        vIsSibling1 = new IsSibling1(getXSBloc(), getPrologFile());
        vIsSibling2 = new IsSibling2(getXSBloc(), getPrologFile());
        vPrologCall = new PrologCall(getXSBloc(), getPrologFile());
        
        BuiltinRegistry.theRegistry.register(vIsSibling1);
        BuiltinRegistry.theRegistry.register(vIsSibling2);
        BuiltinRegistry.theRegistry.register(vPrologCall);
        
        sparqlCmds = new ArrayList<>();
 
        sparqlCmds.add(
            "prefix fam: <http://www.example.org/family#> \n" +
            "\n" +
            "Select ?x ?y\n" +
            "where {\n" +
            "	?x fam:isSibling1 ?y .	\n" +
            "}");
        

        sparqlCmds.add(
            "prefix fam: <http://www.example.org/family#> \n" +
            "\n" +
            "Select ?x ?y\n" +
            "where {\n" +
            "	?x fam:isSibling2 ?y .	\n" +
            "}");     
        
        sparqlCmds.add(
            "prefix fam: <http://www.example.org/family#> \n" +
            "\n" +
            "Select ?x ?y\n" +
            "where {\n" +
            "	?x fam:isSibling3 ?y .	\n" +
            "}");
        
        sparqlCmds.add(
            "prefix fam: <http://www.example.org/family#> \n" +
            "\n" +
            "Select ?x ?y\n" +
            "where {\n" +
            "	?x fam:isSibling4 ?y .	\n" +
            "}");
 
    }
    
    public void run(){
        int i=0;
        for(String sparqlCmd : sparqlCmds){
            System.out.println("Sparql command:"+(++i)+"/"+sparqlCmds.size());
            Query query = QueryFactory.create(sparqlCmd) ;
            try (QueryExecution qexec = QueryExecutionFactory.create(query, infModel)) {
                ResultSet results = qexec.execSelect() ;
                for ( ; results.hasNext() ; )  {
                    QuerySolution soln = results.nextSolution() ;
                    System.out.println(soln.get("x")+";"+soln.get("y"));
                }     
            }
        }
        vIsSibling1.close();
        vIsSibling2.close();
        vPrologCall.close();
    }
    
    @Override
    public void close() {
        super.close();
    }
}
