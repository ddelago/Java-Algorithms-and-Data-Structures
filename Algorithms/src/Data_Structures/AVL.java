/**
 * Daniel Delago
 * AVL Tree:
 * If balance between a node's left and right subtrees's is greater
 * than 1, A series of rotations will occur to balance it out.
 * This makes the height of the tree to be O(lgn) which means a more efficient Insertion/Deletion/Search.
 */

package Data_Structures;
import java.util.*;

class AVLNode{

    int val, height;
    AVLNode left, right;

    public AVLNode(int val){
        this.val = val;
        this.height=1;
    }
}

public class AVL {

    //Root of the tree
    static AVLNode root;

    /** Right Rotation
          Root              Swap
          /                    \
        Swap                   Root
          \                    /
         insideTree         inside Tree
     **/
    public AVLNode rightRotate(AVLNode root) {
        AVLNode swap = root.left;
        AVLNode insideTree = swap.right;

        // Perform rotation
        swap.right = root;
        root.left = insideTree;

        // Update heights
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        swap.height = Math.max(height(swap.left), height(swap.right)) + 1;

        // Return new root
        return swap;
    }

    /** Left Rotation
          Root               Swap
            \                 /
           Swap             Root
            /                 \
        insideTree          inside Tree
     **/
    public AVLNode leftRotate(AVLNode root) {
        AVLNode swap = root.right;
        AVLNode insideTree = swap.left;

        // Perform rotation
        swap.left = root;
        root.right = insideTree;

        //  Update heights
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        swap.height = Math.max(height(swap.left), height(swap.right)) + 1;

        // Return new root
        return swap;
    }

    int height(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    int getBalance(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return (height(N.left) - height(N.right));
    }

    public AVLNode addNode(AVLNode cur, AVLNode newNode){

        /*** Standard BST Insertion ***/
        //If position available
        if(cur == null){
            return newNode;
        }

        //If less then node, Go down left subtree
        if(newNode.val < cur.val) {
            cur.left = addNode(cur.left, newNode);
        }

        //If greater than node, Go down right subtree
        else if(newNode.val > cur.val){
            cur.right = addNode(cur.right, newNode);
        }

        /*** 2. Update height of this node ***/
        cur.height = Math.max(height(cur.left), height(cur.right)) + 1;

        /*** 3. Get the balance of this node ***/
        int balance = getBalance(cur);

        /*** 4. Rotation Cases if a node is unbalanced ***/
        // Left Left Case: Left subtree's height is larger and the new node is outside
        if (balance > 1 && newNode.val < cur.left.val) {
            return rightRotate(cur);
        }

        // Right Right Case: Right subtree's height is larger and the new node is outside
        if (balance < -1 && newNode.val > cur.right.val) {
            return leftRotate(cur);
        }

        // Left Right Case: Left subtree's height is larger and the new node is inside
        if (balance > 1 && newNode.val > cur.left.val) {
            cur.left = leftRotate(cur.left);
            return rightRotate(cur);
        }

        // Right Left Case: Right subtree's height is larger and the new node is inside
        if (balance < -1 && newNode.val < cur.right.val) {
            cur.right = rightRotate(cur.right);
            return leftRotate(cur);
        }

        return cur;
    }

    /* Given a non-empty binary search tree, return the node with minimum key value found in that tree.*/
    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    /*** Standard BST Deletion, then re-balance the resulting tree ***/
    public AVLNode deleteNode(AVLNode cur, int key){

        /*** Standard Binary Search ***/
        //If position available
        if(cur == null){
            return cur;
        }

        //If less then node, Go down left subtree
        if(key < cur.val) {
            cur.left = deleteNode(cur.left, key);
        }

        //If greater than node, Go down right subtree
        else if(key > cur.val){
            cur.right = deleteNode(cur.right, key);
        }

        // if key is same as root's key, then this is the node
        // to be deleted
        else {

            // node with only one child or no child
            if ((cur.left == null) || (cur.right == null)) {
                AVLNode temp = null;
                if (temp == cur.left) {
                    temp = cur.right;
                } else {
                    temp = cur.left;
                }

                // No child case
                if (temp == null) {
                    temp = cur;
                    cur = null;
                } else // One child case
                {
                    cur = temp; // Copy the contents of the non-empty child
                }
            } else {

                // node with two children: Get the inorder successor (smallest in the right subtree)
                AVLNode temp = minValueNode(cur.right);

                // Copy the inorder successor's data to this node
                cur.val = temp.val;

                // Delete the inorder successor
                cur.right = deleteNode(cur.right, temp.val);
            }
        }

        // If the tree had only one node then return
        if (cur == null) {
            return cur;
        }

        /*** 2. Update height of this node ***/
        cur.height = Math.max(height(cur.left), height(cur.right)) + 1;

        /*** 3. Get the balance of this node ***/
        int balance = getBalance(cur);

        /*** 4. Rotation Cases if a node is unbalanced ***/
        // Left Left Case: Left subtree's height is larger and the new node is outside
        if (balance > 1 && key < cur.left.val) {
            return rightRotate(cur);
        }

        // Right Right Case: Right subtree's height is larger and the new node is outside
        if (balance < -1 && key > cur.right.val) {
            return leftRotate(cur);
        }

        // Left Right Case: Left subtree's height is larger and the new node is inside
        if (balance > 1 && key > cur.left.val) {
            cur.left = leftRotate(cur.left);
            return rightRotate(cur);
        }

        // Right Left Case: Right subtree's height is larger and the new node is inside
        if (balance < -1 && key < cur.right.val) {
            cur.right = rightRotate(cur.right);
            return leftRotate(cur);
        }

        return cur;
    }

    //Root , Left, Right
    public void preorder(AVLNode root){

        //Ignore if null node
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public void search(AVLNode cur, int val){

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
            search(cur.right,val);
        } else{
            search(cur.left,val);
        }

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
        AVL tree = new AVL();

        /*** Insert nodes into the tree ***/
        for(int i=0;i<n;i++){
            AVLNode child = new AVLNode(nodes[i]);
            root = tree.addNode(root, child);
        }


        /*** Tree Traversals ***/
        System.out.print("Preorder: ");
        tree.preorder(root);
        System.out.println();

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
