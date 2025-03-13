package calculator.com.nghlong3004.server.controller;

import calculator.com.nghlong3004.server.service.ServiceCalculator;

public class CalculatorController {
  private ServiceCalculator calculator;
  
  public CalculatorController() {
    calculator = new ServiceCalculator();
  }
  
  public int eraseOfPos(int pos) {
    return calculator.eraseOfPos(pos);
  }
  
  public int moveLeft(int pos) {
    return calculator.moveLeft(pos);
  }
  public int moveRight(int pos) {
    return calculator.moveRight(pos);
  }
  
  public String getStackOfText() {
    return calculator.getStackOfText();
  }
  
  public void clearAll() {
    calculator.clearAll();
  }
  
  public void pop() {
    calculator.pop();
  }
  
  public void add(String s) {
    calculator.add(s);
  }
  
}
