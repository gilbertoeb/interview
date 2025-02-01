/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
1 <= n <= 2 * 10^4
0 <= height[i] <= 10^5
 */
public class TrappingRainWater_H_42 {

  // Skeleton method where the implementation should go
  public int trap(int[] height) {
    int length = height.length;

    int trappedWater = 0;

    int left = 0;
    int right = length - 1;

    int maxLeft = height[left];
    int maxRight = height[right];

    while (left < right) {
      if (maxLeft < maxRight) {
        left++;
        maxLeft = Math.max(maxLeft, height[left]);
        trappedWater += maxLeft - height[left];
      } else {
        right--;
        maxRight = Math.max(maxRight, height[right]);
        trappedWater += maxRight - height[right];
      }
    }

    return trappedWater;
  }

  // Testing method with detailed outputs and comments
  public void testing() {
    int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] height2 = {4, 2, 0, 3, 2, 5};
    int[] height3 = {1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] height4 = {2, 0, 2};

    System.out.println("Test Case 1: height = [0,1,0,2,1,0,1,3,2,1,2,1]");
    System.out.println("Expected Output: 6");
    System.out.println("Actual Output: " + trap(height1));
    System.out.println();

    System.out.println("Test Case 2: height = [4,2,0,3,2,5]");
    System.out.println("Expected Output: 9");
    System.out.println("Actual Output: " + trap(height2));
    System.out.println();

    System.out.println("Test Case 3: height = [1,0,2,1,0,1,3,2,1,2,1]");
    System.out.println("Expected Output: 6");
    System.out.println("Actual Output: " + trap(height3));
    System.out.println();

    System.out.println("Test Case 4: height = [2,0,2]");
    System.out.println("Expected Output: 2");
    System.out.println("Actual Output: " + trap(height4));
    System.out.println();
  }

  // Main method
  public static void main(String[] args) {
    TrappingRainWater_H_42 solution = new TrappingRainWater_H_42();
    solution.testing();
  }
}
