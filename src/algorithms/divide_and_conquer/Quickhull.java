package algorithms.divide_and_conquer;

import base.DivideAndConquerAlgorithm;
import utils.Point;

import java.util.List;

public class Quickhull extends DivideAndConquerAlgorithm {
  private long executionTime;

  @Override
  public void execute() {
    long startTime = System.nanoTime();
    // Implementation of Quickhull
    executionTime = System.nanoTime() - startTime;
  }

  public List<Point> findConvexHull(Point[] points) {
    execute();
    // Implementation code here
    return null; // Replace with actual convex hull points
  }

  @Override
  public long getExecutionTime() {
    return executionTime;
  }
}
