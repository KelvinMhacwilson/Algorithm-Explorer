# Data Structures and Algorithms 1 - Assignment 5

## Project Description
This project implements and compares Divide and Conquer algorithms and Greedy algorithms in Java. The application uses Object-Oriented Programming (OOP) concepts and provides a console-based interface for users to select and test these algorithms.

## Algorithms Implemented
### Divide and Conquer Algorithms
- QuickSort: Sort a given array of integers.
- MergeSort: Sort a given array of integers.
- Closest-Pair Problem: Find the closest pair of points in a 2D plane.
- Strassen’s Matrix Multiplication: Multiply two matrices efficiently.
- Quickhull: Find the convex hull of a set of points in 2D.

### Greedy Algorithms
- Prim’s Minimum Spanning Tree (MST): Find the minimum spanning tree of a graph.
- Traveling Salesman Problem (TSP): Find an approximate solution for the TSP.
- Kruskal’s MST: Find the minimum spanning tree of a graph using Kruskal's algorithm.
- Dijkstra’s Shortest Path: Find the shortest path from a source node to all other nodes in a graph.
- Huffman Codes: Construct a Huffman tree and generate Huffman codes for given frequencies.

## How to Compile and Run
1. Navigate to the `src` directory.
2. Compile the Java files using the following command:
   ```bash
   javac -d ../bin algorithms/divide_and_conquer/*.java algorithms/greedy/*.java interface/AlgorithmTester.java utils/*.java
