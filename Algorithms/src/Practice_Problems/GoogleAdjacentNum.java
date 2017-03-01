/**
 * Daniel Delago
 * Google Question Find Minimum Adjacent Numbers
 *
 */

package Practice_Problems;
import java.util.*;

public class GoogleAdjacentNum {

    public static void main(String args[]){

        //Get Input
        Scanner in = new Scanner(System.in);
        String num = in.next();

        //Minimum Merged Value, Always smaller then 100
        int min = 100;

        //For the length of the number
        for(int i=0;i<num.length()-1;i++){
            //Merge 2 digits       Digit 1              Digit 2
            int current = ((int)num.charAt(i)-48)*10 + ((int)num.charAt(i+1)-48) ;
            System.out.println(current);

            //If current is smaller then the current minimum
            if(current<min){
                min = current;
            }

            //If min is zero, no value can be smaller so break
            if(min == 0){
                break;
            }
        }

        System.out.println("Minimum Adjacent Number: " + min);

    }

}
