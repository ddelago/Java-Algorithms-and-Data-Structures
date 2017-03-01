/**
 * Compare Version Number:
 Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */

package LeetCode;
import java.util.*;

public class Mock_Compare_Version {

    public static void main(String args[]) {


        int[] test = {1, 0};

        System.out.println(compareVersion("1.0", "1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String [] v1 = version1.split(".");
        String [] v2 = version2.split(".");

        if(version1.contains(".") && version2.contains(".")){

            int v1First = Integer.parseInt(v1[0]);
            int v1Second = Integer.parseInt(v1[1]);
            int v2First = Integer.parseInt(v2[0]);
            int v2Second = Integer.parseInt(v2[1]);

            if(v1First > v2First)
                return 1;
            if(v1First < v2First)
                return -1;

            if(v1First == v2First){
                if(v1Second > v2Second)
                    return 1;
                if(v1Second < v2Second)
                    return -1;
            }
        }

        if(version1.contains(".") && version2.contains(".")==false){
            int v1First = Integer.parseInt(v1[0]);
            int v1Second = Integer.parseInt(v1[1]);
            int v2t = Integer.parseInt(version2);

            if(v1First > v2t)
                return 1;
            if(v1First < v2t)
                return -1;
            if(v1Second > 0)
                return 1;
        }

        if(version1.contains(".")==false && version2.contains(".")){
            int v2First = Integer.parseInt(v2[0]);
            int v2Second = Integer.parseInt(v2[1]);
            int v1t = Integer.parseInt(version1);

            if(v1t > v2First)
                return 1;
            if(v1t < v2First)
                return -1;
            if(v2Second > 0)
                return -1;
        }

        if(version1.contains(".")==false && version2.contains(".")==false){
            int v1t = Integer.parseInt(version1);
            int v2t = Integer.parseInt(version2);

            if(v1t > v2t)
                return 1;
            if(v1t < v2t)
                return -1;

        }

        return 0;
    }

}