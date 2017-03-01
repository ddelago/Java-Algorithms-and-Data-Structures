/**
 * Daniel Delago
 * Bubble Sort: O(n^2) worst (reverse order), O(n) best (already sorted)
 */

package Algorithms;

public class BubbleSort {

    public void bubbleSort(int arr[]){

        int n = arr.length;

        //For all values
        for (int i = 0; i < n-1; i++) {

            //Ignore already placed values
            for (int j = 0; j < n - i - 1; j++) {

                //Swap values if larger
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /* Prints the array */
    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[])
    {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 25, 12, 22, 11};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}