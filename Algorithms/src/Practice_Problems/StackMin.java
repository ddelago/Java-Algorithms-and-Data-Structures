/*
 * Daniel Delago
 * returns the Min value of a stack in O(1)
 * import java.util.*;
 */


package Practice_Problems;
import java.util.*;

public class StackMin {

    ArrayList<Integer> stack = new ArrayList<Integer>();
    int min=Integer.MAX_VALUE;

    public void push(int item){

        stack.add(item);
        if(item<min)
            min=item;

    }

    public void pop(){

        stack.remove(stack.size()-1);

    }

    public void peek(){

        System.out.println(stack.get(stack.size()-1));

    }

    public void min(){

        System.out.println(min);

    }

    public static void main(String args[]){

        StackMin stack = new StackMin();
        stack.push(7);
        stack.push(3);
        stack.push(9);
        stack.push(1);
        stack.push(21);

        stack.peek();
        stack.min();

    }

}
