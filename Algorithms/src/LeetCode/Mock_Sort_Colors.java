/**
 * Sort Colors:
 * 1 is red, 2 is white, 3 is blue
 * Sort the array in place.
 */

package LeetCode;
import java.util.*;

public class Mock_Sort_Colors {

    public static void main(String args[]){


        int[] test = {1,0};

        int[] out = sortColors(test);

        System.out.println(Arrays.toString(out));
    }


    public static int[] sortColors(int[] nums){

        ArrayList<Integer> red = new ArrayList<Integer>();
        ArrayList<Integer> white = new ArrayList<Integer>();
        ArrayList<Integer> blue = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){

            if(nums[i]==0){
                red.add(nums[i]);
            }
            else if(nums[i]==1){
                white.add(nums[i]);
            }
            else if(nums[i]==2){
                blue.add(nums[i]);
            }
        }

        int[] result = new int[nums.length];

        int i=0, j=0;
        while(j<red.size()){
            result[i] = red.get(j);
            i++;
            j++;
        } j=0;
        while(j<white.size()){
            result[i] = white.get(j);
            i++;
            j++;
        } j=0;
        while(j<blue.size()){
            result[i] = blue.get(j);
            i++;
            j++;
        }

        nums = result;
        return result;
    }
}
