/**
 Fizz Buzz:
 Write a program that outputs the string representation of numbers from 1 to n.
 But for multiples of three it should output “Fizz” instead of the number and
 for the multiples of five output “Buzz”. For numbers which are multiples of
 both three and five output “FizzBuzz”.
 n = 15,
 Return:
 ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */

package LeetCode;
import java.util.*;

public class Q412_Fizz_Buzz {

    public static void main(String args[]) {

        int test = 15;

        System.out.println(fizzBuzz(test));
    }

    public static List<String> fizzBuzz(int n) {

        List<String> output = new ArrayList<String>();

        //For every value
        for(int i=1;i<=n;i++){
            //If divisible by 3
            if(i%3==0){
                //If also divisible by 5
                if(i%5==0){
                    output.add("FizzBuzz");
                    continue;
                }
                //If not also divisible by 5
                output.add("Fizz");
                continue;
            }
            //If only divisible by 5
            if(i%5==0){
                output.add("Buzz");
                continue;
            }
            //If neither just add i
            output.add(""+i);
        }

        return output;
    }
}
