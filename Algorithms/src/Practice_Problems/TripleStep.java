/*
 * Daniel Delago
 * Triple Step 8.1: A child is running up a staircase with n steps and can hop either
 * 1, 2, or 3 steps at a time. Implement a method to count how many possible ways the child
 * can run up the stairs.
 */

package Practice_Problems;
import java.util.*;

public class TripleStep {

    public static void main(String args[]){

        TripleStep go = new TripleStep();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = go.countWays(n);

        System.out.println(sum);
    }

    int countWays(int n){

        if(n<0) {
            return 0;
        } else if(n==0){
            return 1;
        } else {
            return countWays(n-1) + countWays(n-2) + countWays(n-3);
        }

    }
}
