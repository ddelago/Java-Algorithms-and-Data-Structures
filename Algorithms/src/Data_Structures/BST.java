/**
 * Daniel Delago
 * Binary Search Tree
 * O(n) Complexity for all functions.
 *
 * Insertion: Standard BST Insertion
 *
 * Deletion:
 * 1. Delete Node
 * 2. If only one child just replace
 * 3. If 2 children, get the smallest value in it's right subtree and replace
 * 4. If right is empty, replace with left child
 *
 * Search: Standard BST Insertion without the insertion
 *
 * PreOrder: Root Left Right (Parent before Children)
 * InOrder: Left Root Right (The values in order)
 * PostOrder: Left Right Root (Children before parents)
 */

package Data_Structures;
import java.util.*;

class Node{

    int val;
    Node childLeft;
    Node childRight;

    public Node(int val){
        this.val = val;
    }
}


public class BST {

    //Root of the tree
    static Node root;

    public Node addNode(Node cur, Node newNode) {

        //If position available
        if (cur == null) {
            return newNode;
        }

        //If less then node, Go down left subtree
        if (newNode.val < cur.val) {
            cur.childLeft = addNode(cur.childLeft, newNode);
        }

        //If greater than node, Go down right subtree
        else if (newNode.val > cur.val) {
            cur.childRight = addNode(cur.childRight, newNode);
        }

        return cur;
    }

    /*** Deletion replaces the node with the smallest value in its right subtree ***/
    public Node deleteNode(Node cur, int key){

        //Base Case, If the tree is empty
        if(cur==null){
            return cur;
        }

        //If less then node, Go down left subtree
        if(key < cur.val){
            cur.childLeft = deleteNode(cur.childLeft, key);
        }

        //If greater than node, Go down right subtree
        else if(key > cur.val){
            cur.childRight = deleteNode(cur.childRight, key);
        }

        // if key is same as root's key, then This is the node to be deleted
        else
        {
            // node with only one child or no child
            if (cur.childLeft == null)
                return cur.childRight;
            else if (cur.childRight == null)
                return cur.childLeft;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            cur.val = minValue(cur.childRight);

            // Delete the inorder successor
            cur.childRight = deleteNode(cur.childRight, cur.val);
        }

        return cur;
    }

    //Gets the smallest value in the subtree
    int minValue(Node cur)
    {
        int minv = cur.val;
        while (cur.childLeft != null)
        {
            minv = cur.childLeft.val;
            cur = cur.childLeft;
        }
        return minv;
    }

    //Searches for a value in a tree
    public void search(Node cur, int val){

        //If node is null that means reached bottom of tree
        if(cur==null){
            System.out.println("Value not found");
            return;
        }

        //Found the value in the tree
        if(cur.val == val){
            System.out.println("Value Found");
            return;
        }

        //Search Left or Right trees
        if(val > cur.val){
            search(cur.childRight,val);
        } else{
            search(cur.childLeft,val);
        }

    }


    //Root , Left, Right
    public void preorder(Node root){

        //Ignore if null node
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorder(root.childLeft);
        preorder(root.childRight);

    }

    //Left, Root, Right
    public void inorder(Node root){

        //Ignore if null node
        if (root == null)
            return;

        inorder(root.childLeft);
        System.out.print(root.val + " ");
        inorder(root.childRight);

    }

    //Left, Right, Root
    public void postorder(Node root){

        //Ignore if null node
        if (root == null)
            return;

        postorder(root.childLeft);
        postorder(root.childRight);
        System.out.print(root.val + " ");

    }

    public static void main(String arg[]){

        //Get Input
        Scanner in = new Scanner(System.in);
        System.out.print("Number of Nodes: ");
        int n = in.nextInt();
        int[] nodes = new int[n];
        for(int i=0;i<n;i++){
            System.out.print(": ");
            nodes[i] = in.nextInt();
        }

        //Create Tree
        BST tree = new BST();

        /*** Insert nodes into the tree ***/
        for(int i=0;i<n;i++){
            //New Node to insert
            Node child = new Node(nodes[i]);
            //Always traverses from the root down to it's position.
            root = tree.addNode(root, child);
        }


        /*** Tree Traversals ***/
        System.out.print("Preorder: ");
        tree.preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        tree.inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(root);

        /*** Search ***/
        System.out.println("\nSearching for: 1, 5, 10");
        tree.search(root,1);
        tree.search(root,5);
        tree.search(root,10);

        /*** Deletion ***/
        tree.preorder(root);
        System.out.println();

        System.out.print("Delete 1: ");
        tree.deleteNode(root, 1);
        tree.preorder(root);
        System.out.println();

        System.out.print("Delete 3: ");
        tree.deleteNode(root, 3);
        tree.preorder(root);
        System.out.println();

        System.out.print("Delete 5: ");
        tree.deleteNode(root, 5);
        tree.preorder(root);
        System.out.println();

    }
}
