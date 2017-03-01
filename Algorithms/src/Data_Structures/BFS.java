/**
 * Daniel Delago
 * Breadth First Search and Shortest Path
 * -Uses queue, enqueue all unvisited children of current node then
 *  dequeue the node. Move on to next element and do the same.
 * -Order of Traversal depends on order that I insert the nodes,
 *  To "fix" just sort the children ArrayList of every vertex.
 * -To find shortest path from any 2 nodes you first must
 *  Perform BFS on the starting node.
 **/
package Data_Structures;
import java.util.*;

/*** The Vertices of a graph,
 *   A graph with no cycles and every node has unique children(no repeats) is a N-ary Tree ***/
class Vertex{
    int id;
    int level;
    Vertex parent;
    ArrayList<Vertex> children;

    public Vertex(){
        children = new ArrayList<Vertex>();
    }
}

public class BFS {

    int v;
    //Array of Vertices
    Vertex[] vertices;

    public BFS(int size){
        v = size;
        vertices = new Vertex[size];
        //Assign id's to vertices
        for(int i=0;i<size;i++) {
            vertices[i] = new Vertex();
            vertices[i].id = i;
        }
    }

    //Adding an edge is adding a child to a vertex
    public void addEdge(int a, int b){
        //Add vertex b to a's list of children
        vertices[a].children.add(vertices[b]);

    }

    public void bfs(int root){

        //A queue of vertices
        ArrayList<Integer> queue = new ArrayList<Integer>();

        //A list of visited vertices
        boolean[] visited = new boolean[v];

        //Add root to visited and enqueue
        visited[root]=true;
        queue.add(root);

        //While queue is not empty
        while(queue.size()!=0){

            System.out.print(queue.get(0) + " ");
            //Get current vertex in the queue
            Vertex cur = vertices[queue.get(0)];

            //For every child that cur has
            for(int i=0;i<cur.children.size();i++){

                //Get current child
                Vertex child = cur.children.get(i);

                //If the child hasn't been visited
                if(visited[child.id]==false){
                    //Child has been visited
                    visited[child.id]=true;
                    //Child's parent is cur
                    child.parent=cur;
                    //Child's level is parent's + 1
                    child.level=cur.level+1;
                    //Enqueue child
                    queue.add(child.id);
                }
            }
            //Dequeue
            queue.remove(0);
        }
    }

    //Finds Shortest path from root to a vertex
    public void shortestPath(int a, int b){

        //Root Vertex
        Vertex start = vertices[a];

        //Ending Vertex
        Vertex cur = vertices[b];
        String path = "";

        //Continuously adds the path of parents that lead back to the root.
        while(cur!=start.parent){
            path += cur.id;
            cur = cur.parent;
        }

        //Print Shortest Path
        System.out.print("\nShortest Path: ");
        for(int i=path.length()-1;i>=0;i--)
            System.out.print(path.charAt(i) + " ");
    }

    public static void main(String args[]){
//        //Create graph with 5 vertices
//        BFS graph = new BFS(4);
//        //Add edges
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(1,2);
//        graph.addEdge(2,0);
//        graph.addEdge(2,3);
//        graph.addEdge(3,3);
//
//        //BFS from vertex 2
//        graph.bfs(2);
//
//        graph.shortestPath(2,1);

        Scanner in = new Scanner(System.in);

        //Get Size of Graph and Create it
        System.out.print("Number of Vertices: ");
        int size = in.nextInt();
        BFS graph = new BFS(size);

        //Add Edges to the Graph
        System.out.println("Edges:(from to)");
        while(true){
            System.out.print(":");
            int a = in.nextInt();
            int b = in.nextInt();

            if(a == -1 || b == -1)
                break;

            graph.addEdge(a,b);
        }

        System.out.print("Start BFS from: ");
        graph.bfs(in.nextInt());

        System.out.print("\nFind Shortest Path:(from to)");
        while(true){
            System.out.print("\n:");
            int a = in.nextInt();
            int b = in.nextInt();

            if(a == -1 || b == -1)
                break;
            System.out.print("BFS: ");
            graph.bfs(a);
            graph.shortestPath(a,b);
        }

        /*** If 2D Matrix as Input ***/
        /*
         * graph(A.length)
         * for(length)
         *   for(length)
         *      if(A[i][j]==1)
         *         graph.addEdge(i,j)
         */

    }
}
