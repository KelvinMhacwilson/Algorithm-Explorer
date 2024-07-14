package algorithms.greedy;

import base.GreedyAlgorithm;

public class DijkstraShortestPath extends GreedyAlgorithm {
  private long executionTime;

  @Override
  public void execute() {
    long startTime = System.nanoTime();
    // Implementation of Dijkstra's Shortest Path
    executionTime = System.nanoTime() - startTime;
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }
}
