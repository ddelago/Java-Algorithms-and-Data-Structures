/**
 * Daniel Delago
 * Merge Sort
 */

package Algorithms;

public class MergeSort
{

    //The Merge Function
    public void merge(int arr[], int left, int middle, int right)
    {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; i++)
            L[i] = arr[left + i];
        for (int j=0; j<n2; j++)
            R[j] = arr[middle + 1+ j];


        /*** Merge the temp arrays ***/

        // Starting index of the sub-arrays
        int i = 0, j = 0;

        // Starting index of the new merged sub-array
        int k = left;

        // Stops when it reaches the end of one of the arrays
        while (i < n1 && j < n2)
        {
            // If value in left array is < value in right array
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            //If value in right array is < value in left array
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Left and right are the first and last elements of the array.
    void sort(int arr[], int left, int right)
    {

        //When left = right, we have a single element
        if (left < right)
        {
            // Find the middle point where to split
            int middle = (left+right)/2;

            // Sort first and second halves
            sort(arr, left, middle);
            sort(arr , middle+1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}