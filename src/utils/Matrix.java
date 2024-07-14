package utils;

public class Matrix {
  public static int[][] add(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        C[i][j] = A[i][j] + B[i][j];
      }
    }
    return C;
  }

  public static int[][] subtract(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        C[i][j] = A[i][j] - B[i][j];
      }
    }
    return C;
  }
}
