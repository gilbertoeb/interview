/*
You are given an integer array height of length n. There are n vertical lines drawn such that the
two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1


Constraints:
n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4
 */
public class ContainerWithMostWater_11_M {
  public static void main(String[] args) {
    // Example test cases
      int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
      int[] height2 = {1, 1};
      int[] height3 = {4, 3, 2, 1, 4};
      int[] height4 = {1, 2, 1};

      System.out.println("Test Case 1: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]");
      System.out.println("Expected Output: 49");
      System.out.println("Actual Output: " + maxArea(height1));
      System.out.println();

      System.out.println("Test Case 2: height = [1, 1]");
      System.out.println("Expected Output: 1");
      System.out.println("Actual Output: " + maxArea(height2));
      System.out.println();

      System.out.println("Test Case 3: height = [4, 3, 2, 1, 4]");
      System.out.println("Expected Output: 16");
      System.out.println("Actual Output: " + maxArea(height3));
      System.out.println();

      System.out.println("Test Case 4: height = [1, 2, 1]");
      System.out.println("Expected Output: 2");
      System.out.println("Actual Output: " + maxArea(height4));
      System.out.println();
  }

  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    int area;
    while (left < right) {
        area = Math.min(height[left], height[right]) * (right - left);
        max = Math.max(max, area);
        if (height[left] < height[right]) left++;
        else right--;
    }
    return max;
  }
}
