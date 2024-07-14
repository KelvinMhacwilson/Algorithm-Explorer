package utils;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private int V;
  private List<List<Edge>> adjacencyList;

  public Graph(int V) {
    this.V = V;
    adjacencyList = new ArrayList<>(V);
    for (int i = 0; i < V; i++) {
      adjacencyList.add(new ArrayList<>());
    }
  }

  public void addEdge(int u, int v, int weight) {
    adjacencyList.get(u).add(new Edge(u, v, weight));
    adjacencyList.get(v).add(new Edge(v, u, weight)); // For undirected graph
  }

  public List<List<Edge>> getAdjacencyList() {
    return adjacencyList;
  }

  public int getV() {
    return V;
  }

  public static class Edge {
    public int u;
    public int v;
    public int weight;

    public Edge(int u, int v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }
  }
}
