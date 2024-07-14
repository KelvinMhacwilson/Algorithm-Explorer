package algorithms.greedy;

import base.GreedyAlgorithm;

public class TravelingSalesman extends GreedyAlgorithm {
  private long executionTime;

  @Override
  public void execute() {
    long startTime = System.nanoTime();
    // Implementation of Traveling Salesman Problem
    executionTime = System.nanoTime() - startTime;
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }
}
