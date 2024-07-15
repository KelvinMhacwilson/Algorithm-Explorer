package algorithms.greedy;

import java.util.Arrays;

public class PrimMST {

  public void findMST(int[][] graph, int V) {
    int[] parent = new int[V];
    int[] key = new int[V];
    boolean[] mstSet = new boolean[V];

    Arrays.fill(key, Integer.MAX_VALUE);
    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < V - 1; count++) {
      int u = minKey(key, mstSet, V);
      mstSet[u] = true;

      for (int v = 0; v < V; v++) {
        if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
          parent[v] = u;
          key[v] = graph[u][v];
        }
      }
    }

    printMST(parent, graph, V);
  }

  private int minKey(int[] key, boolean[] mstSet, int V) {
    int min = Integer.MAX_VALUE, minIndex = -1;
    for (int v = 0; v < V; v++) {
      if (!mstSet[v] && key[v] < min) {
        min = key[v];
        minIndex = v;
      }
    }
    return minIndex;
  }

  private void printMST(int[] parent, int[][] graph, int V) {
    System.out.println("Edge \tWeight");
    for (int i = 1; i < V; i++) {
      System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
  }
}
