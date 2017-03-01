/*Daniel Delago
 * Radix Sort: O(nk)
 */

package Algorithms;
import java.util.*;

public class RadixSort {

    // A utility function to get maximum value in arr[]
    public static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {

        // output array
        int output[] = new int[n];
        int i;

        //Array of possible digits
        int count[] = new int[10];

        //Fill with zeros
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {

            //The digit
            int digit = (arr[i] / exp) % 10;
            count[digit]++;

        }

        //Sum the counts of the digits
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--){

            //The digit
            int digit = (arr[i] / exp) % 10;

            //The index for the digit is it's count index MINUS ONE
            int index = count[ digit ] - 1;

            //Place in the output array
            output[index] = arr[i];

            //Decrement its count
            count[ digit ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int max = getMax(arr, n);

        //Do counting sort for every digit, exp is a power of 10 for the 1's, 10's ,100's,... place
        for (int exp = 1; max/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
    public static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }


    /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }
}