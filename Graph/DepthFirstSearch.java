import java.util.*;
public class DepthFirstSearch{
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
    static  void createGraph(ArrayList<Edge> Graph[]){
    for(int i=0; i<Graph.length; i++){
            Graph[i]=new ArrayList<>();
        }
        //0 -vertex
        Graph[0].add(new Edge(0, 1, 1));
        Graph[0].add(new Edge(0, 2, 1));
         
        //1 -vertex
        Graph[1].add(new Edge( 1, 0, 1));
        Graph[1].add(new Edge( 1, 3, 1));

        //2 -vertex
        Graph[2].add(new Edge( 2, 0, 1));
        Graph[2].add(new Edge( 2, 4, 1));

        //3 -vertex
        Graph[3].add(new Edge( 3, 1, 1));
        Graph[3].add(new Edge( 3, 4, 1));
        Graph[3].add(new Edge( 3, 5, 1));

        //4 -vertex
        Graph[4].add(new Edge( 4, 2, 1));
        Graph[4].add(new Edge( 4, 3, 1));
        Graph[4].add(new Edge( 4, 5, 1));

        //5 -vertex
        Graph[5].add(new Edge( 5, 4, 1));
        Graph[5].add(new Edge( 5, 3, 1));
        Graph[5].add(new Edge( 5, 6, 1));

        //5 -vertex
        Graph[6].add(new Edge( 6, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] Graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[Graph.length];
        q.add(0);//source = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){ //visit curr
              System.out.print(curr+" ");
              vis[curr] = true;
              for(int i=0;i<Graph[curr].size();i++){
                Edge e =Graph[curr].get(i);
                q.add(e.dest);
              }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] Graph, int curr,boolean vis[]){
        //visit
        System.out.print(curr + " ");
        vis[curr] = true;
        for(int i=0; i<Graph[curr].size();i++){
            Edge e= Graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(Graph,e.dest, vis);
            }
        }
    }
    public static void main(String[] args){
       /* 
              1 ---- 3 
             /       | \
            0        |   5 -- 6
             \       |  /
              2 ---- 4
       
        */
        int V = 7;
        ArrayList<Edge>[] Graph = new ArrayList[V]; // null -> empty arraylist
        createGraph(Graph);
        

        
        //3's neighbors

        // for(int i=0; i<Graph[3].size(); i++){
        //     Edge e = Graph[3].get(i); //src, dest, wt
        //     System.out.println(e.dest);
        // }

       // bfs(Graph);
        dfs(Graph,0,new boolean[V]);
    }
}