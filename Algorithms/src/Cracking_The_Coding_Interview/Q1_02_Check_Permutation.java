/**
 * Check Permutation:
 * Given two strings, write a method to decide if one is a permutation of the other
 */

package Cracking_The_Coding_Interview;
import java.util.*;

public class Q1_02_Check_Permutation {

    //1. Sort both strings and compare them
    //2. Get a sum/product of the numeric value of the strings and compare them (Better efficiency)
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        String strA = in.nextLine();
        String strB = in.nextLine();

        //If they are not the same length, this means that they can not be permutations
        if(strA.length() != strB.length()){
            System.out.println("Both strings are not permutations of each other");
            return;
        }

        //String numerical values
        int aVal = 0, bVal = 0;
        for(int i=0;i<strA.length();i++){
            //"Hash" the character and add it to the values
            aVal += strA.charAt(i) * 1337;
            bVal += strB.charAt(i) * 1337;
        }

        //If the values are the same, then they are permutations of each other
        if(aVal == bVal){
            System.out.println("Both strings are permutations of each other");
            return;
        }

        //If they differ, they are not permutations of each other
        System.out.println("Both strings are not permutations of each other");
    }
}