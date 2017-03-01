/*
 * Daniel Delago
 * Detects where a loop starts in a Linked List and returns the starting node
 */


package Practice_Problems;
import java.util.*;

//Nodes in Linked List
class NodeLoop{
    String id;
    NodeLoop next;

    public NodeLoop(String id){
        this.id=id;
    }
}

public class LoopDetection {

    public void findLoop(NodeLoop first){

        //List of Visited Nodes
        ArrayList<String> ids = new ArrayList<String>();
        NodeLoop cur = first;

        //Finds Loop, if cur.next=null there was no loop
        while(cur.next!=null){

            //Found Cycle
            if(ids.contains(cur.id)){
                System.out.println("Cycle Found, Begins at " + cur.id);
                break;
            }

            //Add current id to list of id's
            ids.add(cur.id);
            cur = cur.next;
        }

        //If no cycle found
        if(cur.next==null){
            System.out.println("No Cycle's Found");
        }

    }


    public static void main(String args[]){

        //Creating Nodes and Linked List
        NodeLoop A = new NodeLoop("A");
        NodeLoop B = new NodeLoop("B");
        NodeLoop C = new NodeLoop("C");
        NodeLoop D = new NodeLoop("D");
        NodeLoop E = new NodeLoop("E");
        //A->B->C->D->E->C
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = C;

        LoopDetection go = new LoopDetection();
        go.findLoop(A);

    }
}
