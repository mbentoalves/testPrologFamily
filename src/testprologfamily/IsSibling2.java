/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprologfamily;

import IP_Jena.IPBuiltin;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.reasoner.rulesys.RuleContext;

/**
 *
 * @author mba
 */
public class IsSibling2 extends IPBuiltin{

    @Override
    public String getName() {
        return "IsSibling2";
    }

    @Override
    public int getArgLength() {
        return 2;
    }
    
    public IsSibling2(String XSBloc, String fprologfile) {
        super(XSBloc, fprologfile, "isSibling2");
    }
}
