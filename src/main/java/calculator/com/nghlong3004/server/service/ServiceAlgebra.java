package calculator.com.nghlong3004.server.service;

import calculator.com.nghlong3004.server.exceptions.AlgebraException;
import calculator.com.nghlong3004.server.model.Algebra;

public class ServiceAlgebra {
  private Algebra algebra;

  private double[][] matrixAns;

  public ServiceAlgebra() {
    algebra = new Algebra();
  }
  
  public double[][] getMatrixAns() {
    return matrixAns;
  }

  public void initMatrix(int n, int m, double[][] matrix) {
    double newMatrix[][] = new double[n][m];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        newMatrix[i][j] = matrix[i][j];
      }
    }
    insertMatrix(newMatrix);
  }

  public void setMatrixAns(double[][] matrix) {
    for (int i = 0; i < getRow(matrix); ++i) {
      for (int j = 0; j < getColumn(matrix); ++j) {
        matrixAns[i][j] = matrix[i][j];
      }
    }
  }

  public double[][] identity(int n) {
    double[][] matrixI = new double[n][n];
    for (int i = 0; i < n; ++i) {
      matrixI[i][i] = 1;
    }
    return matrixI;
  }

  public double[][] transposition(double[][] matrix) {
    double[][] matrixT = new double[getColumn(matrix)][getRow(matrix)];
    for (int i = 0; i < getRow(matrix); ++i) {
      for (int j = 0; j < getColumn(matrix); ++j) {
        matrixT[j][i] = matrix[i][j];
      }
    }

    return matrixT;
  }

  public void editMatrix(int index, double[][] matrix) {
    algebra.getListMatrix().set(index, matrix);
  }

  public void deleteMatrix(int index) {
    algebra.getListMatrix().remove(index);
  }

  public double[][] inverseMatrix(double[][] matrix) throws AlgebraException {
    double det = 0;
    det = getDet(matrix);
    if (det == 0) {
      throw new AlgebraException("Inverse doesn't exist");
    }
    int n = getRow(matrix);
    double[][] adj = new double[n][n], inv = new double[n][n];
    adjoint(matrix, adj);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        inv[i][j] = (double) adj[i][j] / det;
      }
    }
    return inv;
  }

  public double getDet(double[][] matrix) throws AlgebraException {
    if (getRow(matrix) != getColumn(matrix)) {
      throw new AlgebraException("not square matrix!");
    }
    return determinantOfMatrix(matrix);
  }

  public double[][] getMatrix(int index) throws AlgebraException {
    if (algebra.getListMatrix().size() <= index) {
      throw new AlgebraException("index > size");
    }
    return algebra.getListMatrix().get(index);
  }

  public void insertMatrix(double[][] matrix) {
    algebra.getListMatrix().add(matrix);
  }

  public double[][] subtract(double[][] matrixA, double[][] matrixB) {
    int row = getRow(matrixA);
    int column = getColumn(matrixB);
    double[][] matrix = new double[row][column];
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < column; ++j) {
        matrix[i][j] = matrixA[i][j] - matrixB[i][j];
      }
    }
    return matrix;
  }

  public double[][] add(double[][] matrixA, double[][] matrixB) {
    int row = getRow(matrixA);
    int column = getColumn(matrixB);
    double[][] matrix = new double[row][column];
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < column; ++j) {
        matrix[i][j] = matrixA[i][j] + matrixB[i][j];
      }
    }
    return matrix;
  }

  public double[][] multiply(double[][] matrixA, double[][] matrixB) {
    int row = getRow(matrixA);
    int column = getColumn(matrixB);
    double[][] matrix = new double[row][column];
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < column; ++j) {
        matrix[i][j] = (double) 0;
        for (int k = 0; k < row; ++k) {
          matrix[i][j] += matrixA[i][k] * matrixB[k][j];
        }
      }
    }
    return matrix;
  }

  public double[][] pow(double[][] matrixA, int b) throws AlgebraException {
    int n = getRow(matrixA), m = getColumn(matrixA);
    if (n != m) {
      throw new AlgebraException("not square matrix");
    }
    double[][] matrix = identity(n);
    while (b > 0) {
      if ((b & 1) == 1) {
        matrix = multiply(matrixA, matrix);
      }
      matrixA = multiply(matrixA, matrixA);
      b >>= 1;
    }
    return matrix;
  }

  private int getRow(double[][] matrix) {
    return matrix.length;
  }

  private int getColumn(double[][] matrix) {
    if (matrix == null) {
      return 0;
    }
    return matrix[0].length;
  }

  private void getCofactor(double matrix[][], double[][] newMatrix, int p, int q) {
    for (int row = 0, i = 0; row < getRow(matrix); ++row) {
      if (row != p) {
        for (int column = 0, j = 0; column < getColumn(matrix); ++column) {
          if (column != q) {
            newMatrix[i][j++] = matrix[row][column];
          }
        }
        ++i;
      }
    }
  }

  private double determinantOfMatrix(double[][] matrix) throws AlgebraException {
    int row = getRow(matrix);
    if (row == 1) {
      return matrix[0][0];
    }
    double[][] newMatrix = new double[row - 1][row - 1];
    double Det = 0;
    for (int i = 0, sign = 1; i < row; ++i, sign = -sign) {
      getCofactor(matrix, newMatrix, 0, i);
      Det += sign * matrix[0][i] * getDet(newMatrix);
    }
    return Det;
  }

  private void adjoint(double[][] matrix, double[][] adj) throws AlgebraException {
    int n = getRow(matrix);
    if (n == 1) {
      adj[0][0] = 1;
      return;
    }
    double[][] cof = new double[n - 1][n - 1];
    for (int i = 0, sign = 1; i < n; i++) {
      for (int j = 0; j < n; j++, sign = -sign) {
        getCofactor(matrix, cof, i, j);
        adj[j][i] = sign * getDet(cof);
      }
    }
  }

}
