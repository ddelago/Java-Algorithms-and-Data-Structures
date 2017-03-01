/**
 * Daniel Delago
 * Binary Search: O(log n)
 */

package Algorithms;

public class BinarySearch
{

    public int binarySearch(int arr[], int left, int right, int x)
    {
        //If right<left, the value wasn't found
        if (right>=left)
        {
            //Get the middle value
            int mid = left + (right - left)/2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            //If greater then x, search left side
            if (arr[mid] > x)
                return binarySearch(arr, left, mid-1, x);

            //If less then x, check right side
            return binarySearch(arr, mid+1, right, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4,10,40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr,0,n-1,x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+result);
    }
}