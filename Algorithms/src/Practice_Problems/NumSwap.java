/**
 * Daniel Delago
 * Swap 2 values in place
 **/

package Practice_Problems;
import java.util.*;

public class NumSwap {

    //Swap the values using their differences
    public void swap(int a, int b){

        // a=5 b=3
        a = a-b;  //5-3 = 2
        b = b+a;  //3+2 = 5
        a = b-a;  //5-2 = 3

        //a=3, b=5

        System.out.println("A = " + a + " B = " + b);

    }

    public static void main(String args[]){

        NumSwap go = new NumSwap();
        int a = 5;
        int b = 3;

        System.out.println("A = " + a + " B = " + b);

        go.swap(a,b);

    }
}
