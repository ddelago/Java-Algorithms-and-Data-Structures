/*
 * Daniel Delago
 * Largest Sum of contiguous sequence
 */

package Practice_Problems;
import java.util.*;

public class ContSequence {

    public static void main(String args[]){

        /*** Get Input ***/
        Scanner in = new Scanner(System.in);
        System.out.print("n: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.print("Values: ");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        /*** Find Cont. Sequence ***/
        //Starting Sum
        int maxSum = arr[0];

        //For every starting value, find its max sum
        for(int i=0;i<n;i++) {
            //Current Sum
            int curSum=arr[i];

            //Find largest sum for starting value
            for(int j=i+1;j<n;j++){
                //If current sum > max sum, set as new max sum
                if(curSum>maxSum)
                    maxSum = curSum;
                curSum += arr[j];
            }
        }

        System.out.println(maxSum);

    }
}
