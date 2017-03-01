/*
 * Daniel Delago
 * Rotates an array k times
 * Then prints values at specific index
 */
package Practice_Problems;
import java.util.*;

public class CircularArrayRotation {

    public static void main(String[] args) {
        //Input Set
        ArrayList<Integer> set = new ArrayList<Integer>();
        int n, k, q, m;
        Scanner in = new Scanner(System.in);

        n = in.nextInt();   //Set Size
        k = in.nextInt();   //k rotations
        q = in.nextInt();   //q queries

        //Create Set
        for(int i=0;i<n;i++){
            set.add(in.nextInt());
        }

        //Rotate the set k times
        for(int j=0;j<k;j++){
            //Insert Last into first position
            set.add(0,set.get(set.size()-1));
            //Remove last value
            set.remove(set.size()-1);
        }

        //Get m
        for(int l=0;l<q;l++){
            m = in.nextInt();
            System.out.println(set.get(m));
        }

    }
}