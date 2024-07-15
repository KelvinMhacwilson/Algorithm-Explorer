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

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlgorithmTester {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    testQuickSort();
                    break;
                case 2:
                    testMergeSort();
                    break;
                case 3:
                    testClosestPair();
                    break;
                case 4:
                    testStrassenMatrixMultiplication();
                    break;
                case 5:
                    testQuickhull();
                    break;
                case 6:
                    testPrimMST();
                    break;
                case 7:
                    testTravelingSalesman();
                    break;
                case 8:
                    testKruskalMST();
                    break;
                case 9:
                    testDijkstraShortestPath();
                    break;
                case 10:
                    testHuffmanCoding();
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

    private static void showMenu() {
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
    }

    private static int getChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void testQuickSort() {
        try {
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
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter integers separated by commas.");
        }
    }

    private static void testMergeSort() {
        try {
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
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter integers separated by commas.");
        }
    }

    private static void testClosestPair() {
        try {
            System.out.println("Enter points in 2D plane (x1,y1 x2,y2 ...):");
            String[] pointsInput = scanner.nextLine().split(" ");
            List<Point> points = Arrays.asList(pointsInput).stream()
                    .map(point -> {
                        String[] coordinates = point.split(",");
                        return new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                    })
                    .toList();
            DivideAndConquerAlgorithm closestPair = () -> {
                ClosestPair closestPairFinder = new ClosestPair();
                double minDistance = closestPairFinder.findClosestPair(points.toArray(new Point[0]));
                System.out.println("Minimum distance between closest pair of points: " + minDistance);
            };
            closestPair.execute();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format. Please enter points in format 'x1,y1 x2,y2 ...'.");
        }
    }

    private static void testStrassenMatrixMultiplication() {
        try {
            System.out.println("Enter size of matrices (power of 2):");
            int size = Integer.parseInt(scanner.nextLine().trim());
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
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format or matrix size. Please enter valid integers.");
        }
    }

    private static void testQuickhull() {
        try {
            System.out.println("Enter number of points:");
            int numPoints = Integer.parseInt(scanner.nextLine().trim());
            Point[] points = new Point[numPoints];
            System.out.println("Enter the points (x y) one per line:");
            for (int i = 0; i < numPoints; i++) {
                double x = Double.parseDouble(scanner.nextLine().trim());
                double y = Double.parseDouble(scanner.nextLine().trim());
                points[i] = new Point(x, y);
            }

            Quickhull quickhull = new Quickhull();
            Point[] convexHull = quickhull.findConvexHull(points);

            System.out.println("Convex Hull points:");
            for (Point p : convexHull) {
                System.out.println("(" + p.x + ", " + p.y + ")");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format. Please enter valid numbers.");
        }
    }

    private static void testPrimMST() {
        try {
            System.out.println("Enter number of vertices:");
            int vertices = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter the adjacency matrix (row by row, elements space-separated):");
            int[][] graph = new int[vertices][vertices];
            for (int i = 0; i < vertices; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < vertices; j++) {
                    graph[i][j] = Integer.parseInt(row[j]);
                }
            }

            PrimMST primAlgorithm = new PrimMST();
            primAlgorithm.findMST(graph, vertices);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format or matrix size. Please enter valid integers.");
        }
    }

    private static void testTravelingSalesman() {
        try {
            System.out.println("Enter number of cities:");
            int cities = Integer.parseInt(scanner.nextLine().trim());
            int[][] distances = new int[cities][cities];
            System.out.println("Enter the distance matrix (row-wise, comma-separated):");
            for (int i = 0; i < cities; i++) {
                distances[i] = Arrays.stream(scanner.nextLine().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            TravelingSalesman tsp = new TravelingSalesman();
            int[] path = tsp.findApproximateSolution(distances);
            System.out.println("Approximate solution for Traveling Salesman Problem:");
            System.out.println(Arrays.toString(path));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format or matrix size. Please enter valid integers.");
        }
    }

    private static void testKruskalMST() {
        try {
            System.out.println("Enter number of vertices:");
            int vertices = Integer.parseInt(scanner.nextLine().trim());
            Graph graph = new Graph(vertices);

            System.out.println("Enter the edges (format: source destination weight) one per line:");
            while (true) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty())
                    break;
                String[] parts = line.split(" ");
                int source = Integer.parseInt(parts[0]);
                int destination = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);
                graph.addEdge(source, destination, weight);
            }

            KruskalMST kruskal = new KruskalMST();
            List<Graph.Edge> mst = kruskal.findMST(graph);
            System.out.println("Edges in the Minimum Spanning Tree:");
            for (Graph.Edge edge : mst) {
                System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format or graph size. Please enter valid integers.");
        }
    }

    private static void testDijkstraShortestPath() {
        try {
            System.out.println("Enter number of vertices:");
            int vertices = Integer.parseInt(scanner.nextLine().trim());
            Graph graph = new Graph(vertices);

            System.out.println("Enter the edges (format: source destination weight) one per line:");
            while (true) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty())
                    break;
                String[] parts = line.split(" ");
                int source = Integer.parseInt(parts[0]);
                int destination = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);
                graph.addEdge(source, destination, weight);
            }

            System.out.println("Enter the source vertex:");
            int source = Integer.parseInt(scanner.nextLine().trim());

            DijkstraShortestPath dijkstra = new DijkstraShortestPath();
            dijkstra.computeShortestPaths(graph, source);
            System.out.println("Shortest distances from source vertex " + source + ":");

            for (int i = 0; i < vertices; i++) {
                System.out.println("To vertex " + i + ": " + dijkstra.getShortestDistance(i));
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format or graph size. Please enter valid integers.");
        }
    }

    private static void testHuffmanCoding() {
        try {
            System.out.println("Enter a string to encode using Huffman Coding:");
            String input = scanner.nextLine();

            HuffmanCoding huffman = new HuffmanCoding();
            Map<Character, String> huffmanCodes = huffman.compress(input);

            System.out.println("Huffman Codes:");
            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            String encoded = huffman.encode(input);
            System.out.println("Encoded string: " + encoded);

            String decoded = huffman.decode(encoded);
            System.out.println("Decoded string: " + decoded);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format. Please enter valid input.");
        }
    }
}
