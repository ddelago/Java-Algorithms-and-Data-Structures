/**
 * Daniel Delago
 * SubSort 16.16
 *
 */

package Practice_Problems;
import java.util.*;

public class SubSort {

    public static void main(String args[]){

        //Get Input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] set = new int[n];
        for(int i=0;i<n;i++){
            set[i] = in.nextInt();
        }

        //Sorts Array using 2 pivot Quick Sort O(n log(n))
        int[] sortedSet = Arrays.copyOf(set,set.length);
        Arrays.sort(sortedSet);

        //Find starting index where values differ
        for(int i=0;i<n;i++){
            if(set[i] != sortedSet[i]){
                System.out.print(i + " ");
                break;
            }
        }

        //Find ending index where values differ
        for(int i=n-1;i>=0;i--){
            if(set[i] != sortedSet[i]){
                System.out.print(i);
                break;
            }
        }


    }
}
