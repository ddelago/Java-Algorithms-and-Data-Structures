/*
 * Daniel Delago
 * Median of 2 Sorted Arrays
 */

package Practice_Problems;
import java.util.*;

public class Median2Arr {

    public static void main(String args[]){

        /*** Get Input ***/
        int[] arrA;
        int[] arrB;
        Scanner in  =new Scanner(System.in);

        System.out.print("Size of A:");
        arrA = new int[in.nextInt()];
        System.out.print("Size of B:");
        arrB = new int[in.nextInt()];

        System.out.print("Enter A: ");
        for(int i=0;i<arrA.length;i++){
            arrA[i] = in.nextInt();
        }

        System.out.print("Enter B: ");
        for(int i=0;i<arrB.length;i++){
            arrB[i] = in.nextInt();
        }

        /*** Combining Arrays ***/
        int[] newArr = new int[arrA.length+arrB.length];
        int i=0;    //Combined Array Index
        int j=0;    //A current Index
        int k=0;    //B current Index
        while(j != arrA.length || k!=arrB.length){
            //If value at A is <= value at B
            if(arrA[j]<=arrB[k]){
                newArr[i]=arrA[j];
                j++;
                i++;
            } else {
                newArr[i]=arrB[k];
                k++;
                i++;
            }

            //If even length Array
            if((arrA.length + arrB.length)%2==0 ){
                if(i==((arrA.length + arrB.length)/2)+1)
                    break;
            }
            //If odd length Array
            else if((arrA.length + arrB.length)%2==1 ){
                if(i==(((arrA.length + arrB.length)-1)/2)+1)
                    break;
            }
        }

        float median;
        //If even length Array, return average of 2 middle values
        if((arrA.length + arrB.length)%2==0 ){
            median = newArr[((arrA.length + arrB.length)/2)] + newArr[((arrA.length + arrB.length)/2)-1];
            median /= 2;
            System.out.println(median);
        } else {
            median = newArr[((arrA.length + arrB.length - 1)/2)];
            System.out.println(median);
        }

    }

}
