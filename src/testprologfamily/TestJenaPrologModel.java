package testprologfamily;

import IP_Jena.IPConnPrologJenaModel;
import com.declarativa.interprolog.TermModel;
import static testprologfamily.Constants.getPrologFile;
import static testprologfamily.Constants.getXSBloc;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mba
 */
public class TestJenaPrologModel extends TestJenaPrologBase {

    IPConnPrologJenaModel vIPConnPrologJenaModel;
    
    public TestJenaPrologModel() {
        super(); 
        vIPConnPrologJenaModel = new IPConnPrologJenaModel();        
        vIPConnPrologJenaModel.init(getXSBloc(), getPrologFile(), infModel);

        vIPConnPrologJenaModel.registerPrefixesFromModel();
        vIPConnPrologJenaModel.registerPrefix("fam", "http://www.example.org/family#");
        vIPConnPrologJenaModel.registerPrefix("famData", "http://www.example.org/familyData#");
    }
    
    public void run() {
        String clause2 = "[TM]";
        String clause1 = "setof(sibling(X, Y), isSibling1(X, Y), L), buildTermModel(L,TM)";
        
        System.out.println("****** TestJEnaPrologModel -> term isSibling1 ******");
        
        Object [] bindings = vIPConnPrologJenaModel.run(clause1, clause2);
        
        TermModel list = (TermModel) (TermModel)bindings[0];
        
        if(bindings != null){
            int i=0;
            while(list.getChildCount()>0){
                System.out.println("result -> " + (++i) + " - "+list.getChild(0).toString());
                list = (TermModel) list.getChild(1);
            }
            System.out.println("Total results: " + i); 
        }    

        System.out.println("****** TestJEnaPrologModel -> term isSibling2 ******");
        
        clause1 = "setof(sibling(X, Y), isSibling2(X, Y), L), buildTermModel(L,TM)";
         
        bindings = vIPConnPrologJenaModel.run(clause1, clause2);
        
        list = (TermModel) (TermModel)bindings[0];
 
        if(bindings != null){
            int i=0;
            while(list.getChildCount()>0){
                System.out.println("result -> " + (++i) + " - "+list.getChild(0).toString());
                list = (TermModel) list.getChild(1);
            }
            System.out.println("Total results: " + i); 
        }   
        
        System.out.println("****** TestJEnaPrologModel -> term isSibling3 ******");
        
        clause1 = "isSibling3(L), buildTermModel(L,TM)";
         
        bindings = vIPConnPrologJenaModel.run(clause1, clause2);
        
        list = (TermModel) (TermModel)bindings[0];
 
        if(bindings != null){
            int i=0;
            while(list.getChildCount()>0){
                System.out.println("result -> " + (++i) + " - "+list.getChild(0).toString());
                list = (TermModel) list.getChild(1);
            }
            System.out.println("Total results: " + i); 
        }         
    }
    
    @Override
    public void close() {
        super.close();
        vIPConnPrologJenaModel.close();
    }
}
