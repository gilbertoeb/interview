import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

-Open brackets must be closed by the same type of brackets.
-Open brackets must be closed in the correct order.
-Every close bracket has a corresponding open bracket of the same type.

Example 1:
    Input: s = "()"
    Output: true
Example 2:
    Input: s = "()[]{}"
    Output: true
Example 3:
    Input: s = "(]"
    Output: false
Example 4:
    Input: s = "([])"
    Output: true

Constraints:

- 1 <= s.length <= 104
- s consists of parentheses only '()[]{}'.
 */
public class ValidParenthesis_E {

  public void testing() {
    System.out.println(isValid1("()"));
    System.out.println(isValid1("()[]{}"));
    System.out.println(isValid1("(]"));
    System.out.println(isValid1("([])"));
    System.out.println(isValid1("()()()"));
  }

  public boolean isValid(String s) {
    // below is the optimal solution as well as the detailed explanation
    // https://leetcode.com/problems/valid-parentheses/solution/

    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else if (stack.isEmpty()
          || c == ')' && stack.pop() != '('
          || c == '}' && stack.pop() != '{'
          || c == ']' && stack.pop() != '[') {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public boolean isValid1(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else if (stack.isEmpty()
          || c == ')' && !stack.pop().equals('(')
          || c == '}' && !stack.pop().equals('{')
          || c == ']' && !stack.pop().equals('[')) {

        return false;
      }
    }
    return stack.isEmpty();
  }
}
