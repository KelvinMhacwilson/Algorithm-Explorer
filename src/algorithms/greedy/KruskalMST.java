package algorithms.greedy;

import utils.Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalMST {

  public List<Graph.Edge> findMST(Graph graph) {
    List<Graph.Edge> edges = graph.getAllEdges();
    Collections.sort(edges);

    int[] parent = new int[graph.getVertices()];
    for (int i = 0; i < graph.getVertices(); i++) {
      parent[i] = i;
    }

    List<Graph.Edge> mst = new ArrayList<>();
    int edgesAccepted = 0;
    int i = 0;

    while (edgesAccepted < graph.getVertices() - 1 && i < edges.size()) {
      Graph.Edge edge = edges.get(i++);
      int x = find(parent, edge.source);
      int y = find(parent, edge.destination);

      if (x != y) {
        mst.add(edge);
        union(parent, x, y);
        edgesAccepted++;
      }
    }

    return mst;
  }

  private int find(int[] parent, int vertex) {
    if (parent[vertex] != vertex) {
      parent[vertex] = find(parent, parent[vertex]);
    }
    return parent[vertex];
  }

  private void union(int[] parent, int x, int y) {
    int rootX = find(parent, x);
    int rootY = find(parent, y);
    parent[rootY] = rootX;
  }
}
