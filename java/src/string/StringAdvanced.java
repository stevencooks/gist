/**
 * File: string/StringAdvanced.java
 * ---------------------------------------
 * 1. sort a string alphabetically
 */
package string;

import java.util.Arrays;

public class StringAdvanced {
    
    public static void main(String[] args) {

        new StringAdvanced().run();

    }

    private void run() {
        
        String sorted = sortStringAlphabetically("cba");
        System.out.println(sorted);
        
    }
    
    // convert string to char array, sort array, and create a new string
    private String sortStringAlphabetically(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sortedWord = new String(chars);
        return sortedWord;
    }

}
