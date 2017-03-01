/**
 * Daniel Delago
 * Hashing With Chaining
 *
 **/
package Data_Structures;
import java.util.*;

//Used for chaining
class HashLink {

    public int kOriginal;
    public String val;
    public HashLink next;

    //Constructor for creating a Node
    public HashLink(int k, String val){
        this.kOriginal = k;
        this.val = val;
    }
}

public class HashChaining {

    public static void main(String args[]){

        HashChaining hash = new HashChaining();
        Scanner in = new Scanner(System.in);
        //Get size of Input
        int n = in.nextInt();
        //Table Size, be sure size is near 2n and prime to avoid collisions
        int m=0;

        //Get Appropriate Table Size
        if(n<=8){m=13;}
        else if(8<n && n<=16){m=17;}
        else if(16<n && n<=32){m=37;}
        else if(32<n && n<=64){m=67;}

        //The Hash Table
        HashLink[] table = new HashLink[m];

        //Insert into Hash Table
        for(int i=0;i<n;i++){
            /**
             * K is like a password/code. Every K is UNIQUE.
             * You hash it to get a specific index in m to store your value.
             * That index is only accessible by K.
             **/

            //Get k
            System.out.print("k: ");
            int k = in.nextInt();
            in.nextLine();

            //Value stored behind k
            System.out.print("  Value Stored by k: ");
            String val = in.nextLine();

            //Create k link
            HashLink kLink = new HashLink(k, val);

            //Hash k
            int index = hash.hashFunction1(k,m);

            //If Hashed Position is available
            if(table[index]==null){
                table[index] = kLink;
            }
            //If a value is already at that position in the table, add it to the chain
            else {
                HashLink cur = table[index];
                while(cur.next!=null){
                    cur = cur.next;
                }
                //Insert the kLink at the end
                cur.next = kLink;
            }
        }

        /***** Accessing values stored behind k *****/
        System.out.print("\nGet value stored behind k: ");
        int input = in.nextInt();
        while(input!=-1){

            //Get the hashed k index
            int kIndex = hash.getKindex(input, m);

            //If K is invalid and table location is empty
            if(table[kIndex]==null) {
                System.out.println("  Invalid k");
                System.out.print("Get value stored behind k: ");
                input = in.nextInt();
                continue;
            }

            //If only 1 value is stored at that index and is the appropriate k
            if(table[kIndex].next==null && table[kIndex].kOriginal==input){
                System.out.println("  Location in Table: " + kIndex + "\n  Value stored: " + table[kIndex].val);
            }

            //There was a collision, so search for k in the chain
            else{
                HashLink cur = table[kIndex];
                while(cur!=null){
                    //Found k in chain
                    if(cur.kOriginal==input){
                        System.out.println("  Location in Table: " + kIndex + "\n  Value stored: " + cur.val);
                        break;
                    }
                    cur = cur.next;
                }
                //If invalid k (Like an invalid password)
                if(cur==null)
                    System.out.println("  Invalid k");
            }
            System.out.print("Get value stored behind k: ");
            input = in.nextInt();
        }
    }


    public int hashFunction1(int k, int m){

        int hash1 = (int)(1.33*((int)Math.pow(k,2))) % m;
        return hash1;

    }

    public int hashFunction2(int k, int m){

        int hash2 = (17*(131%k)) % m;
        return hash2;

    }

    public int getKindex(int k, int m){

        return hashFunction1(k, m);

    }
}
