package Practice_Problems;

import java.util.*;

public class LargestDivisibleSubset {

    public static void main(String[] args) {

        LargestDivisibleSubset test = new LargestDivisibleSubset();
        int[] nums = {1,2,4,8,9,72};
        List<Integer> out = test.solution(nums);
        for(int i=0;i<out.size();i++)
            System.out.print(out.get(i) + " ");
    }


    public List<Integer> solution(int[] nums) {

        //Sort input
        Arrays.sort(nums);
        //Create a list of subsets
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        //initial subset
        ArrayList<Integer> init = new ArrayList<Integer>();

        //If nums is empty
        if(nums.length==0)
            return init;

        //Add initial value
        init.add(nums[0]);
        //Add initial subset to subset list
        subsets.add(init);

        //For length of input
        for(int i=1;i<nums.length;i++){

            boolean found = false;
            //For number of subsets
            for(int j=0;j<subsets.size();j++){
                //Get current set
                ArrayList<Integer> curSet = subsets.get(j);

                //Check i % (max of current subset) == 0
                if(nums[i]%curSet.get((curSet.size() - 1))==0){
                    //If valid, add value to set
                    curSet.add(nums[i]);
                    found = true;
                }
            }

            //If no subset was valid
            int k=1;
            int numSubsets = subsets.size();
            while(found==false){
                //For every subset
                for(int j=0;j<numSubsets;j++){
                    //current subset
                    ArrayList<Integer> curSet = subsets.get(j);

                    //If no subset is valid, create a new subset
                    if(k==curSet.size()){
                        ArrayList<Integer> soloSet = new ArrayList<Integer>();
                        soloSet.add(nums[i]);
                        subsets.add(soloSet);
                        found=true;
                        break;
                    }

                    //Check if i % (max-k of current subset) == 0
                    if(nums[i]%curSet.get((curSet.size() - 1 - k))==0){
                        ArrayList<Integer> newSet = new ArrayList(curSet.subList(0, curSet.size() - k ));
                        newSet.add(nums[i]);
                        subsets.add(newSet);
                        found = true;
                    }
                }

                //If a subset was found
                if(found==true)
                    break;
                k++;
            }
        }

        //Find max subset
        ArrayList<Integer> max = subsets.get(0);
        for(int i=1;i<subsets.size();i++){
            if(subsets.get(i).size() > max.size())
                max = subsets.get(i);
        }

        return max;
    }
}