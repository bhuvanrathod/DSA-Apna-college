import java.util.*;

class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class AHSPA_LC{

    static Map<String, String> cache = new HashMap<>();

    // ---------- DIJKSTRA ----------
    static long dijkstra(int V, List<List<Edge>> graph, int src) {

        long start = System.nanoTime();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int u = curr[0];

            for (Edge e : graph.get(u)) {

                int v = e.v;
                int w = e.w;

                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("\nDijkstra Distances:");
        System.out.println(Arrays.toString(dist));

        return end - start;
    }

    // ---------- BELLMAN FORD ----------
    static long bellmanFord(int V, List<Edge> edges, int src) {

        long start = System.nanoTime();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {

            for (Edge e : edges) {

                if (dist[e.u] != Integer.MAX_VALUE &&
                        dist[e.u] + e.w < dist[e.v]) {

                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("\nBellman-Ford Distances:");
        System.out.println(Arrays.toString(dist));

        return end - start;
    }

    // ---------- FLOYD WARSHALL ----------
    static long floydWarshall(int[][] graph, int V) {

        long start = System.nanoTime();

        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++)
            dist[i] = Arrays.copyOf(graph[i], V);

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        long end = System.nanoTime();

        System.out.println("\nFloyd Warshall Result:");
        for (int i = 0; i < V; i++)
            System.out.println(Arrays.toString(dist[i]));

        return end - start;
    }

    // ---------- ADAPTIVE ALGORITHM ----------
    static void adaptiveAlgorithm(int V, int E,
                                  List<Edge> edges,
                                  List<List<Edge>> graph,
                                  int[][] matrix) {

        boolean negativeEdge = false;

        for (Edge e : edges)
            if (e.w < 0)
                negativeEdge = true;

        double density = (double) E / (V * (V - 1));

        System.out.println("\nGraph Density = " + density);

        long time;
        String algorithmUsed;

        if (negativeEdge) {

            algorithmUsed = "Bellman-Ford";
            time = bellmanFord(V, edges, 0);

        } else if (density < 0.5) {

            algorithmUsed = "Dijkstra";
            time = dijkstra(V, graph, 0);

        } else {

            algorithmUsed = "Floyd-Warshall";
            time = floydWarshall(matrix, V);
        }

        cache.put(V + "-" + E, algorithmUsed);

        System.out.println("\nAlgorithm Selected: " + algorithmUsed);
        System.out.println("Execution Time: " + time + " nanoseconds");

        performanceTable(V, E, density, algorithmUsed, time);
    }

    // ---------- PERFORMANCE TABLE ----------
    static void performanceTable(int V, int E, double density,
                                 String algorithm, long time) {

        System.out.println("\n--- PERFORMANCE COMPARISON ---");

        System.out.println("Vertices: " + V);
        System.out.println("Edges: " + E);
        System.out.println("Density: " + density);

        System.out.println("Algorithm Used: " + algorithm);
        System.out.println("Execution Time: " + time + " ns");

        System.out.println("------------------------------");
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        int INF = 999999;

        int[][] matrix = new int[V][V];

        for (int i = 0; i < V; i++)
            Arrays.fill(matrix[i], INF);

        for (int i = 0; i < V; i++)
            matrix[i][i] = 0;

        System.out.println("Enter edges (source destination weight):");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges.add(new Edge(u, v, w));
            graph.get(u).add(new Edge(u, v, w));
            matrix[u][v] = w;
        }

        adaptiveAlgorithm(V, E, edges, graph, matrix);
    }
}