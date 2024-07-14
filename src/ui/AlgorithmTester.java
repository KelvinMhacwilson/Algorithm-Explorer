package ui;

import algorithms.divide_and_conquer.ClosestPair;
import algorithms.divide_and_conquer.MergeSort;
import algorithms.divide_and_conquer.QuickSort;
import algorithms.divide_and_conquer.Quickhull;
import algorithms.divide_and_conquer.StrassenMatrixMultiplication;
import algorithms.greedy.DijkstraShortestPath;
import algorithms.greedy.HuffmanCoding;
import algorithms.greedy.KruskalMST;
import algorithms.greedy.PrimMST;
import algorithms.greedy.TravelingSalesman;
import base.DivideAndConquerAlgorithm;
import base.GreedyAlgorithm;
import utils.Graph;
import utils.Matrix;
import utils.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlgorithmTester {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Select an algorithm to test:");
      System.out.println("1. QuickSort");
      System.out.println("2. MergeSort");
      System.out.println("3. Closest Pair");
      System.out.println("4. Strassen's Matrix Multiplication");
      System.out.println("5. Quickhull");
      System.out.println("6. Prim's Minimum Spanning Tree (MST)");
      System.out.println("7. Traveling Salesman Problem (TSP)");
      System.out.println("8. Kruskal's MST");
      System.out.println("9. Dijkstra's Shortest Path");
      System.out.println("10. Huffman Coding");
      System.out.println("0. Exit");

      int choice = scanner.nextInt();
      scanner.nextLine(); // consume newline

      switch (choice) {
        case 1:
          testQuickSort(scanner);
          break;
        case 2:
          testMergeSort(scanner);
          break;
        case 3:
          testClosestPair(scanner);
          break;
        case 4:
          testStrassenMatrixMultiplication(scanner);
          break;
        case 5:
          testQuickhull(scanner);
          break;
        case 6:
          testPrimMST(scanner);
          break;
        case 7:
          testTravelingSalesman(scanner);
          break;
        case 8:
          testKruskalMST(scanner);
          break;
        case 9:
          testDijkstraShortestPath(scanner);
          break;
        case 10:
          testHuffmanCoding(scanner);
          break;
        case 0:
          System.out.println("Exiting...");
          return;
        default:
          System.out.println("Invalid choice. Please enter a number from the menu.");
      }
      System.out.println();
    }
  }

  private static void testQuickSort(Scanner scanner) {
    System.out.println("Enter an array of integers to sort (comma-separated):");
    int[] array = Arrays.stream(scanner.nextLine().split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
    DivideAndConquerAlgorithm quickSort = () -> {
      QuickSort sorter = new QuickSort();
      sorter.sort(array);
      System.out.println("Sorted array using QuickSort: " + Arrays.toString(array));
    };
    quickSort.execute();
  }

  private static void testMergeSort(Scanner scanner) {
    System.out.println("Enter an array of integers to sort (comma-separated):");
    int[] array = Arrays.stream(scanner.nextLine().split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
    DivideAndConquerAlgorithm mergeSort = () -> {
      MergeSort sorter = new MergeSort();
      sorter.sort(array);
      System.out.println("Sorted array using MergeSort: " + Arrays.toString(array));
    };
    mergeSort.execute();
  }

  private static void testClosestPair(Scanner scanner) {
    System.out.println("Enter points in 2D plane (x1,y1 x2,y2 ...):");
    String[] pointsInput = scanner.nextLine().split(" ");
    List<Point> points = new ArrayList<>();
    for (String point : pointsInput) {
      String[] coordinates = point.split(",");
      points.add(new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
    }
    DivideAndConquerAlgorithm closestPair = () -> {
      ClosestPair closestPairFinder = new ClosestPair();
      double minDistance = closestPairFinder.findClosestPair(points.toArray(new Point[0]));
      System.out.println("Minimum distance between closest pair of points: " + minDistance);
    };
    closestPair.execute();
  }

  private static void testStrassenMatrixMultiplication(Scanner scanner) {
    System.out.println("Enter size of matrices (power of 2):");
    int size = scanner.nextInt();
    scanner.nextLine(); // consume newline

    System.out.println("Enter first matrix (row-wise, comma-separated):");
    int[][] matrixAData = new int[size][size];
    for (int i = 0; i < size; i++) {
      matrixAData[i] = Arrays.stream(scanner.nextLine().split(","))
          .mapToInt(Integer::parseInt)
          .toArray();
    }
    Matrix matrixA = new Matrix(matrixAData);

    System.out.println("Enter second matrix (row-wise, comma-separated):");
    int[][] matrixBData = new int[size][size];
    for (int i = 0; i < size; i++) {
      matrixBData[i] = Arrays.stream(scanner.nextLine().split(","))
          .mapToInt(Integer::parseInt)
          .toArray();
    }
    Matrix matrixB = new Matrix(matrixBData);

    DivideAndConquerAlgorithm strassenMultiplication = () -> {
      StrassenMatrixMultiplication multiplier = new StrassenMatrixMultiplication();
      Matrix result = multiplier.multiply(matrixA, matrixB);
      System.out.println("Result of Strassen's Matrix Multiplication:");
      System.out.println(result);
    };
    strassenMultiplication.execute();
  }

  private static void testQuickhull(Scanner scanner) {
    System.out.println("Enter points in 2D plane (x1,y1 x2,y2 ...):");
    String[] pointsInput = scanner.nextLine().split(" ");
    List<Point> points = new ArrayList<>();
    for (String point : pointsInput) {
      String[] coordinates = point.split(",");
      points.add(new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
    }
    DivideAndConquerAlgorithm quickhull = () -> {
      Quickhull quickhullAlgorithm = new Quickhull();
      System.out.println("Convex Hull points:");
      System.out.println(quickhullAlgorithm.findConvexHull(points.toArray(new Point[0])));
    };
    quickhull.execute();
  }

  private static void testPrimMST(Scanner scanner) {
    System.out.println("Enter number of vertices:");
    int vertices = scanner.nextInt();
    System.out.println("Enter number of edges:");
    int edges = scanner.nextInt();
    Graph graph = new Graph(vertices);
    System.out.println("Enter the edges (format: start end weight):");
    for (int i = 0; i < edges; i++) {
      int start = scanner.nextInt();
      int end = scanner.nextInt();
      int weight = scanner.nextInt();
      graph.addEdge(start, end, weight);
    }

    GreedyAlgorithm primMST = () -> {
      PrimMST primAlgorithm = new PrimMST();
      System.out.println("Edges in the Minimum Spanning Tree (Prim's MST):");
      System.out.println(primAlgorithm.findMST(graph));
    };
    primMST.execute();
  }

  private static void testTravelingSalesman(Scanner scanner) {
    System.out.println("Enter number of cities:");
    int cities = scanner.nextInt();
    scanner.nextLine(); // consume newline
    int[][] distances = new int[cities][cities];
    System.out.println("Enter the distance matrix (row-wise, comma-separated):");
    for (int i = 0; i < cities; i++) {
      distances[i] = Arrays.stream(scanner.nextLine().split(","))
          .mapToInt(Integer::parseInt)
          .toArray();
    }

    GreedyAlgorithm travelingSalesman = () -> {
      TravelingSalesman tspAlgorithm = new TravelingSalesman();
      int[] path = tspAlgorithm.findApproximateSolution(distances);
      System.out.println("Approximate solution for Traveling Salesman Problem:");
      System.out.println(Arrays.toString(path));
    };
    travelingSalesman.execute();
  }

  private static void testKruskalMST(Scanner scanner) {
    System.out.println("Enter number of vertices:");
    int vertices = scanner.nextInt();
    System.out.println("Enter number of edges:");
    int edges = scanner.nextInt();
    Graph graph = new Graph(vertices);
    System.out.println("Enter the edges (format: start end weight):");
    for (int i = 0; i < edges; i++) {
      int start = scanner.nextInt();
      int end = scanner.nextInt();
      int weight = scanner.nextInt();
      graph.addEdge(start, end, weight);
    }

    GreedyAlgorithm kruskalMST = () -> {
      KruskalMST kruskalAlgorithm = new KruskalMST();
      System.out.println("Edges in the Minimum Spanning Tree (Kruskal's MST):");
      System.out.println(kruskalAlgorithm.findMST(graph));
    };
    kruskalMST.execute();
  }

  private static void testDijkstraShortestPath(Scanner scanner) {
    System.out.println("Enter number of vertices:");
    int vertices = scanner.nextInt();
    System.out.println("Enter number of edges:");
    int edges = scanner.nextInt();
    Graph graph = new Graph(vertices);
    System.out.println("Enter the edges (format: start end weight):");
    for (int i = 0; i < edges; i++) {
      int start = scanner.nextInt();
      int end = scanner.nextInt();
      int weight = scanner.nextInt();
      graph.addEdge(start, end, weight);
    }

    System.out.println("Enter the source vertex:");
    int source = scanner.nextInt();

    GreedyAlgorithm dijkstraShortestPath = () -> {
      DijkstraShortestPath dijkstraAlgorithm = new DijkstraShortestPath();
      int[] shortestPaths = dijkstraAlgorithm.shortestPath(graph, source);
      System.out.println("Shortest paths from source using Dijkstra's algorithm:");
      for (int i = 0; i < shortestPaths.length; i++) {
        System.out.println("Vertex " + i + ": " + shortestPaths[i]);
      }
    };
    dijkstraShortestPath.execute();
  }

  private static void testHuffmanCoding(Scanner scanner) {
    System.out.println("Enter a string to encode:");
    String input = scanner.nextLine();
    GreedyAlgorithm huffmanCoding = () -> {
      Map<Character, Integer> frequencies = calculateFrequencies(input);
      HuffmanCoding huffmanAlgorithm = new HuffmanCoding();
      Map<Character, String> huffmanCodes = huffmanAlgorithm.buildHuffmanTree(frequencies);
      System.out.println("Huffman Codes:");
      for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
      }
    };
    huffmanCoding.execute();
  }

  private static Map<Character, Integer> calculateFrequencies(String input) {
    Map<Character, Integer> frequencies = new HashMap<>();
    for (char c : input.toCharArray()) {
      frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
    }
    return frequencies;
  }
}
