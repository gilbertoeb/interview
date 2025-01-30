import java.util.Locale;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.
 */
public class ValidPalindrome_125_E {
  public boolean isPalindrome(String s) {
    // Method implementation will go here

    s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

    int j = s.length() - 1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    ValidPalindrome_125_E solution = new ValidPalindrome_125_E();

    // Test cases
    System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
    System.out.println(solution.isPalindrome("race a car")); // false
    System.out.println(solution.isPalindrome(" ")); // true
    System.out.println(solution.isPalindrome("anita lava la tina")); // true
    System.out.println(solution.isPalindrome("Hanah")); // true
  }
}
