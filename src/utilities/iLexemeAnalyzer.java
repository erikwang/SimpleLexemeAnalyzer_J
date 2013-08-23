/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Erik
 */

import java.util.*;

public interface iLexemeAnalyzer {
    public Vector<String> getLinesFromFile();
    public void doAnalyse();
    public void printToken();
    public int matchClass(char _char);
}
