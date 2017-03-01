/**
 * Hamming Distance:
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Example: Input: x = 1; y = 4
 *          Output: 2
 *          Explanation:
 *          1 (0 0 0 1)
 *          4 (0 1 0 0)
 *               ^   ^
 */

package LeetCode;

public class Q461_Hamming_Distance {

    //1. Convert both numbers to binary, then compare the new values as strings.
    //2. OR USE XOR DUHHH:  return Integer.bitCount(x ^ y);
    public static void main(String args[]){

        int answer = hammingDistance(1,4);
        System.out.println(answer);

    }

    public static int hammingDistance(int x, int y){
        //Convert the values to binary strings
        String xBin = Integer.toBinaryString(x);
        String yBin = Integer.toBinaryString(y);

        //There is a difference in length so pad the smaller one with zeroes
        if(xBin.length()!=yBin.length()){
            //If x is smaller, continue padding with zeroes
            while(xBin.length()<yBin.length())
                xBin = "0" + xBin;

            //If y is smaller, continue padding with zeroes
            while(yBin.length()<xBin.length())
                yBin = "0" + yBin;
        }

        //Hamming Distance between the values
        int ham_distance = 0;
        for(int i=0;i<yBin.length();i++){
            //If the bits differ, increase the distance by one
            if(xBin.charAt(i)!=yBin.charAt(i))
                ham_distance += 1;
        }

        return ham_distance;
    }
}
