import java.util.*;
public class AdjacencyList{
    static class Edge{
        int src;
        int dest;
        int wt;
    
        public  Edge (int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void main(String[] args){
       /* 
                   (5)
               0 ------ 1
                       / \
                 (1)  /   \ (3)
                     /     \
                     2 ----- 3  
                     |  (1)
                (2)  |   
                     |
                     4
       
        */
        int V = 5;
        ArrayList<Edge>[] Graph = new ArrayList[V]; // null -> empty arraylist
        
        for(int i=0; i<V; i++){
            Graph[i]=new ArrayList<>();
        }
        //0 -vertex
        Graph[0].add(new Edge(0, 1, 5));
         
         //1 -vertex
         Graph[1].add(new Edge( 1, 0, 5));
        Graph[1].add(new Edge( 1, 2, 1));
        Graph[1].add(new Edge( 1, 3, 3));

        //2 -vertex
         Graph[2].add(new Edge( 2, 1, 1));
        Graph[2].add(new Edge( 2, 3, 1));
        Graph[2].add(new Edge( 2, 4, 2));

        //3 -vertex
         Graph[3].add(new Edge( 3, 1, 3));
        Graph[3].add(new Edge( 3, 2, 1));

        //4 -vertex
         Graph[4].add(new Edge( 4, 2, 2));

        
        //2's neighbors

        for(int i=0; i<Graph[2].size(); i++){
            Edge e = Graph[2].get(i); //src, dest, wt
            System.out.println(e.dest);


        }
    }
}