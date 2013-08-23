/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;
import java.util.*;
/**
 *
 * @author Erik
 * 
 * 1. read each character from input string
 * 2. check character class - DIGIT, ALPHABET, SPACE, OPERATORS. Put it in Vector<String> "thislex"
 * 3. read next character, if class equals last one, append it to thislex. Otherwise out thislex as one complete lexeme.
 */
public class LexemeAnalyzer implements iLexemeAnalyzer{
    
//String charClass ="INIT";
    int charClass = 1;
    
//String lastClass = "";
    int lastClass = 2;
    
//memory struct for every single lexeme
    Vector<Character> thislex = new Vector<>();

    int lexlen = 0;
    int currentpoint = 0;
    char thischar;
    
    char[] inputstringchar;
    String nextToken;
    
//add a new character to Lexeme memory, collect while the next one is as the same type as last one
    public void addToThisLex(char _inchar){
        lexlen++;
        thislex.add(_inchar);
        lastClass=charClass; 
    }
    
//clear lexeme memory while move to the next token
    public void initThisLex(){
        lexlen = 0;
        thislex = new Vector<Character>();
    }
    

//match character type, by ASCII check, 1 = Alphabet, 2 = 0 ~ 9, 3 = others    
    public int matchClass(char thischar){
        if( (((int)thischar > 96) && ((int)thischar < 122)) || (((int)thischar > 64) && ((int)thischar < 90)) ){
            charClass = 1;
        }else if(Character.isDigit(thischar)){
            charClass = 2;
               }else if((int)thischar == 32){
                    charClass = 0; // white space
               }else{
                    charClass = 3;
               }
        return charClass;
    }
    
//print token in memeory - while class type was changed.
    public void printToken(){
        StringBuilder sb = new StringBuilder();        
        for(int i=0;i<thislex.size();i++){
            sb.append(thislex.get(i));
        }
        if(nextToken != null){
            System.out.println("Next token is:["+nextToken+"], Next lexeme is ["+sb.toString()+"]");
        }
    }
    
    
    public void doAnalyse(){
         String inputstring = "  System.out.println(\"Next token is:[\"+nextToken+\"], Next lexeme is [\"+sb.toString()+\"]\"); ";
         System.out.println("The original sentence is: "+inputstring);
         inputstringchar = inputstring.toCharArray();
         System.out.println("char array length = "+inputstringchar.length);
                  
        for(;currentpoint < inputstringchar.length;currentpoint++){         
           thischar = inputstringchar[currentpoint];
           charClass = matchClass(thischar);
           
           //set lastClass equals to the first character (while not a white space)'s class
           if(currentpoint == 0){
               lastClass = charClass;
           }
           
           switch(charClass){
                   case 2: //DIGIT
                       if(charClass != lastClass){
                           printToken(); 
                           initThisLex();
                           addToThisLex(thischar);
                           nextToken = "DIG_LIT";
                       }else{
                           addToThisLex(thischar);
                           nextToken = "DIG_LIT";
                       }
                       break;

                   case 1: //ALPHABET
                       if(charClass != lastClass){
                               printToken();
                               initThisLex();
                               addToThisLex(thischar);
                               nextToken = "IDENT";
                       }else{
                           addToThisLex(thischar);
                           nextToken = "IDENT";
                       }
                       break;

                   case 3: // OPERATORS
                       if(charClass != lastClass || lastClass == 3){
                           printToken();  
                           initThisLex();
                           addToThisLex(thischar);
                           nextToken = new LexemeDictionary().getOperator(thischar);
                       }else{
                           addToThisLex(thischar);
                           nextToken = new LexemeDictionary().getOperator(thischar);
                       }
                       break;
                       
                   case 0: // WHITE SPACES
                       break;

                   default :
                       break;
                }                        
        }
        printToken();
    }


    public Vector<String> getLinesFromFile() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("did!");
        return null;
    } 
}
