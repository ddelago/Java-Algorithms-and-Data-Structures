/**
 *  Is Unique:
 *  Implement an algorithm to determine if a string has all unique characters.
 *  What if you cannot use additional data structures?
 */

package Cracking_The_Coding_Interview;
import java.util.*;

public class Q1_01_Is_Unique {

    /*
     * -> Create an array of size 26 and add the characters to their correct position. If not empty it is not unique.
     */

    public static void main(String args[]) {

        //Get the String
        Scanner in = new Scanner(System.in);
        String word = in.nextLine().toLowerCase();

        //Array of every letter
        char[] characters = new char[26];

        //Search string for duplicates, stop if found
        for(int i=0;i<word.length();i++){
            //If there is a duplicate
            if(characters[(int)word.charAt(i)-97]!=0){
                System.out.println("The string is not unique");
                return;
            }
            //Else assign the letter
            else
                characters[(int)word.charAt(i)-97] = word.charAt(i);
        }

        //If all characters are unique
        System.out.println("The String's characters are all unique");
    }
}
