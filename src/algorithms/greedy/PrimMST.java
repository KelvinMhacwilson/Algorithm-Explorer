package algorithms.greedy;

import utils.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimMST {

  public List<Graph.Edge> findMST(Graph graph) {
    int V = graph.getVertices();
    List<Graph.Edge> mst = new ArrayList<>();
    boolean[] visited = new boolean[V];
    PriorityQueue<Graph.Edge> pq = new PriorityQueue<>();

    visit(0, graph, visited, pq);

    while (!pq.isEmpty() && mst.size() < V - 1) {
      Graph.Edge edge = pq.poll();
      int u = edge.destination;
      int v = edge.source;

      if (visited[u] && visited[v]) {
        continue;
      }

      mst.add(edge);
      if (!visited[u]) {
        visit(u, graph, visited, pq);
      }
      if (!visited[v]) {
        visit(v, graph, visited, pq);
      }
    }

    return mst;
  }

  private void visit(int vertex, Graph graph, boolean[] visited, PriorityQueue<Graph.Edge> pq) {
    visited[vertex] = true;
    for (Graph.Edge edge : graph.getAdjacencyList(vertex)) {
      if (!visited[edge.destination]) {
        pq.offer(edge);
      }
    }
  }
}
