package algorithms.divide_and_conquer;

import base.DivideAndConquerAlgorithm;

public class StrassenMatrixMultiplication extends DivideAndConquerAlgorithm {
  private long executionTime;

  @Override
  public void execute() {
    long startTime = System.nanoTime();
    // Implementation of Strassen's Matrix Multiplication
    executionTime = System.nanoTime() - startTime;
  }

  public void multiply(int[][] A, int[][] B, int[][] C) {
    execute();
    // Implementation code here
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }
}
