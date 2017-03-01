/**
 * Daniel Delago
 * To create a linked list use:
 *      LinkList list = new LinkList();
 *      LinkList functions...
 **/
package Data_Structures;

//Basically Like a structure in C
//The Link class contains all the attributes of the Link.
class Link {

    public int val;
    public Link next;

    //Constructor for creating a link
    public Link(int val){
        this.val = val;
    }
}

/***** This is the actual linked list!! *****/
public class LinkList{
    //The first link in the linked list
    public Link firstLink;

    public LinkList(){
        //Set first link to null, Creates the linked list(an empty linked list)
        firstLink = null;

    }

    /*** Linked List Operations ***/
    public boolean isEmpty(){
        //Returns true if Data_Structures.LinkList is empty.
        if(firstLink==null)
            System.out.println("Empty");
        else
            System.out.println("Not Empty");

        return(firstLink==null);

    }

    //Inserts a link at the beginning of the linked list
    public void insertAtBeginning(int val){
        //Creates the new link
        Link newLink = new Link(val);
        //Set the next link equal to the first link
        newLink.next = firstLink;
        //The first link is now set to the new link
        firstLink = newLink;
    }

    public Link insertAtEnd(int val){

        Link newLink = new Link(val);
        Link cur = firstLink;
        //If the list is empty
        if(cur==null){
            firstLink = newLink;
            return cur;
        }
        //Find the end of the linked list
        while(cur.next!=null){
            cur = cur.next;
        }
        //Insert the new link at the end
        cur.next = newLink;
        return cur;
    }

    public Link insertLink(int val, int index){

        Link cur = firstLink;
        Link prev = firstLink;
        Link newLink = new Link(val);
        int i=0;
        //Search for index
        while(i<index && cur!=null){
            prev=cur;
            cur=cur.next;
            i++;
        }

        if(cur==null) {
            System.out.println("Index out of range");
            return null;
        }
        else {
            newLink.next = cur;
            prev.next = newLink;
            return cur;
        }
    }

    public void removeFirst(){

        if(firstLink!=null){
            //Removes first link
            firstLink = firstLink.next;

        }else{

            System.out.println("Linked List is empty.");

        }
    }

    public void display(){

        Link cur = firstLink;
        int size = 0;
        while(cur!=null) {
            //Prints value of every link
            System.out.print(cur.val);
            if(cur.next != null)
                System.out.print(" -> ");

            cur = cur.next;
            size++;
        }
        System.out.println();
    }

    public Link find(int val){
        int index = 0;
        Link cur = firstLink;

        while(cur!=null && cur.val != val){
            cur = cur.next;
            index++;
        }
        if(cur==null) {
            System.out.println("Value: " + val + " Not Found");
            return null;
        }
        else {
            System.out.println("Value: " + val + " Found at index: " + index);
            return cur;
        }
    }

    public Link removeLink(int val){

        Link cur = firstLink;
        Link prev = firstLink;

        while(cur.val!=val){
            //Reached end of linked list without finding value
            if(cur.next==null) {
                System.out.println("Value not found");
                return null;
            }
            //Continue on down the list
            else{
                prev=cur;
                cur=cur.next;
            }
        }
        //If code reaches here, a match was found
        if(cur == firstLink) {

            firstLink = firstLink.next;

        }else{
            //This skips over the removed Data_Structures.Link
            prev.next=cur.next;

        }
        return cur;

    }

    public int getSize() {
        Link cur = firstLink;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    public int getLink(int index){
        Link cur = firstLink;
        int i = 0;
        //Search for link
        while(cur!=null && i<index){
            cur = cur.next;
            i++;
        }
        //Index was out of bounds
        if(cur==null) {
            System.out.println("Index out of bounds");
            return -1;
        }

        return cur.val;
    }

    public int[] toArray(int size){

        Link cur = firstLink;
        int[] listArray = new int[size];

        for(int i=0;i<size;i++){
            listArray[i] = cur.val;
            cur = cur.next;
        }

        return listArray;

    }
}





