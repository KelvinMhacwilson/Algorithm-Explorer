package algorithms.greedy;

import base.GreedyAlgorithm;

public class HuffmanCoding extends GreedyAlgorithm {
  private long executionTime;

  @Override
  public void execute() {
    long startTime = System.nanoTime();
    // Implementation of Huffman Coding
    executionTime = System.nanoTime() - startTime;
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }
}
