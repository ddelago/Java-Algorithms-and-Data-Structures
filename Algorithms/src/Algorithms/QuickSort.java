/**
 * Daniel Delago
 * Quick Sort: 2 Pointers at the beginning version,
 * as j increments, if j is <= to the pivot, swap i and j, increment i, and continue.
 * Once j reaches the end(pivot), swap the pivot with i. Returns i which is the final position of the piot.
 */

package Algorithms;

public class QuickSort
{

    /*** Sets the last element as the pivot and
     *   places all values less than it before and
     *   all value greater than it after it.
     *   Returns the final position of the pivot
     *   ***/
    int partition(int arr[], int low, int high){

        //In this version, the pivot is the last element
        int pivot = arr[high];

        // index of i pointer, doesn't move unless swapped
        int i = low;

        //Loop over current partition, Excludes pivot
        for (int j=low; j<=high-1; j++){

            // If current element is <= to pivot
            if (arr[j] <= pivot){

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                //Move the i pointer up
                i++;
            }
        }

        // swap arr[i] and arr[high] (or pivot)
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }


    /** The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index **/
    void sort(int arr[], int low, int high)
    {
        //If low = high, this is a partition of size 1
        //and is ignored. Already in it's correct place.
        if (low < high)
        {
            //Gets the final placement for the current pivot
            int pivotFinal = partition(arr, low, high);

            // Recursively sort elements before
            // pivot and after pivot
            sort(arr, low, pivotFinal-1);
            sort(arr, pivotFinal+1, high);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}