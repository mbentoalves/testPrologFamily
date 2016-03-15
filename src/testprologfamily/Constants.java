/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprologfamily;

import static genericClasses.genericClasses.getProperty;

/**
 *
 * @author mba
 */
public class Constants {
    static String XSBLOC = "/Volumes/DATA/MBA/Programs/XSB/bin/xsb";
    static String FAMSCHEMAFILELOC = "testFiles/familySchema.ttl";
    static String FAMDATAFILELOC = "testFiles/familyData.ttl";
    static String PROLOGFILELOC = "testFiles/familyRules.P";
    static String JENARULESFILE = "testFiles/familyDataRules.txt";
    
    public static void inicConstants() {
        readConstants();
    }
    
    public static void readConstants() {
        
        XSBLOC = getProperty("constants.config", "XSBLOC");
        FAMSCHEMAFILELOC = getProperty("constants.config", "FAMSCHEMAFILELOC");
        FAMDATAFILELOC = getProperty("constants.config", "FAMDATAFILELOC");
        PROLOGFILELOC = getProperty("constants.config", "PROLOGFILELOC");
        JENARULESFILE = getProperty("constants.config", "JENARULESFILE");
    }
    
    public static String getXSBloc() {
        return XSBLOC;
    }
    
    public static String getFamilySchemaFile() {
        return FAMSCHEMAFILELOC;
    }
    
    public static String getFamilyDataFile() {
        return FAMDATAFILELOC;
    }
    
    public static String getPrologFile() {
        return PROLOGFILELOC;
    }
    
    public static String getJenaRulesFile() {
        return JENARULESFILE;
    }
}
