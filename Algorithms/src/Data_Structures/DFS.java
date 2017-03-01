/**
 * Daniel Delago
 * Depth First Search:
 * Order of Traversal depends on order that I insert the nodes,
 * To "fix" just sort the children ArrayList of every vertex.
 **/
package Data_Structures;
import java.util.*;

class DFSVertex{

    int id;
    ArrayList<DFSVertex> children;

    public DFSVertex(){
        children = new ArrayList<DFSVertex>();
    }
}

public class DFS {

    int v;
    //Array of Vertices
    DFSVertex[] vertices;

    public DFS(int size){
        v = size;
        vertices = new DFSVertex[size];
        for(int i=0;i<size;i++) {
            vertices[i] = new DFSVertex();
            vertices[i].id = i;
        }
    }

    //Adding an edge is adding a child to a vertex
    public void addEdge(int a, int b){
        //Add vertex b to a's list of children
        vertices[a].children.add(vertices[b]);

    }

    public void dfs(int root){

        //A list of visited vertices
        boolean[] visited = new boolean[v];

        dfsVisit(root, visited);

    }

    public void dfsVisit(int vertex, boolean[] visited){

        //Add to visited
        visited[vertex]=true;
        System.out.print(vertex + " ");

        //Current Vertex
        DFSVertex cur = vertices[vertex];

        //For every child that cur has
        for(int i=0;i<cur.children.size();i++){

            //Get current child
            DFSVertex child = cur.children.get(i);

            //If the child hasn't been visited
            if(visited[child.id]==false){

                //Recursively call dfsVisit
                dfsVisit(child.id,visited);

            }//Else: Child has already been visited and there is a cycle
        }
    }

    public static void main(String args[]){

        //Create graph with 4 vertices
        DFS graph = new DFS(4);
        //Add edges
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        //DFS from vertex 2
        graph.dfs(2);

        /*** User input Graph ***/
        Scanner in = new Scanner(System.in);

        //Get Size of Graph and Create it
        System.out.print("\nNumber of Vertices: ");
        int size = in.nextInt();
        DFS graph2 = new DFS(size);

        //Add Edges to the Graph
        System.out.println("Edges:(from to)");
        while(true){
            System.out.print(":");
            int a = in.nextInt();
            int b = in.nextInt();

            if(a == -1 || b == -1)
                break;

            graph2.addEdge(a,b);
        }

        System.out.print("Start DFS from: ");
        graph2.dfs(in.nextInt());

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
