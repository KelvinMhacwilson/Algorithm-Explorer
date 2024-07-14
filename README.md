# Algorithm Explorer

The `Algorithm Explorer` is a console-based Java application designed to allow users to interactively test a variety of classic algorithms. These algorithms include both Divide and Conquer and Greedy algorithms, covering fundamental problems in computer science such as sorting, graph traversal, shortest path, and more.

## Algorithms Implemented

### Divide and Conquer Algorithms

1. **QuickSort**: An efficient sorting algorithm that uses a divide-and-conquer approach to sort an array.
2. **MergeSort**: Another efficient sorting algorithm that divides the array into halves, sorts them, and then merges them back together.
3. **Closest Pair**: Finds the closest pair of points in a set of points in the plane.
4. **Strassen's Matrix Multiplication**: An efficient algorithm for matrix multiplication.
5. **Quickhull**: A method to find the convex hull of a set of points in the plane.

### Greedy Algorithms

1. **Prim's Minimum Spanning Tree (MST)**: Finds the minimum spanning tree for a weighted undirected graph.
2. **Traveling Salesman Problem (TSP)**: Provides an approximate solution for the traveling salesman problem.
3. **Kruskal's MST**: Another method to find the minimum spanning tree for a weighted undirected graph.
4. **Dijkstra's Shortest Path**: Finds the shortest path from a source vertex to all other vertices in a weighted graph.
5. **Huffman Coding**: Constructs a Huffman tree for lossless data compression.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed (version 8 or later)
- An IDE or text editor for Java (optional but recommended)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/KelvinMhacwilson/Algorithm-Explorer.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Algorithm-Explorer
   ```

### Running the Application

1. Compile the Java files:
   ```bash
   javac -d bin src/ui/AlgorithmTester.java
   ```
2. Run the application:
   ```bash
   java -cp bin ui.AlgorithmTester
   ```

### Usage

When you run the application, you will be presented with a menu to select an algorithm to test. Follow the prompts to input the necessary data for each algorithm.

#### Example

If you choose to test QuickSort:

1. Select the QuickSort option by entering `1`.
2. Input an array of integers to sort (comma-separated), e.g., `12,4,23,6,3,1,45,2,7`.
3. The application will display the sorted array.

## Project Structure

- `src/`: Contains all source code files.
  - `ui/`: Contains the `AlgorithmTester` class which provides the user interface.
  - `algorithms/`: Contains sub-packages for different algorithm types (`divide_and_conquer` and `greedy`).
  - `base/`: Contains base interfaces for algorithms.
  - `utils/`: Contains utility classes such as `Graph`, `Matrix`, and `Point`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for details.

## Acknowledgments

Inspired by the need to provide a hands-on learning tool for classic algorithms in computer science.
