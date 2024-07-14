package algorithms.greedy;

public class TravelingSalesman {

  public int[] findApproximateSolution(int[][] graph) {
    int V = graph.length;
    int[] path = new int[V];
    boolean[] visited = new boolean[V];
    visited[0] = true;
    path[0] = 0;

    for (int i = 1; i < V; i++) {
      int minVertex = -1;
      int minValue = Integer.MAX_VALUE;
      for (int j = 0; j < V; j++) {
        if (!visited[j] && graph[path[i - 1]][j] < minValue) {
          minVertex = j;
          minValue = graph[path[i - 1]][j];
        }
      }
      path[i] = minVertex;
      visited[minVertex] = true;
    }

    return path;
  }
}
