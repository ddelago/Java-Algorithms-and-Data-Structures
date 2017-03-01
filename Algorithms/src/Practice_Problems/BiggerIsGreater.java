package Practice_Problems;

import java.io.*;
import java.util.*;

public class BiggerIsGreater {

    public void go() {

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        //For every word
        for(int i=0;i<w;i++){
            String s = in.nextLine();
            String out = findLex(s);

        }
    }

    public String findLex(String s){
        boolean found = false;
        //For length of string
        for(int j=1,k=0;j<s.length();j++,k++){
            //If character k > j; swap
            if(s.charAt(s.length()-1-k) > s.charAt(s.length()-1-j)){
                char temp = s.charAt(j);
                s.replace(s.charAt(j), s.charAt(k));
                s.replace(s.charAt(k), temp);
                found = true;
                break;
            }

            //If at beginning of string and no match found
//            if((s.length()-1-j)==0 && found==false){
//                for()
//
//
//            } else {
//                return s;
//            }
        }
        return s;
    }
}