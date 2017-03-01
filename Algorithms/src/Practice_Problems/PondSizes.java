/*
 * Daniel Delago
 *
 */

package Practice_Problems;
import java.util.*;

public class PondSizes {

    ArrayList<Integer> ponds = new ArrayList<Integer>();
    int[][] map;

    public void go(int[][] map){

        this.map = map;

        //For Every Value in the map
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                //If it is water and unvisited
                if(map[i][j]==0){
                    //Add a new pond to the ArrayList
                    ponds.add(0);
                    //Start search for pond size with last added pond
                    search(i,j,ponds.size()-1);
                }
            }
        }
    }

    public void search(int i, int j, int pond){

        //Add to visited
        map[i][j]=-1;

        //Increase pond size
        ponds.set(pond,ponds.get(pond)+1);

        //     If Valid Indexes                                         y    x
        if(i!=-1 && j+1!= -1 && i!=map.length && j+1!=map.length && map[i][j+1]==0)     //Right
            search(i,j+1,pond);
        if(i+1!=-1 && j+1!= -1 && i+1!=map.length && j+1!=map.length &&map[i+1][j+1]==0)    //Down Right
            search(i+1,j+1,pond);
        if(i+1!=-1 && j!= -1 && i+1!=map.length && j!=map.length &&map[i+1][j]==0)      //Down
            search(i+1,j,pond);
        if(i+1!=-1 && j-1!= -1 && i+1!=map.length && j-1!=map.length &&map[i+1][j-1]==0)    //Down Left
            search(i+1,j-1,pond);
        if(i!=-1 && j-1!= -1 && i!=map.length && j-1!=map.length &&map[i][j-1]==0)      //Left
            search(i,j-1,pond);
        if(i-1!=-1 && j-1!= -1 && i-1!=map.length && j-1!=map.length &&map[i-1][j-1]==0)    //Up Left
            search(i-1,j-1,pond);
        if(i-1!=-1 && j!= -1 && i-1!=map.length && j!=map.length &&map[i-1][j]==0)      //Up
            search(i-1,j,pond);
        if(i-1!=-1 && j+1!= -1 && i-1!=map.length && j+1!=map.length &&map[i-1][j+1]==0)    //Up Right
            search(i-1,j+1,pond);

    }



    public static void main(String args[]){

        PondSizes find = new PondSizes();

        int[][] map = {{0,2,1,0},
                       {0,1,0,1},
                       {1,1,0,1},
                       {0,1,0,1}};

        find.go(map);

        for(int i=0;i<find.ponds.size();i++){
            System.out.print(find.ponds.get(i) + " ");
        }
    }

}
