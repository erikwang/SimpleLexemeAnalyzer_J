/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Erik
 */
public class LexemeDictionary {

    //String[][] lexeme = new String[64][64];
    static String characterMap[][] = {
        {"LETTER","0",""},
        {"DIGIT","1",""},
        {"UNKNOWN","99",""},
        {"DIG_LIT","10",""},
        {"IDENT","11",""},
        {"ASSIGN_OP","20","="}, 
        {"ADD_OP","21","+"},
        {"SUB_OP","22","-"}, 
        {"MULT_OP","23","*"}, 
        {"DIV_OP","24","/"}, 
        {"SIMCOLON","40",";"},
        {"LEFT_PAREN","25",""},
        {"RIGHT_PAREN","26",""},
        {"RETURN_OP","30",""},
        {"WHITE_SPACE","32"," "},
    };
   
    public String getOperator(char _operator){
        String operator = new Character(_operator).toString();
        for(int i=0;i<characterMap.length;i++){
            if(operator.equals(characterMap[i][2])){
                return characterMap[i][0];
            }
        }
        return "NOTFOUND";
    }
    
    
    public void showDictionary(){
     for (int t=0;t<characterMap.length;t++){
        for(int j=0; j<characterMap[t].length;j++){
         System.out.print(characterMap[t][j].toString()+" ");
        }
        System.out.println();
      }
    }
}
