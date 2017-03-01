/*
 * Daniel Delago
 * Sorting Routines
 */

package Algorithms;
import Data_Structures.*;

import java.util.Arrays;
import java.util.Scanner;


public class Algorithms {

    public void menu(LinkList list, int[] arr){

        //Display Initial Values
        System.out.print("\nInitial Values\nLinked List: ");
        list.display();
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));

        //Output values from algorithms
        LinkList outputList;
        int[] outputArr;

        /** Bubble Sort **/
        outputArr = bubbleSort(list);
        System.out.print("\nBubble Sort: ");
        System.out.println(Arrays.toString(outputArr));

        /** Insertion Sort **/
        outputArr = insertionSort(arr);
        System.out.print("Insertion Sort: ");
        System.out.println(Arrays.toString(outputArr));

        /** Merge Sort **/


    }

    public int[] bubbleSort(LinkList list){

        int n = list.getSize();
        int[] listArr = list.toArray(list.getSize());
        //For every value
        for(int i=0;i<n-1;i++){

            for(int j=i;j<n-1;j++){
                if(listArr[j]>listArr[j+1]){
                    int temp = listArr[j];
                    listArr[j] = listArr[j+1];
                    listArr[j+1] = temp;
                }
            }
        }
        return listArr;
    }

    public int[] insertionSort(int[] input){

        //For Every Value After the Initial Value
        for(int i=1;i<input.length;i++){

            //Set Key to the current value
            int key = input[i];

            //Set j to the previous value
            int j = i-1;

            //While values are greater than the key and not at the root
            while(j>=0 && input[j]>key){

                //Swap the values up by 1
                input[j+1] = input[j];

                //Check the next previous value
                j = j-1;
            }

            //Value was <= key so the key is placed after it OR key is smallest value
            input[j+1] = key;
            System.out.println(Arrays.toString(input));
        }
        return input;
    }

    public LinkList linkMenu() {

        int input;
        LinkList list = new LinkList(); //Creates the linked list

        System.out.println("Linked List Operations");
        System.out.print("1. Insert at beginning\n" +
                "2. Insert Link\n" +
                "3. Remove First\n" +
                "4. Remove Link\n" +
                "5. Is Empty\n" +
                "6. Find Link\n" +
                "7. Display\n" +
                "0. Exit\n:");
        Scanner in = new Scanner(System.in);
        input = in.nextInt();

        while(input != 0){
            int value, index;
            switch(input){
                case 1:
                    System.out.print("Value to insert: ");
                    value = in.nextInt();
                    list.insertAtBeginning(value); break;
                case 2:
                    System.out.print("Value to insert: ");
                    value = in.nextInt();
                    list.insertAtEnd(value); break;
                case 3:
                    System.out.print("Value to insert: ");
                    value = in.nextInt();
                    System.out.print("At index: ");
                    index = in.nextInt();
                    list.insertLink(value,index); break;
                case 4:
                    list.removeFirst(); break;
                case 5:
                    System.out.print("Value to remove: ");
                    value = in.nextInt();
                    list.removeLink(value); break;
                case 6:
                    list.isEmpty(); break;
                case 7:
                    System.out.print("Value to find: ");
                    value = in.nextInt();
                    list.find(value); break;
                case 8:
                    list.display(); break;
                default:
                    System.out.println("Not valid input");
            }
            System.out.println("\nLinked List Operations");
            System.out.print("1. Insert at beginning\n" +
                    "2. Insert at end" +
                    "3. Insert Link\n" +
                    "4. Remove First\n" +
                    "5. Remove Link\n" +
                    "6. Is Empty\n" +
                    "7. Find Link\n" +
                    "8. Display\n" +
                    "0. Exit\n:");
            input = in.nextInt();
        }
        return list;
    }

    public static void main(String[] args) {

        Algorithms start = new Algorithms();

        /*** Create Initial Linked List Using the Link Menu  ***/
        LinkList list = start.linkMenu();

        /*** Create Initial Linked List Manually  ***/
        //LinkList list = new LinkList();
        //list.insertAtBeginning(1);

        /*** Create Array from Linked List ***/
        int[] arr = list.toArray(list.getSize());

        /*** Start the Algorithms.Algorithms Menu***/
        start.menu(list, arr);

    }
}
