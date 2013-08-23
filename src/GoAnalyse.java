import utilities.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erik
 */
public class GoAnalyse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LexemeDictionary ldir = new LexemeDictionary();
        LexemeAnalyzer LA = new LexemeAnalyzer();
        ldir.showDictionary();
        LA.doAnalyse();
    }
}
