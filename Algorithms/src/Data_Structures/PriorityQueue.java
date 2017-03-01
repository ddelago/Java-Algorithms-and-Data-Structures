/**
 * Daniel Delago
 * Priority Queue
 * */

package Data_Structures;
import java.util.*;

class pNode{

    int val;
    int priority;

    public pNode(int val, int priority){
        this.val = val;
        this.priority = priority;
    }
}

public class PriorityQueue {


    pNode[] heap;
    int heapSize = 0;

    public PriorityQueue(int n){
        heap = new pNode[n];
    }

    //Get the Parent of node at index i
    public int parent(int i) {
        return (i-1)/2;
    }

    //Get index of left child of node at index i
    public int left(int i) {
        return (2*i + 1);
    }

    //Get index of right child of node at index i
    public int right(int i) {
        return (2*i + 2);
    }

    /*** Extracting the max/min value of a heap ***/
    public void extractMaxMin(){

        //Get the Max/Min value of the heap which is heap[0] (the root)
        pNode root = heap[0];

        //get the last(smallest/largest) value of the heap
        pNode last = heap[heapSize-1];

        //Place the max/min value outside of the heap, which is at the front of the output array
        heap[heapSize-1] = root;

        //Swap the root with the last value
        heap[0] = last;

        //Reduce size of the heap
        heapSize--;

        //Fix heap with the last value at the root
        //MaxHeapify(0);
        //    OR
        //MinHeapify(0);

    }

    /*** Inserting into a Min-Heap ***/
    public void insertMin(pNode k){

        //Increase the Heap Size by 1
        heapSize++;

        //i is last slot in the heap
        int i = heapSize-1;

        //Insert k into the last slot in the heap
        heap[i] = k;

        //While the new node is less than its parent and not at the root
        //For min-heap change to <
        while(i!=0 && heap[parent(i)].priority > heap[i].priority){

            //Swap the values
            pNode temp = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = temp;

            //Set i to the parent's index and continue swapping if needed
            i = parent(i);

        }
    }

    /*** Fixing a Min-Heap ***/
    public void MinHeapify(int i){

        //Get index of left child
        int leftChild = left(i);

        //Get index of right child
        int rightChild = right(i);

        //Set Smallest to current index
        int smallest = i;

        //If left child is in the heap and smaller then the current value
        if (leftChild < heapSize && heap[leftChild].priority < heap[i].priority)
            smallest = leftChild;

        //If right child is in the heap and smaller then the current and/or the left child
        if (rightChild < heapSize && heap[rightChild].priority < heap[smallest].priority)
            smallest = rightChild;

        //If one of the child's were smaller
        if (smallest != i)
        {
            //Swap the value with the smaller child
            pNode temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            //Fix the heap with the new position of the value
            MinHeapify(smallest);
        }
    }

    public static void main(String args[]){

        PriorityQueue Queue = new PriorityQueue(7);
        Queue.insertMin(new pNode(4,1));
        Queue.insertMin(new pNode(3,3));
        Queue.insertMin(new pNode(2,6));
        Queue.insertMin(new pNode(27,10));
        Queue.insertMin(new pNode(12,5));
        Queue.insertMin(new pNode(64,4));
        Queue.insertMin(new pNode(77,7));

        /*** Heap-Sort on Min-Heap ***/
        for(int i=0;i<7;i++){
            Queue.extractMaxMin();
            Queue.MinHeapify(0);
        }
        System.out.print("\nPriority Queue Order: ");
        for(int i=6;i>=0;i--){
            System.out.print(Queue.heap[i].val + " ");

        }
    }
}
