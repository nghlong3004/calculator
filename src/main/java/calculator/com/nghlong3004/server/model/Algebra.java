package calculator.com.nghlong3004.server.model;

import java.util.ArrayList;
import java.util.List;

public class Algebra {
  private List<double[][]> listMatrix;

  public Algebra() {
    listMatrix = new ArrayList<double[][]>();
  }

  public List<double[][]> getListMatrix() {
    return listMatrix;
  }

  public void setListMatrix(List<double[][]> listMatrix) {
    this.listMatrix = listMatrix;
  }

}
