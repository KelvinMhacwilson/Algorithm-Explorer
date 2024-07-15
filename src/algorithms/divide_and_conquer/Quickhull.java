package algorithms.divide_and_conquer;

import utils.Point;

import java.util.ArrayList;
import java.util.List;

public class Quickhull {

  public Point[] findConvexHull(Point[] points) {
    List<Point> hull = new ArrayList<>();
    if (points.length < 3)
      return new Point[0];

    int minPoint = -1, maxPoint = -1;
    double minX = Double.MAX_VALUE;
    double maxX = Double.MIN_VALUE;

    for (int i = 0; i < points.length; i++) {
      if (points[i].x < minX) {
        minX = points[i].x;
        minPoint = i;
      }
      if (points[i].x > maxX) {
        maxX = points[i].x;
        maxPoint = i;
      }
    }

    Point A = points[minPoint];
    Point B = points[maxPoint];
    hull.add(A);
    hull.add(B);

    List<Point> leftSet = new ArrayList<>();
    List<Point> rightSet = new ArrayList<>();

    for (int i = 0; i < points.length; i++) {
      Point p = points[i];
      if (p == A || p == B)
        continue;

      if (pointLocation(A, B, p) == -1) {
        leftSet.add(p);
      } else if (pointLocation(A, B, p) == 1) {
        rightSet.add(p);
      }
    }

    hullSet(A, B, rightSet, hull);
    hullSet(B, A, leftSet, hull);

    return hull.toArray(new Point[0]);
  }

  private void hullSet(Point A, Point B, List<Point> set, List<Point> hull) {
    if (set.isEmpty())
      return;

    int insertPosition = hull.indexOf(B);
    if (set.size() == 1) {
      Point p = set.get(0);
      set.remove(p);
      hull.add(insertPosition, p);
      return;
    }

    double dist = Double.MIN_VALUE;
    int furthestPoint = -1;
    for (int i = 0; i < set.size(); i++) {
      Point p = set.get(i);
      double distance = distance(A, B, p);
      if (distance > dist) {
        dist = distance;
        furthestPoint = i;
      }
    }

    Point P = set.get(furthestPoint);
    set.remove(furthestPoint);
    hull.add(insertPosition, P);

    List<Point> leftSetAP = new ArrayList<>();
    for (int i = 0; i < set.size(); i++) {
      Point M = set.get(i);
      if (pointLocation(A, P, M) == 1) {
        leftSetAP.add(M);
      }
    }

    List<Point> leftSetPB = new ArrayList<>();
    for (int i = 0; i < set.size(); i++) {
      Point M = set.get(i);
      if (pointLocation(P, B, M) == 1) {
        leftSetPB.add(M);
      }
    }

    hullSet(A, P, leftSetAP, hull);
    hullSet(P, B, leftSetPB, hull);
  }

  private double distance(Point A, Point B, Point C) {
    double ABx = B.x - A.x;
    double ABy = B.y - A.y;
    double num = ABx * (A.y - C.y) - ABy * (A.x - C.x);
    if (num < 0)
      num = -num;
    return num;
  }

  private int pointLocation(Point A, Point B, Point P) {
    double cp1 = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);
    return (cp1 > 0) ? 1 : -1;
  }
}
