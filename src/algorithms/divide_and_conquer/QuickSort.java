package algorithms.divide_and_conquer;

import base.DivideAndConquerAlgorithm;

public class QuickSort extends DivideAndConquerAlgorithm {
  private long executionTime;

  @Override
  public void execute() {
    long startTime = System.nanoTime();
    // Implementation of QuickSort
    executionTime = System.nanoTime() - startTime;
  }

  public void sort(int[] array) {
    execute();
    // Implementation code here
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }
}
