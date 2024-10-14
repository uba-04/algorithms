package org.modules.others;

import java.util.Stack;

public class BalancedBracketsValidator {

  private static final String INVALID_MESSAGE = "NO";
  private static final String VALID_MESSAGE = "YES";

  public static String isBalanced(String s) {
    if(inputIsNotValid(s)) return INVALID_MESSAGE;
    return stringIsBalanced(s) ? VALID_MESSAGE : INVALID_MESSAGE;
  }

  private static boolean inputIsNotValid(String string) {
    return string == null || string.isEmpty() || lengthIsOdd(string);
  }

  private static boolean lengthIsOdd(String string) {
    return string.length() % 2 != 0;
  }

  private static boolean stringIsBalanced(String s) {
    Stack<Character> closingBrackets = new Stack<>();

    for(char c : s.toCharArray()) {
      if(c == '(') {
        closingBrackets.push(')');
      }
      else if(c == '[') {
        closingBrackets.push(']');
      }
      else if(c == '{') {
        closingBrackets.push('}');
      }
      else {
        if(closingBrackets.isEmpty() || c != closingBrackets.pop()) {

          return false;
        }
      }
    }
    return closingBrackets.isEmpty();
  }
}
