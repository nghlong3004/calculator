package calculator.com.nghlong3004.server.controller;

import calculator.com.nghlong3004.server.service.ServiceAlgebra;

public class AlgebraController {
  private ServiceAlgebra algebra;
  public AlgebraController() {
    algebra = new ServiceAlgebra();
  }
  
  public void initMatrix(int n, int m, double[][] matrix) {
    algebra.initMatrix(n, m, matrix);
  }
  
  
}
