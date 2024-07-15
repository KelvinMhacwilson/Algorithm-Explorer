package algorithms.greedy;

import utils.Graph;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    private int[] dist;
    private int[] previous;

    public void computeShortestPaths(Graph graph, int source) {
        int V = graph.getVertices();
        dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        previous = new int[V];
        Arrays.fill(previous, -1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        pq.offer(source);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (Graph.Edge edge : graph.getAdjacencyList(u)) {
                int v = edge.destination;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    previous[v] = u;
                    pq.offer(v);
                }
            }
        }
    }

    public int getShortestDistance(int vertex) {
        return dist[vertex];
    }

    public int[] getShortestPath(int destination) {
        int V = dist.length;
        int[] path = new int[V];
        int current = destination;
        int index = 0;
        while (current != -1) {
            path[index++] = current;
            current = previous[current];
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = path[index - 1 - i];
        }
        return result;
    }
}
