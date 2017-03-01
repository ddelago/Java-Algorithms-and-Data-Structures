/**
 * Daniel Delago
 * Reverse a String in place
 **/

package Practice_Problems;
import java.util.*;
import java.io.*;

public class WordOccurences {


    public void count(String a, String file){

        try {

            //Counter
            int occurrences = 0;

            //Convert a to lower case
            a = a.toLowerCase();

            //Get the file
            Scanner in = new Scanner(new File(file));

            //For Every line in the file
            while(in.hasNextLine()){

                //Split on spaces to compare words
                String[] line = in.nextLine().split(" ");

                //For every word in the line
                for(int i=0;i<line.length;i++){

                    //If there is a match
                    if(line[i].toLowerCase().compareTo(a) == 0){

                        //Increment occurrences
                        occurrences += 1;

                    }
                }
            }

            System.out.println(occurrences);

        } catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String args[]){

        WordOccurences go = new WordOccurences();

        //Count the occurrences of "The" in the file
        go.count("The", ".//src//Practice_Problems//Sample.txt");

    }

}
