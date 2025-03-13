package calculator.com.nghlong3004.server.service;

import java.util.stream.Collectors;
import calculator.com.nghlong3004.server.model.Calculator;

public class ServiceCalculator {
  private Calculator calculator;

  public ServiceCalculator() {
    calculator = new Calculator();
  }

  public String getStackOfText() {
    if (calculator.getStack().isEmpty()) {
      return "";
    }
    return calculator.getStack().stream().collect(Collectors.joining());
  }

  public void clearAll() {
    if (!calculator.getStack().isEmpty()) {
      calculator.getStack().clear();
    }
  }

  public void pop() {
    if (!calculator.getStack().isEmpty()) {
      calculator.getStack().pop();
    }
  }

  public void add(String value) {
    calculator.getStack().add(value);
  }

  public int moveLeft(int pos) {
    int currentPos = 0;
    for (int i = 0; i < calculator.getStack().size(); ++i) {
      currentPos += calculator.getStack().get(i).length();
      if (currentPos == pos) {
        pos -= calculator.getStack().get(i).length();
        break;
      }
    }
    return pos;
  }

  public int moveRight(int pos) {
    int currentPos = 0;
    for (int i = 0; i < calculator.getStack().size(); ++i) {
      if (currentPos == pos) {
        pos += calculator.getStack().get(i).length();
        break;
      }
      currentPos += calculator.getStack().get(i).length();
    }
    return pos;
  }

  public int eraseOfPos(int pos) {
    int currentPos = 0;
    for (int i = 0; i < calculator.getStack().size(); ++i) {
      currentPos += calculator.getStack().get(i).length();
      if (currentPos == pos) {
        pos -= calculator.getStack().get(i).length();
        calculator.getStack().remove(i);
        break;
      }
    }
    return pos;
  }

}
