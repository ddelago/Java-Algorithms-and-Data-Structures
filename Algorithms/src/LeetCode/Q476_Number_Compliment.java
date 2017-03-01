/**
 * Find Compliment:
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * Example: 5(101) -> 2(010)
 *          1(1) -> 0(0)
 */

package LeetCode;

public class Q476_Number_Compliment {

    //1. Remember the bit wise functions!
    public static void main(String args[]) {

        System.out.println(findCompliment(5));
        System.out.println(findCompliment(1));

    }

    public static int findCompliment(int num){

        int compl = (Integer.highestOneBit(num) << 1) - 1;

        return compl ^ num;
    }
}
