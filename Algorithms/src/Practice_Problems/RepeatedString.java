/*
 * Daniel Delago
 * Counts occurrences of a in infinitely long string
 */

package Practice_Problems;
import java.util.*;

public class RepeatedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();

        long sum = 0;
        int sSum = 0;
        long sRepeat = n / s.length();      //Number of repeats
        long extra = n % s.length();       //Extra characters

        //How many times a appears in s
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a')
                sSum += 1;
        }

        sum += (sSum * sRepeat);

        //Add occurences in s subtring
        for(int j=0;j<extra;j++){
            if(s.charAt(j)=='a')
                sum += 1;
        }

        System.out.print(sum);
    }
}
