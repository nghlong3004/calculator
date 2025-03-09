package calculator.com.nghlong3004.server.model;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
  private List<Double> list;

  public Analysis() {
    list = new ArrayList<Double>();
  }

  public List<Double> getList() {
    return list;
  }

  public void setList(List<Double> list) {
    this.list = list;
  }

}
