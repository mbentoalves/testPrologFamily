/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprologfamily;


/**
 *
 * @author mba
 */
public class TestPrologFamily {
    
    public static void main(String[] args) {

        TestJenaPrologGen vTestJenaPrologGen = new TestJenaPrologGen();
        vTestJenaPrologGen.run();

        TestJenaPrologModel vTestJenaPrologModel = new TestJenaPrologModel();
        vTestJenaPrologModel.run();
        vTestJenaPrologModel.close();

        
        TestJenaPrologContext vTestJenaPrologContext = new TestJenaPrologContext();
        vTestJenaPrologContext.run();
        vTestJenaPrologContext.close();

    }   
}
