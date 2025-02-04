/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution, try coding another solution
using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray_53_E {
  public static void main(String[] args) {
    testMaximumSubarray();
  }

  public static int maxSubArray_naive(int[] nums) {

    int max = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        max = Math.max(max, sum);
      }
    }

    return max;
  }

  public static int maxSubArray(int[] nums) {
    int currentSum = nums[0];
    int maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }

  public static void testMaximumSubarray() {
    int[][] testCases = {{-2, 1, -3, 4, -1, 2, 1, -5, 4}, {1}, {5, 4, -1, 7, 8}, {-1}};
    int[] expectedResults = {6, 1, 23, -1};

    for (int i = 0; i < testCases.length; i++) {
      int result = maxSubArray(testCases[i]);
      System.out.println(
          "Test case " + (i + 1) + ": " + (result == expectedResults[i] ? "Passed" : "Failed"));
      System.out.println("Expected: " + expectedResults[i] + ", Got: " + result);
    }
  }
}
