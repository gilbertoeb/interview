import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest
substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters_3_M {
  public int lengthOfLongestSubstring(String s) {
    int maxSubString = 0;
    int left = 0;
    int n = s.length();
    Set<Character> uniqueSubstring = new HashSet<>();

    for (int right = 0; right < n; right++) {
      while (uniqueSubstring.contains(s.charAt(right))) {
        uniqueSubstring.remove(s.charAt(left));
        left++;
      }
      uniqueSubstring.add(s.charAt(right));
      maxSubString = Math.max(maxSubString, uniqueSubstring.size());
    }

    return maxSubString;
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters_3_M solution =
        new LongestSubstringWithoutRepeatingCharacters_3_M();
    test(solution);
  }

  public static void test(LongestSubstringWithoutRepeatingCharacters_3_M solution) {
    String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "", "a", "au"};
    int[] expectedResults = {3, 1, 3, 0, 1, 2};

    for (int i = 0; i < testCases.length; i++) {
      int result = solution.lengthOfLongestSubstring(testCases[i]);
      System.out.println("Test Case " + (i + 1) + ": " + (result == expectedResults[i]));
    }
  }
}
