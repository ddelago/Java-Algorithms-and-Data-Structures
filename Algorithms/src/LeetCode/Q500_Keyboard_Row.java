/**
 Keyboard Row:
 Given a List of words, return the words that can be typed using letters
 of alphabet on only one row's of American keyboard.

 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]

 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.
 */

package LeetCode;
import java.util.*;

public class Q500_Keyboard_Row {

    public static void main(String args[]) {

        String[] test = {"Hello", "Alaska", "Dad", "Peace"};

        System.out.println(Arrays.toString(findWords(test)));
    }

    public static String[] findWords(String[] words) {

        //The Keyboard
        String[] keyboard = {"qwertyuiop","asdfghjkl","zxcvbnm"};

        //The valid words
        ArrayList<String> output = new ArrayList<String>();

        //For every word
        for(int i=0;i<words.length;i++){
            //The Current word
            String cur = words[i].toLowerCase();

            //The keyboard row
            int row = -1;

            //For the length of the current word
            for(int j=0;j<cur.length();j++){
                //If top row contains current character
                if(keyboard[0].contains(cur.substring(j,j+1))){
                    //If this is the first character
                    if(row==-1)
                        row = 0;
                    //Else this word needs multiple rows on the keyboard
                    else if(row!=0){
                        break;
                    }
                    //If this is the last character and passed prev conditionals
                    if(j==cur.length()-1){
                        //Add it to the output list
                        output.add(words[i]);
                    }
                }

                //If middle row contains current character
                if(keyboard[1].contains(cur.substring(j,j+1))){
                    //If this is the first character
                    if(row==-1)
                        row = 1;
                        //Else this word needs multiple rows on the keyboard
                    else if(row!=1){
                        break;
                    }
                    //If this is the last character and passed prev conditionals
                    if(j==cur.length()-1){
                        //Add it to the output list
                        output.add(words[i]);
                    }
                }

                //If bottom row contains current character
                if(keyboard[2].contains(cur.substring(j,j+1))){
                    //If this is the first character
                    if(row==-1)
                        row = 2;
                        //Else this word needs multiple rows on the keyboard
                    else if(row!=2){
                        break;
                    }
                    //If this is the last character and passed prev conditionals
                    if(j==cur.length()-1){
                        //Add it to the output list
                        output.add(words[i]);
                    }
                }
            }
        }

        return output.toArray(new String[output.size()]);
    }
}


