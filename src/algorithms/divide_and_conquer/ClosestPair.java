package algorithms.divide_and_conquer;

import utils.Point;

import java.util.Arrays;

public class ClosestPair {

  public double findClosestPair(Point[] points) {
    Arrays.sort(points, (p1, p2) -> Double.compare(p1.x, p2.x));
    return closestPair(points, 0, points.length - 1);
  }

  private double closestPair(Point[] points, int low, int high) {
    if (high - low + 1 <= 3) {
      return bruteForce(points, low, high);
    }

    int mid = (low + high) / 2;
    Point midPoint = points[mid];

    double leftClosest = closestPair(points, low, mid);
    double rightClosest = closestPair(points, mid + 1, high);
    double minDistance = Math.min(leftClosest, rightClosest);

    Point[] strip = new Point[high - low + 1];
    int j = 0;
    for (int i = low; i <= high; i++) {
      if (Math.abs(points[i].x - midPoint.x) < minDistance) {
        strip[j++] = points[i];
      }
    }

    return Math.min(minDistance, stripClosest(strip, j, minDistance));
  }

  private double bruteForce(Point[] points, int low, int high) {
    double min = Double.POSITIVE_INFINITY;
    for (int i = low; i <= high; ++i) {
      for (int j = i + 1; j <= high; ++j) {
        double dist = distance(points[i], points[j]);
        if (dist < min) {
          min = dist;
        }
      }
    }
    return min;
  }

  private double stripClosest(Point[] strip, int size, double d) {
    double min = d;
    Arrays.sort(strip, 0, size, (p1, p2) -> Double.compare(p1.y, p2.y));

    for (int i = 0; i < size; ++i) {
      for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
        double dist = distance(strip[i], strip[j]);
        if (dist < min) {
          min = dist;
        }
      }
    }
    return min;
  }

  private double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }
}
