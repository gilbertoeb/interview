/*
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum
average value and return this value. Any answer with a calculation error less
than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000

Constraints:
n == nums.length
1 <= k <= n <= 10^5
-104 <= nums[i] <= 10^4
 */
public class MaximumAverageSubarray_643_E {
  public static void main(String[] args) {
    testMaximumAverageSubarray();
  }

  public static void testMaximumAverageSubarray() {
    int[] nums1 = {1, 12, -5, -6, 50, 3};
    int k1 = 4;
    System.out.println("Expected: 12.75000, Actual: " + findMaxAverage(nums1, k1));

    int[] nums2 = {5};
    int k2 = 1;
    System.out.println("Expected: 5.00000, Actual: " + findMaxAverage(nums2, k2));
  }

  public static double findMaxAverage(int[] nums, int k) {
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    int maxSum = sum;

    for (int i = k; i < nums.length; i++) {
      sum += nums[i];
      sum -= nums[i - k];
      maxSum = Math.max(sum, maxSum);
    }
    return (double) maxSum / k;
  }

  public static double findMaxAverage_naive(int[] nums, int k) {
    int sum;
    double maxAve = Integer.MIN_VALUE;
    for (int i = 0; i <= nums.length - k; i++) {
      sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += nums[j];
      }
      double average = (double) sum / k;
      maxAve = Math.max(average, maxAve);
    }
    return maxAve;
  }
}
