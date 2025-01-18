import java.util.List;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

Constraints:

1 <= s.length <= 10^64
s consists of only English letters and spaces ' '.
There will be at least one word in s.
 */
public class LengthOfLastWord_E {

  //  public int lengthOfLastWord(String s) {
  //    int length = 0;
  //    for (int i = s.length() - 1; i >= 0; i--) {
  //      if (s.charAt(i) != ' ') {
  //        length++;
  //      } else if (length > 0) {
  //        return length;
  //      }
  //    }
  //    return length;
  //  }

  public int lengthOfLastWord(String s) {
    String[] words = s.split(" ");
    return words[words.length - 1].length();
  }

  public void testing() {
    String s = "Hello World";
    System.out.println(lengthOfLastWord(s));

    s = "   fly me   to   the moon  ";
    System.out.println(lengthOfLastWord(s));

    s = "luffy is still joyboy";
    System.out.println(lengthOfLastWord(s));
  }

  public static void main(String[] args) {
    LengthOfLastWord_E l = new LengthOfLastWord_E();
    l.testing();
  }
}
