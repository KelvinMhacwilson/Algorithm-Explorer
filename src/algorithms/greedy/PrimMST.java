package algorithms.greedy;

import base.GreedyAlgorithm;

public class PrimMST extends GreedyAlgorithm {
  private long executionTime;

  @Override
  public void execute() {
    long startTime = System.nanoTime();
    // Implementation of Prim's MST
    executionTime = System.nanoTime() - startTime;
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }
}
