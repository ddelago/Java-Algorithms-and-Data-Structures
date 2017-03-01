/**
 * Daniel Delago
 * Counting Sort: O(n + k)
 */

package Algorithms;

public class CountingSort {

    public void sort(char arr[]){

        int n = arr.length;

        // The output character array that will have sorted arr
        char output[] = new char[n];

        // Create a count array to store count of characters
        int count[] = new int[256];

        //Fill with zeros
        for (int i=0; i<256; ++i)
            count[i] = 0;

        // Count occurrences of each character
        for (int i=0; i<n; ++i) {
            char character = arr[i];
            count[character] += 1;
        }

        //Sum the counts of the characters
        for (int i=1; i<=255; i++) {
            count[i] += count[i - 1];
        }

        // Build the output character array
        for (int i = 0; i<n; i++){

            //Get the character
            char character = arr[i];

            //The index for the character is it's count index MINUS ONE
            int index = count[character] - 1;

            //Place in the output array
            output[index] = arr[i];

            //Decrement the count index for the character
            count[character]--;
        }

        // Copy the output array to arr, so that arr now contains sorted characters
        // CAN JUST HAVE THE METHOD RETURN OUTPUT ARRAY INSTEAD
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    }

    public static void main(String args[])
    {
        CountingSort ob = new CountingSort();
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};

        ob.sort(arr);

        System.out.print("Sorted character array is ");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i]);
    }
}