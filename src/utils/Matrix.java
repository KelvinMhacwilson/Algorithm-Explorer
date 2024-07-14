package utils;

public class Matrix {
  private final int[][] matrix;
  private final int rows;
  private final int cols;

  public Matrix(int[][] matrix) {
    this.matrix = matrix;
    this.rows = matrix.length;
    this.cols = matrix[0].length;
  }

  public Matrix(int size) {
    this.matrix = new int[size][size];
    this.rows = size;
    this.cols = size;
  }

  public int get(int i, int j) {
    return matrix[i][j];
  }

  public void set(int i, int j, int value) {
    matrix[i][j] = value;
  }

  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }

  public Matrix add(Matrix other) {
    if (this.rows != other.getRows() || this.cols != other.getCols()) {
      throw new IllegalArgumentException("Matrices dimensions do not match.");
    }
    int[][] result = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[i][j] = this.matrix[i][j] + other.get(i, j);
      }
    }
    return new Matrix(result);
  }

  public Matrix subtract(Matrix other) {
    if (this.rows != other.getRows() || this.cols != other.getCols()) {
      throw new IllegalArgumentException("Matrices dimensions do not match.");
    }
    int[][] result = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[i][j] = this.matrix[i][j] - other.get(i, j);
      }
    }
    return new Matrix(result);
  }

  public Matrix[] split(int startRow, int endRow, int startCol, int endCol) {
    int newSize = (endRow - startRow + 1) / 2;

    int[][] A11 = new int[newSize][newSize];
    int[][] A12 = new int[newSize][newSize];
    int[][] A21 = new int[newSize][newSize];
    int[][] A22 = new int[newSize][newSize];

    for (int i = 0; i < newSize; i++) {
      for (int j = 0; j < newSize; j++) {
        A11[i][j] = matrix[startRow + i][startCol + j];
        A12[i][j] = matrix[startRow + i][startCol + j + newSize];
        A21[i][j] = matrix[startRow + i + newSize][startCol + j];
        A22[i][j] = matrix[startRow + i + newSize][startCol + j + newSize];
      }
    }

    return new Matrix[] { new Matrix(A11), new Matrix(A12), new Matrix(A21), new Matrix(A22) };
  }

  public void join(Matrix C11, Matrix C12, Matrix C21, Matrix C22) {
    int newSize = C11.getRows();

    for (int i = 0; i < newSize; i++) {
      for (int j = 0; j < newSize; j++) {
        matrix[i][j] = C11.get(i, j);
        matrix[i][j + newSize] = C12.get(i, j);
        matrix[i + newSize][j] = C21.get(i, j);
        matrix[i + newSize][j + newSize] = C22.get(i, j);
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        sb.append(matrix[i][j]).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
