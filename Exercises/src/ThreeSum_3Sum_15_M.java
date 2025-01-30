import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:
3 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
 */
public class ThreeSum_3Sum_15_M {

  public List<List<Integer>> threeSum_naive(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    nums = Arrays.stream(nums).sorted().toArray();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 1; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        for (int k = j + 1; k < nums.length; k++) {
          if (k > j + 1 && nums[k] == nums[k - 1]) {
            continue;
          }
          if (nums[i] + nums[j] + nums[k] == 0) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          }
        }
      }
    }
    return result;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int len = nums.length;
    int sum;
    for (int i = 0; i < len - 2; i++) {
        if (i > 0 && nums[i] == nums[i-1]) continue;

        int left = i + 1;
        int right = len - 1;

        while (left < right) {
            sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) left++;
            else if (sum > 0) right--;
            else {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left > right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            }
        }
    }

    return result;
  }

  public static void main(String[] args) {
    ThreeSum_3Sum_15_M solution = new ThreeSum_3Sum_15_M();

    // Test cases
    int[] nums1 = {-1, 0, 1, 2, -1, -4};
    System.out.println(solution.threeSum(nums1)); // Expected: [[-1, -1, 2], [-1, 0, 1]]

    int[] nums2 = {0, 1, 1};
    System.out.println(solution.threeSum(nums2)); // Expected: []

    int[] nums3 = {0, 0, 0};
    System.out.println(solution.threeSum(nums3)); // Expected: [[0, 0, 0]]

    int[] nums4 = {1, -1, -1, 0};
    System.out.println(solution.threeSum(nums4)); // Expected: [[0, 0, 0]]
  }
}
