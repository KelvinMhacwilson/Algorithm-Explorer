package ui;

import algorithms.divide_and_conquer.*;
import algorithms.greedy.*;
import utils.Point;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlgorithmTester {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Select an algorithm:");
    System.out.println("1. QuickSort");
    System.out.println("2. MergeSort");
    System.out.println("3. Closest-Pair Problem");
    System.out.println("4. Strassen’s Matrix Multiplication");
    System.out.println("5. Quickhull");
    System.out.println("6. Prim’s MST");
    System.out.println("7. Traveling Salesman Problem");
    System.out.println("8. Kruskal’s MST");
    System.out.println("9. Dijkstra’s Shortest Path");
    System.out.println("10. Huffman Codes");

    int choice = scanner.nextInt();
    switch (choice) {
      case 1:
        QuickSort quickSort = new QuickSort();
        System.out.println("Enter array length:");
        int length1 = scanner.nextInt();
        int[] array1 = new int[length1];
        System.out.println("Enter array elements:");
        for (int i = 0; i < length1; i++) {
          array1[i] = scanner.nextInt();
        }
        quickSort.sort(array1);
        System.out.println("Sorted array: " + Arrays.toString(array1));
        break;
      case 2:
        MergeSort mergeSort = new MergeSort();
        System.out.println("Enter array length:");
        int length2 = scanner.nextInt();
        int[] array2 = new int[length2];
        System.out.println("Enter array elements:");
        for (int i = 0; i < length2; i++) {
          array2[i] = scanner.nextInt();
        }
        mergeSort.sort(array2);
        System.out.println("Sorted array: " + Arrays.toString(array2));
        break;
      case 3:
        ClosestPair closestPair = new ClosestPair();
        System.out.println("Enter number of points:");
        int numPoints = scanner.nextInt();
        Point[] points = new Point[numPoints];
        System.out.println("Enter the points (x y):");
        for (int i = 0; i < numPoints; i++) {
          points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        double distance = closestPair.findClosestPair(points);
        System.out.println("Closest pair distance: " + distance);
        break;
      case 4:
        StrassenMatrixMultiplication strassen = new StrassenMatrixMultiplication();
        System.out.println("Enter the size of the matrices:");
        int size = scanner.nextInt();
        int[][] A = new int[size][size];
        int[][] B = new int[size][size];
        int[][] C = new int[size][size];
        System.out.println("Enter matrix A:");
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            A[i][j] = scanner.nextInt();
          }
        }
        System.out.println("Enter matrix B:");
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            B[i][j] = scanner.nextInt();
          }
        }
        strassen.multiply(A, B, C);
        System.out.println("Result matrix C:");
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            System.out.print(C[i][j] + " ");
          }
          System.out.println();
        }
        break;
      case 5:
        Quickhull quickhull = new Quickhull();
        System.out.println("Enter number of points:");
        int numPoints2 = scanner.nextInt();
        Point[] points2 = new Point[numPoints2];
        System.out.println("Enter the points (x y):");
        for (int i = 0; i < numPoints2; i++) {
          points2[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        List<Point> hull = quickhull.findConvexHull(points2);
        System.out.println("Convex hull points:");
        for (Point p : hull) {
          System.out.println(p);
        }
        break;
      case 6:
        PrimMST primMST = new PrimMST();
        primMST.execute();
        System.out.println("Prim's MST execution time: " + primMST.getExecutionTime() + " nanoseconds");
        break;
      case 7:
        TravelingSalesman tsp = new TravelingSalesman();
        tsp.execute();
        System.out.println("TSP execution time: " + tsp.getExecutionTime() + " nanoseconds");
        break;
      case 8:
        KruskalMST kruskalMST = new KruskalMST();
        kruskalMST.execute();
        System.out.println("Kruskal's MST execution time: " + kruskalMST.getExecutionTime() + " nanoseconds");
        break;
      case 9:
        DijkstraShortestPath dijkstra = new DijkstraShortestPath();
        dijkstra.execute();
        System.out.println("Dijkstra's execution time: " + dijkstra.getExecutionTime() + " nanoseconds");
        break;
      case 10:
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        huffmanCoding.execute();
        System.out.println("Huffman coding execution time: " + huffmanCoding.getExecutionTime() + " nanoseconds");
        break;
      default:
        System.out.println("Invalid choice.");
    }
    scanner.close();
  }
}
