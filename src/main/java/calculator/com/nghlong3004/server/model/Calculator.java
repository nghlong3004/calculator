package calculator.com.nghlong3004.server.model;

import java.util.Stack;

public class Calculator {
  private Stack<String> stack;
  
  public Calculator() {
    stack = new Stack<String>();
  }
  
  public Stack<String> getStack() {
    return stack;
  }
  
}
