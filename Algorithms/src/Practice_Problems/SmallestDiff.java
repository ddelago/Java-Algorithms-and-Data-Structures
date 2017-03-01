/**
 * Daniel Delago
 * Smallest Difference 16.6
 *
 */

package Practice_Problems;
import java.util.*;
import java.math.*;
public class SmallestDiff {


    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();   //Length of A
        int m = in.nextInt();   //Length of B
        int[] A = new int[n];   //Array A
        int[] B = new int[m];   //Array B

        //Get values for A
        for(int i=0;i<n;i++){
            A[i] = in.nextInt();
        }
        //Get Values for B
        for(int j=0;j<m;j++){
            B[j] = in.nextInt();
        }

        //Smallest Difference and those values
        int minDif, minA, minB;
        minDif = Math.abs(A[0] - B[0]); //Starting sentinel value
        minA = A[0];
        minB = B[0];

        //Uses Dual Pivot Quick Sort: O(n log(n))
        Arrays.sort(A);
        Arrays.sort(B);

        //For Every value in A
        for(int i=0;i<n;i++){
            //Starting current difference
            int curMinDif = Math.abs(A[i]-B[0]);

            //For every value in B
            for(int j=0;j<m;j++){
                //The Current difference
                int curDif = Math.abs(A[i]-B[j]);

                //If current difference is < current Minimum Difference
                if(curDif < curMinDif){
                    curMinDif = curDif;
                }

                //If current difference is < overall minimum difference
                if(curDif < minDif){
                    minDif = curDif;
                    minA = A[i];
                    minB = B[j];
                }

                //If B > A and Current difference is > current minimum difference
                if(B[j] > A[i] && curDif > curMinDif){
                    break;
                }
            }
        }

        System.out.println(minDif + " \n" + minA + " " + minB);

    }

}
