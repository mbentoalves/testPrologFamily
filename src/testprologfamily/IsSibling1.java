/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprologfamily;

import IP_Jena.IPBuiltin;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.NodeFactory;
import com.hp.hpl.jena.reasoner.rulesys.RuleContext;

/**
 *
 * @author mba
 */
public class IsSibling1 extends IPBuiltin{
    
    public IsSibling1(String XSBloc, String fprologfile) {
        super(XSBloc, fprologfile, "isSibling1");
    }    
    
    @Override
    public String getName() {
        return "IsSibling1";
    }
    

    @Override
    public int getArgLength() {
        return 2;
    }
    
    @Override
    public boolean bodyCall(Node[] args, int length, RuleContext context) {
        //System.out.println("nCall -> "+(++nCalls));
        return super.bodyCall(args, length, context);
    }

}
