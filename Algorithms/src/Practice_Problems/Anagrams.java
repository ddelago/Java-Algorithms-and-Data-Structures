/**
 * Daniel Delago
 * Finds the minimum number of deletions between 2 strings to make the anagrams
 **/

package Practice_Problems;
import java.util.*;

public class Anagrams {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        //Get A String
        System.out.print("A: ");
        char[] a = in.nextLine().toCharArray();
        Arrays.sort(a);

        //Get B String
        System.out.print("B: ");
        char[] b = in.nextLine().toCharArray();
        Arrays.sort(b);

        //Find which string is smaller or larger
        char[] smaller, larger;
        if(a.length<b.length){
            smaller = a;
            larger = b;
        } else{
            smaller = b;
            larger = a;
        }

        //Count the number of deletions
        int deletions = 0;

        //For every character
        int i, j;
        for(i=0, j=0 ;i<smaller.length;i++, j++){

            //If characters match, continue
            if(smaller[i] == larger[j]){
                continue;
            }

            //If character is larger, increment other string until new character
            if(smaller[i] > larger[j]){
                i -= 1;
                deletions += 1;
                continue;
            }

            //If character is smaller, increment other string until new character
            if(smaller[i] < larger[j]){
                j -= 1;
                deletions += 1;
                continue;
            }
        }

        //Add the leftover characters
        deletions += (larger.length - j);

        System.out.println(deletions);
    }
}
