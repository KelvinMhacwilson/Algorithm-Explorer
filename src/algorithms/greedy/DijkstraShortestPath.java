package algorithms.greedy;

import utils.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

  public int[] shortestPath(Graph graph, int source) {
    int V = graph.getVertices();
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(source);

    while (!pq.isEmpty()) {
      int u = pq.poll();
      for (Graph.Edge edge : graph.getAdjacencyList(u)) {
        int v = edge.destination;
        int weight = edge.weight;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
          dist[v] = dist[u] + weight;
          pq.offer(v);
        }
      }
    }

    return dist;
  }
}
