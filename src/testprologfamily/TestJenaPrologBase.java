/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprologfamily;

import IP_Jena.IPConnPrologJenaModel;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ReasonerRegistry;
import com.hp.hpl.jena.util.FileManager;
import org.apache.jena.riot.RDFDataMgr;
import static testprologfamily.Constants.getFamilyDataFile;
import static testprologfamily.Constants.getFamilySchemaFile;
import static testprologfamily.Constants.getPrologFile;
import static testprologfamily.Constants.getXSBloc;

/**
 *
 * @author mba
 */
public abstract class TestJenaPrologBase {
    protected InfModel infModel;
        
    public TestJenaPrologBase() {
        Constants.inicConstants();
        
        Reasoner reasonerOWL = ReasonerRegistry.getOWLMiniReasoner();
        reasonerOWL = reasonerOWL.bindSchema(FileManager.get().loadModel(getFamilySchemaFile()));

        Model dataModel = ModelFactory.createDefaultModel();
        RDFDataMgr.read(dataModel, getFamilyDataFile()) ;
        
        infModel = ModelFactory.createInfModel(reasonerOWL, dataModel);                
    }    
    
    public void close() {
        infModel.close();
    }
}
