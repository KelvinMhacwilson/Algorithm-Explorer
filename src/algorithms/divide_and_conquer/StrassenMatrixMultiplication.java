package algorithms.divide_and_conquer;

import utils.Matrix;

public class StrassenMatrixMultiplication {

  public Matrix multiply(Matrix A, Matrix B) {
    if (!isValidInput(A, B)) {
      throw new IllegalArgumentException("Matrices must be of size 2^n x 2^n.");
    }

    int size = A.getRows();
    if (size <= 2) {
      return traditionalMultiply(A, B);
    }

    Matrix[] ASub = A.split(0, size / 2 - 1, 0, size / 2 - 1);
    Matrix[] BSub = B.split(0, size / 2 - 1, 0, size / 2 - 1);

    Matrix S1 = BSub[1].subtract(BSub[3]);
    Matrix S2 = ASub[0].add(ASub[1]);
    Matrix S3 = ASub[2].add(ASub[3]);
    Matrix S4 = BSub[2].subtract(BSub[0]);
    Matrix S5 = ASub[0].add(ASub[3]);
    Matrix S6 = BSub[0].add(BSub[3]);
    Matrix S7 = ASub[1].subtract(ASub[3]);
    Matrix S8 = BSub[2].add(BSub[3]);
    Matrix S9 = ASub[0].subtract(ASub[2]);
    Matrix S10 = BSub[0].add(BSub[1]);

    Matrix P1 = multiply(ASub[0], S1);
    Matrix P2 = multiply(S2, BSub[3]);
    Matrix P3 = multiply(S3, BSub[0]);
    Matrix P4 = multiply(ASub[3], S4);
    Matrix P5 = multiply(S5, S6);
    Matrix P6 = multiply(S7, S8);
    Matrix P7 = multiply(S9, S10);

    Matrix C11 = P5.add(P4).subtract(P2).add(P6);
    Matrix C12 = P1.add(P2);
    Matrix C21 = P3.add(P4);
    Matrix C22 = P5.add(P1).subtract(P3).subtract(P7);

    Matrix result = new Matrix(size);
    result.join(C11, C12, C21, C22);
    return result;
  }

  private boolean isValidInput(Matrix A, Matrix B) {
    int sizeA = A.getRows();
    int sizeB = B.getRows();
    return sizeA == sizeB && (sizeA & (sizeA - 1)) == 0;
  }

  private Matrix traditionalMultiply(Matrix A, Matrix B) {
    int size = A.getRows();
    Matrix C = new Matrix(size);
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int sum = 0;
        for (int k = 0; k < size; k++) {
          sum += A.get(i, k) * B.get(k, j);
        }
        C.set(i, j, sum);
      }
    }
    return C;
  }
}
