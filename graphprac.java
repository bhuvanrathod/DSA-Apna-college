import java.util.*;

public class graphprac{
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void creategraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0,1,1));
        // graph[0].add(new Edge(0,2,1));
        // graph[1].add(new Edge(1,0,1));
        // graph[1].add(new Edge(1,3,1));
        // graph[2].add(new Edge(2,0,1));
        // graph[2].add(new Edge(2,4,1));
        // graph[3].add(new Edge(3,1,1));
        // graph[3].add(new Edge(3,4,1));
        // graph[3].add(new Edge(3,5,1));
        // graph[4].add(new Edge(4,2,1));
        // graph[4].add(new Edge(4,3,1));
        // graph[4].add(new Edge(4,5,1));
        // graph[5].add(new Edge(5,3,1));
        // graph[5].add(new Edge(5,4,1));
        // graph[5].add(new Edge(5,6,1));
        // graph[6].add(new Edge(6,5,1));



        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, -4));

        // graph[2].add(new Edge(2, 3, 2));

        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));


        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visit = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visit[i]){
                bfsutil(graph,visit);
            }
        }
    }
    public static void bfsutil(ArrayList<Edge>[] graph,boolean[] visit){
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visit[curr]){
                System.err.println(curr);
                visit[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // dfs

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] visit = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visit[i]){
                dfsutil(graph,i,visit);
            }
        }
    }

    public static void dfsutil(ArrayList<Edge>[] graph,int curr,boolean visit[]){
        System.out.println(curr);
        visit[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]){
                dfsutil(graph,e.dest,visit);
            }
        }
    }

    // haspath

    public static boolean haspath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visit){
        if(src == dest){
            return true;
        }
        visit[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visit[e.dest] && haspath(graph,e.dest,dest,visit)){
                return true;
            }
        }
        return false;
    }

    //detect cycle in undirected graph

    public static boolean detectcycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(detectcycleutil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectcycleutil(ArrayList<Edge>[] graph,boolean vis[],int curr,int par){
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                if(detectcycleutil(graph, vis, e.dest, curr)){
                    return true;
                }
            }else if(vis[e.dest] && e.dest != par){
                return false;
            }
        }
        return false;
    }

    // bipartite graph

    // Acyclic -> true
    // Even -> true
    // odd -> false

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++){
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0;

                while(!q.isEmpty()){
                    int curr = q.remove();

                    for(int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){
                            int nextcol = col[curr] == 0 ? 0:1;
                            col[e.dest] = nextcol;
                            q.add(e.dest);
                        }else if(col[e.dest] == col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // topological sort

    public static void topsort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                topsortutil(graph,i,vis,s);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop()+" ");
        }
    }

    public static void topsortutil(ArrayList<Edge>[] graph,int curr,boolean vis[],Stack<Integer> s){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topsortutil(graph,e.dest,vis,s);
            }
        }
        s.push(curr);
    }

    // cycle detection in directed graph

    public static boolean iscycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(iscycleutil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean iscycleutil(ArrayList<Edge>[] graph,int curr,boolean visi[],boolean[] stack){
        visi[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(stack[e.dest]){
                return true;
            }
            if(!visi[e.dest] && iscycleutil(graph, e.dest, visi, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    // topological sort using bfs  indegree and out degree   kahn's algorithm

    public static void indegree(ArrayList<Edge>[] graph,int[] indeg){
        for(int i=0; i<graph.length; i++){
            int v = i;
            for(int j=0; j<graph[v].size(); j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topsortbfs(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        indegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

    }

    //dijkstra algorithm 

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {

        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {

                    Edge e = graph[curr.n].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        System.out.println("Shortest distance from source:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("0 -> " + i + " = " + dist[i]);
        }
    }

    // print all path

    public static void printallpath(ArrayList<Edge>[] graph,int src,int dest,String path){
        if(src == dest){
            System.out.println(path+dest+" ");
            return;
        }
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            printallpath(graph, e.dest, dest, path);
        }
    }

    // Belman ford Algorithm -> for negative weight and it is not satisify for -ve wt cycle

    public static void bellmanford(ArrayList<Edge>[] graph,int src){  //O(V*E)
        int[] dist = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        // vertices
        for(int i=0; i<V-1; i++){
            //O(E) -> for edge
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;
                    //Relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
    }

    //prim's algorithm

    static class pairp implements Comparable<pairp>{
        int v;
        int cost;
        public pairp(int v,int c){
            this.v = v;
            this.cost = c;
        }
        @Override
        public int compareTo(pairp p1){
            return this.cost - p1.cost;
        }
    }

    public static void prims(ArrayList<Edge>[] graph){
        boolean visi[] = new boolean[graph.length];
        PriorityQueue<pairp> pq = new PriorityQueue<>();
        pq.add(new pairp(0,0));
        int finalcost = 0;

        while(!pq.isEmpty()){
            pairp curr = pq.remove();
            if(!visi[curr.v]){
                visi[curr.v] = true;
                finalcost += curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new pairp(e.dest,e.wt));
                }
            }
        }
        System.out.println(finalcost);
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();

            if(curr.stops > k) {
                break;
            }

            for(int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] && curr.stops <= k) {
                    dist[v] = dist[u] + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    // connect cities with minimum cost

    // static class edge implements Comparable<edge>{
    //     int dest;
    //     int cost;

    //     public edge(int d,int c){
    //         this.dest = d;
    //         this.cost = c;
    //     }

    //     @Override
    //     public int compareTo(edge e2){
    //         return this.cost  - e2.cost;
    //     }
    // }

    // public static int connectcites(int cities[][]){
    //     PriorityQueue<edge> pq = new PriorityQueue<>();
    //     boolean vis[] = new boolean[cities.length];
    //     pq.add(new edge(0,0));
    //     int finalcost = 0;

    //     while(!pq.isEmpty()){
    //         edge curr = pq.remove();
    //         if(!vis[curr.dest]){
    //             vis[curr.dest] = true;
    //             finalcost += curr.dest;

    //             for(int i=0; i<cities[curr.dest].length; i++){
    //                 if(cities[curr.dest][i] != 0){
    //                     pq.add(new edge(i,cities[curr.dest][i]));
    //                 }
    //             }
    //         }
    //     }
    //     return finalcost;
    // }

    //union and find

    static int n = 7;
    static int par[] = new int[7];
    static int rank[] = new int[7];

    public static void init(){
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        }else{
            par[parA] = parA;
        }
    }

    // kruskal algorithm

    static class edge implements Comparable<edge>{
        int src;
        int dest;
        int wt;

        public edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(edge e2){
            return this.wt  - e2.wt;
        }
    }

    public static void creategraph(ArrayList<edge> edges){
        //edges
        edges.add(new edge(0,1,10));
        edges.add(new edge(0,2,15));
        edges.add(new edge(0,3,30));
        edges.add(new edge(1,3,40));
        edges.add(new edge(2,3,50));

        
    }

    public static void kurskalmst(ArrayList<edge> edges,int v){
        init();
        Collections.sort(edges);
        int mstcost = 0;
        int count = 0;
        for(int i=0; count<v-1; i++){
            edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA != parB){
                union(e.src,e.dest);
                mstcost += e.wt;
                count++;
            }
        }
        System.out.println(mstcost);
    }

    // kosaraju algorithm 

    static class Edgek{
        int src;
        int dest;

        public Edgek(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void creategraphk(ArrayList<Edgek> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // graph[0].add(new Edgek(0, 2));
        // graph[0].add(new Edgek(0, 3));

        // graph[1].add(new Edgek(1, 0));

        // graph[2].add(new Edgek(2, 1));

        // graph[3].add(new Edgek(3, 4));

        //tarjans algo
        // graph[0].add(new Edgek(0, 1));
        // graph[0].add(new Edgek(0, 2));
        // graph[0].add(new Edgek(0, 3));

        // graph[1].add(new Edgek(1, 0));
        // graph[1].add(new Edgek(1, 2));

        // graph[2].add(new Edgek(2, 0));
        // graph[2].add(new Edgek(2, 1));

        // graph[3].add(new Edgek(3, 0));
        // graph[3].add(new Edgek(3, 4));
        // graph[3].add(new Edgek(3, 5));

        // graph[4].add(new Edgek(4, 3));
        // graph[4].add(new Edgek(4, 5));

        // graph[5].add(new Edgek(5, 3));
        // graph[5].add(new Edgek(5, 4));

        graph[0].add(new Edgek(0, 1));
        graph[0].add(new Edgek(0, 2));
        graph[0].add(new Edgek(0, 3));

        graph[1].add(new Edgek(1, 0));
        graph[1].add(new Edgek(1, 2));

        graph[2].add(new Edgek(2, 0));
        graph[2].add(new Edgek(2, 1));

        graph[3].add(new Edgek(3, 0));
        graph[3].add(new Edgek(3, 4));

        graph[4].add(new Edgek(4, 3));
    }

    public static void topsortk(ArrayList<Edgek>[] graph,int curr,boolean[] vis,Stack<Integer> s){
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edgek e = graph[curr].get(i);
            if(!vis[e.dest]){
                topsortk(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfsk(ArrayList<Edgek>[] graph,int curr,boolean vis[]){
        vis[curr] = true;
        System.out.print(curr+" ");

        for(int i=0; i<graph[curr].size(); i++){
            Edgek e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsk(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edgek>[] graph,int v){
        //step1 get node in stack using topological sort
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!vis[i]){
                topsortk(graph,i,vis,s);
            }
        }

        //step 2 -> transpose the graph(copy graph)
        ArrayList<Edgek>[] transpose = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for(int i=0; i<v; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edgek e = graph[i].get(j);
                transpose[e.dest].add(new Edgek(e.dest,e.src));
            }
        }

        //step3 -> do dfs accocding to stack nodes on the transpose graph
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                System.out.print("scc ->");
                dfsk(transpose,curr,vis);
                System.out.println();
            }
        } 
    }

    //bridge in graph -> tarjan's algorithm
    public static void dfs(ArrayList<Edgek> graph[], int curr, int par,
                       int dt[], int low[], boolean vis[], int time) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edgek e = graph[curr].get(i); // e.src --- e.dest
            int neigh = e.dest;

            if(neigh == par) {
                continue;
            }
            else if(!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);

                if(dt[curr] < low[neigh]) {
                    System.out.println("Bridge : " + curr + " ---- " + neigh);
                }
            }
            else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edgek> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    // ariculate point

    public static void dfs(ArrayList<Edgek> graph[], int curr, int par,
                       int dt[], int low[], int time, boolean vis[]) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edgek e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh) {
                continue;
            }   
            else if(vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
            else {
                dfs(graph, neigh, curr, dt, low, time, vis);
                low[curr] = Math.min(low[curr], low[neigh]);

                if(par != -1 && dt[curr] <= low[neigh]) {
                    System.out.println("Ap : " + curr);
                }
                children++;
            }
        }

        if(par == -1 && children > 1) {
            System.out.println("Ap : " + curr);
        }
    }

    public static void getAP(ArrayList<Edgek> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis);
            }
        }
    }
    public static void main(String[] args) {
        int v= 5;
        ArrayList<Edgek> graph[] = new ArrayList[v];
        creategraphk(graph);
        getAP(graph, v);
        // tarjanBridge(graph, v);
        // kosaraju(graph, v);
        // kurskalmst(edge, v);

    //     init();
    // System.out.println(find(3));

    // union(1, 3);
    // System.out.println(find(3));

    // union(2, 4);
    // union(3, 6);
    // union(1, 4);

    // System.out.println(find(3));
    // System.out.println(find(4));

    // union(1, 5);


//         int cities[][] = {
//     {0, 1, 2, 3, 4},
//     {1, 0, 5, 0, 7},
//     {2, 5, 0, 6, 0},
//     {3, 0, 6, 0, 0},
//     {4, 7, 0, 0, 0}
// };

//     System.out.println("final cost "+ connectcites(cities));
        // int n = 4;

        // int flights[][] = {
        //     {0,1,100},
        //     {1,2,100},
        //     {2,3,100},
        //     {0,2,500}
        // };

        // int src = 0;
        // int dest = 3;
        // int k = 1;

        // System.out.println(cheapestFlight(n, flights, src, dest, k));

        // int v = 5;
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // creategraph(graph);
        // topsort(graph);
        // topsortbfs(graph);
        // bellmanford(graph, 0);
        // prims(graph);

        // printallpath(graph, 1, 5, "");
        // int v = 5;
        // ArrayList<Edge>[] graph = new ArrayList[v];

        // for(int i=0; i<v; i++){
        //     graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new Edge(0,1,5));
        // graph[1].add(new Edge(1,2,2));
        // graph[2].add(new Edge(2,3,7));
        // graph[3].add(new Edge(3,1,3));

        // for(int i=0; i<graph[2].size(); i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }gfbgf
    }
}