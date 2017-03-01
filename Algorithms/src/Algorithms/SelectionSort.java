/**
 * Daniel Delago
 * Selection Sort: O(n^2)
 * Finds the minimum value in unordered array and
 * swaps it with the first element in the unsorted array.
 */

package Algorithms;

public class SelectionSort {

    public void sort(int arr[])
    {
        int n = arr.length;

        //For all values
        for (int i = 0; i < n; i++)
        {
            // Find the minimum element in unsorted array, starting value is the first value
            int min = i;
            for (int j = i+1; j < n; j++) {

                //If less then the min
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            //Swap the values
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}