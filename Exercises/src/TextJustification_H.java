import java.util.ArrayList;
import java.util.List;

/*
Given an array of strings words and a width maxWidth, format the text such that
each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as
you can in each line. Pad extra spaces ' ' when necessary so that each line has
exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the
number of spaces on a line does not divide evenly between words, the empty slots
on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is
inserted between words.

Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.

Example 3:
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

Constraints:
1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
 */

/**
 * Here is a step-by-step explanation for the solution to the text justification problem:
 *
 * <p>Initialize the result list: -Create an empty list res to store the justified lines.
 *
 * <p>Iterate through the words: -Use a while loop to iterate through the words array with an index
 * i.
 *
 * <p>Determine the range of words for the current line:
 *
 * <p>-Initialize j to i + 1 and len to the length of the word at index i.
 *
 * <p>-Use a nested while loop to find the range of words that can fit in the current line without
 * exceeding maxWidth. Update len to include the length of the next word and the spaces between
 * words.
 *
 * <p>Build the current line:
 *
 * <p>-Create a StringBuilder sb to build the current line.
 *
 * <p>-Calculate the number of spaces needed to justify the line:
 *
 * <p>->If it is the last line or the line contains only one word, left-justify the line by
 * appending words followed by a single space and then padding with extra spaces at the end.
 *
 * <p>->Otherwise, distribute the spaces as evenly as possible between the words. Calculate the
 * number of spaces (spaces) and the remainder (r) to distribute extra spaces to the left slots.
 *
 * <p>Add the current line to the result list:
 *
 * <p>-Add the built line to the res list.
 *
 * <p>Update the index i:
 *
 * <p>-Set i to j to process the next range of words.
 *
 * <p>Return the result list:
 *
 * <p>-After processing all words, return the res list containing the justified lines.
 */
public class TextJustification_H {

//    public List<String> fullJustify1(String[] words, int maxWidth) {
//      List<String> res = new ArrayList<>();
//      int i = 0;
//      while (i < words.length) {
//        int j = i + 1;
//        int len = words[i].length();
//        while (j < words.length && len + words[j].length() + j - i <= maxWidth) {
//          len += words[j++].length();
//        }
//        StringBuilder sb = new StringBuilder();
//        int diff = j - i - 1;
//        if (j == words.length || diff == 0) {
//          for (int k = i; k < j; k++) {
//            sb.append(words[k]).append(" ");
//          }
//          sb.deleteCharAt(sb.length() - 1);
//          while (sb.length() < maxWidth) {
//            sb.append(" ");
//          }
//        } else {
//          int spaces = (maxWidth - len) / diff;
//          int r = (maxWidth - len) % diff;
//          for (int k = i; k < j; k++) {
//            sb.append(words[k]);
//            if (k < j - 1) {
//              for (int l = 0; l <= (spaces + ((k - i) < r ? 1 : 0)); l++) {
//                sb.append(" ");
//              }
//            }
//          }
//        }
//        res.add(sb.toString());
//        i = j;
//      }
//      return res;
//    }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList<>();
    List<String> line = new ArrayList<>();
    int length = 0;
    int i = 0;
    int extra_space = 0;
    int spaces = 0;
    int remainderSpaces = 0;
    while (i < words.length) {

      if (length + line.size() + words[i].length() > maxWidth) {
        extra_space = maxWidth - length;
        spaces = extra_space / Math.max(1, line.size() - 1);
        remainderSpaces = extra_space % Math.max(1, line.size() - 1);

        for (int j = 0; j < Math.max(1, line.size() - 1); j++) {
          for (int k = 0; k < spaces; k++) {
            line.set(j, line.get(j) + " ");
          }
          if (remainderSpaces != 0) {
            line.set(j, line.get(j) + " ");
            remainderSpaces--;
          }
        }

        String words1 = String.join("", line);
        res.add(words1);
        line = new ArrayList<>();
        length = 0;
      }

      line.add(words[i]);
      length += words[i].length();
      i += 1;
    }

    StringBuilder lastLine = new StringBuilder();
    for (int j = 0; j < line.size(); j++) {
      lastLine.append(line.get(j));
      if (j != line.size() - 1) {
        lastLine.append(" ");
      }
    }
    while (lastLine.length() < maxWidth) {
      lastLine.append(" ");
    }
    res.add(lastLine.toString());
    return res;
  }

  public void testing() {
    String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
    //    String[] words2 = {"What","must","be","acknowledgment","shall","be"};
    //    String[] words3 =
    // {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
    int maxWidth1 = 16;
    //    int maxWidth2 = 16;
    //    int maxWidth3 = 20;
    System.out.println(fullJustify(words1, maxWidth1));
    System.out.println(fullJustify1(words1, maxWidth1));
    //    System.out.println(fullJustify(words2, maxWidth2));
    //    System.out.println(fullJustify(words3, maxWidth3));
  }

  public static void main(String[] args) {
    TextJustification_H textJustification = new TextJustification_H();
    textJustification.testing();
  }
}
