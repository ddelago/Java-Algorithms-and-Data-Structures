/**
 * Daniel Delago
 * Reverse a String in place
 **/

package Practice_Problems;
import java.util.*;

public class ReverseString {


    public void reverse(String a){

        char[] aRev = a.toCharArray();
        for(int i=0;i<a.length()/2;i++){

            //Gets char at end of string, j
            int j = a.length()-i-1;

            //Stores char at beginning of string, temp = i
            char temp = aRev[i];

            //Set i = j
            aRev[i] = aRev[j];

            //j = temp
            aRev[j] = temp;

        }

        System.out.println(aRev);

    }


    public static void main(String args[]){

        ReverseString go = new ReverseString();

        String a = "HelloWorld";

        System.out.println(a);

        go.reverse(a);

    }

}
