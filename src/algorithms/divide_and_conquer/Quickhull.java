package algorithms.divide_and_conquer;

import utils.Point;

import java.util.ArrayList;
import java.util.List;

public class Quickhull {

  public List<Point> findConvexHull(Point[] points) {
    List<Point> convexHull = new ArrayList<>();
    if (points.length < 3) {
      return convexHull;
    }

    int minIndex = 0, maxIndex = 0;
    for (int i = 1; i < points.length; i++) {
      if (points[i].x < points[minIndex].x) {
        minIndex = i;
      }
      if (points[i].x > points[maxIndex].x) {
        maxIndex = i;
      }
    }

    hullHelper(points, convexHull, points[minIndex], points[maxIndex], 1);
    hullHelper(points, convexHull, points[minIndex], points[maxIndex], -1);

    return convexHull;
  }

  private void hullHelper(Point[] points, List<Point> hull, Point p, Point q, int side) {
    int index = -1;
    double maxDistance = 0;
    for (int i = 0; i < points.length; i++) {
      double currentDistance = calculateDistance(p, q, points[i]);
      if (findSide(p, q, points[i]) == side && currentDistance > maxDistance) {
        index = i;
        maxDistance = currentDistance;
      }
    }

    if (index == -1) {
      if (!hull.contains(p)) {
        hull.add(p);
      }
      if (!hull.contains(q)) {
        hull.add(q);
      }
      return;
    }

    hullHelper(points, hull, points[index], p, -findSide(points[index], p, q));
    hullHelper(points, hull, points[index], q, -findSide(points[index], q, p));
  }

  private int findSide(Point p, Point q, Point r) {
    double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    if (val == 0) {
      return 0;
    } else if (val > 0) {
      return 1;
    } else {
      return -1;
    }
  }

  private double calculateDistance(Point p, Point q, Point r) {
    return Math.abs((r.y - p.y) * (q.x - p.x) - (q.y - p.y) * (r.x - p.x));
  }
}
