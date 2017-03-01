/**
 * Daniel Delago
 * Queue: A FIFO Data Structure
 * Items are accessed in the same order that they were added
 * This implementation uses a Linked List, can also use an ArrayList
 **/

package Data_Structures;

public class Queue {

    public LinkList queue;

    public Queue() {
        //Initialize the Queue
        queue = new LinkList();
    }

    /***** Queue Operations *****/
    public void enqueue(int item){
        //Add an item into the queue
        queue.insertAtEnd(item);
    }

    public void dequeue(){
        //Remove first item in the queue
        queue.removeFirst();
    }

    public int peek(){
        //Return first item in the queue
        int head = queue.getLink(0);
        System.out.println(head);
        return head;
    }

    public boolean isEmpty(){
        //Returns if queue is empty or not
        if(queue.getSize()==0){
            System.out.println("Queue is empty");
            return true;
        } else {
            System.out.println("Queue is not empty");
            return false;
        }
    }

    public void display(){
        //Display the queue
        int size = queue.getSize();
        for(int i=0;i<size;i++){
            System.out.print(queue.getLink(i) + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){

        Queue queue = new Queue();

        queue.isEmpty();
        queue.enqueue(10);
        queue.enqueue(2);
        queue.enqueue(7);
        queue.enqueue(13);
        queue.display();
        queue.peek();
        queue.dequeue();
        queue.peek();
        queue.isEmpty();
        queue.display();

    }
}