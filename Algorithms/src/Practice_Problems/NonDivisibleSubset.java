/*
 * Daniel Delago
 * Gets the size of the largest Non Divisible Subset
 */

package Practice_Problems;
import java.util.*;


public class NonDivisibleSubset {

    public static void main(String[] args) {
        
        int n, k;
        int[] set;
        
        Scanner in = new Scanner(System.in);        
        n = in.nextInt();
        k = in.nextInt();
        set = new int[n];
        
        //Stores input set in array
        for(int i=0;i<n;i++){
            set[i] = in.nextInt();
        }
        //Sort the set
        Arrays.sort(set);
        
        //An ArrayList of subsets
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();      
        //Initial subset
        ArrayList<Integer> init = new ArrayList<Integer>();
        init.add(set[0]);
        subsets.add(init);
        
        //For every value in the set
        for(int i=1;i<n;i++){
            //Used to count number of failed subsets
            int fails = 0;
            //For all available subsets
            for(int j=0; j<subsets.size();j++){
                ArrayList<Integer> curSet = subsets.get(j);
                boolean subPass = true;
                
                //For every value in the current subset
                for(int m=0;m<curSet.size();m++){
                    //If 2 values whose sum is divisible by k
                    if((set[i] + curSet.get(m)) % k == 0){
                        subPass = false;
                        fails += 1;
                    }
                }
                //If all values were valid in the subset
                if(subPass == true)
                    curSet.add(set[i]);
            }
            //If every subset failed
            if(fails==subsets.size()){
                ArrayList<Integer> solo = new ArrayList<Integer>();
                solo.add(set[i]);
                subsets.add(solo);
            }
        }
        
        //Find Max subset
        ArrayList<Integer> max = subsets.get(0);
        for(int i=1;i<subsets.size();i++){
            if(subsets.get(i).size() > max.size())
                max = subsets.get(i);
        }
        
        //Print max size
        System.out.print(max.size());
    }
}
