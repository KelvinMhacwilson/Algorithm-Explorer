package utils;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private final int vertices;
  private final List<Edge>[] adjacencyList;

  public Graph(int vertices) {
    this.vertices = vertices;
    this.adjacencyList = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      this.adjacencyList[i] = new ArrayList<>();
    }
  }

  public void addEdge(int source, int destination, int weight) {
    this.adjacencyList[source].add(new Edge(source, destination, weight));
    this.adjacencyList[destination].add(new Edge(destination, source, weight)); // Assuming undirected graph
  }

  public List<Edge> getAdjacencyList(int vertex) {
    return this.adjacencyList[vertex];
  }

  public List<Edge> getAllEdges() {
    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
      edges.addAll(adjacencyList[i]);
    }
    return edges;
  }

  public int getVertices() {
    return vertices;
  }

  public static class Edge implements Comparable<Edge> {
    public final int source;
    public final int destination;
    public final int weight;

    public Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
      return this.weight - other.weight;
    }
  }
}
