/**
 * Daniel Delago
 * Shifts an array a certain number of times and returns it
 **/

package Practice_Problems;
import java.util.*;

public class ArrayRotations {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        //Size of input
        System.out.print("n: ");
        int n = in.nextInt();

        //Number of rotations
        System.out.print("Rotations: ");
        int r = in.nextInt();

        int end;
        int[] set = new int[n];
        for(int i=0;i<n;i++){
            end = (i+n-r) % n;
            set[end] = in.nextInt();
        }

        System.out.print(Arrays.toString(set));
    }
}
