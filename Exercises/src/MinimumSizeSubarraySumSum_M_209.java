/*
Given an array of positive integers nums and a positive integer target, return the minimal
length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution,
try coding another solution of which the time complexity is O(n log(n)).
 */
public class MinimumSizeSubarraySumSum_M_209 {
  public static void main(String[] args) {
    int[] nums1 = {2, 3, 1, 2, 4, 3};
    int target1 = 7;
    System.out.println("Test 1: " + minSubArrayLen(target1, nums1)); // Output: 2

    int[] nums2 = {1, 4, 4};
    int target2 = 4;
    System.out.println("Test 2: " + minSubArrayLen(target2, nums2)); // Output: 1

    int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
    int target3 = 11;
    System.out.println("Test 3: " + minSubArrayLen(target3, nums3)); // Output: 0
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int sum = 0;
    int minLength = Integer.MAX_VALUE;
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];
      while (sum >= target) {
        minLength = Math.min(minLength, right - left + 1);
        sum -= nums[left];
        left++;
      }
    }

    return minLength != Integer.MAX_VALUE ? minLength : 0;
  }
}
