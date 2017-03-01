/**
 * Daniel Delago
 * Stack: A FILO Data Structure
 * Most recent item added is the first item accessed
 * This implementation uses an ArrayList, can also use a Linked List
 **/

package Data_Structures;
import java.util.*;

public class Stack {

    public ArrayList<Integer> stack;

    public Stack(){
        //Initialize the Stack
        stack = new ArrayList<Integer>();
    }

    /***** Stack Operations *****/
    public void push(int item){
        //Add an item to the stack
        stack.add(item);
    }

    public void pop(){
        //Remove an item from the stack
        stack.remove(stack.size()-1);
    }

    public int peek(){
        //Returns Item at the top of the stack
        System.out.println(stack.get(stack.size()-1));
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty(){
        //Returns if stack is empty or not
        if(stack.size()==0) {
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack is not empty");
            return false;
        }
    }

    public void display(){
        //Display the stack
        System.out.println("-----");
        for(int i=stack.size()-1;i>=0;i--){
            System.out.println(stack.get(i));
        }
        System.out.println("-----");
    }

    public static void main(String args[]){

        Stack stack = new Stack();

        stack.isEmpty();
        stack.push(10);
        stack.push(2);
        stack.push(7);
        stack.push(13);
        stack.display();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.isEmpty();
        stack.display();

    }
}
