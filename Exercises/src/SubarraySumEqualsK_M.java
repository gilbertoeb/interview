import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer k, return the total number
of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Constraints:
1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7
 */
public class SubarraySumEqualsK_M {
  //  public int subarraySum(int[] nums, int k) {
  //    int count = 0;
  //    int sum = 0;
  //    Map<Integer, Integer> map = new HashMap<>();
  //    map.put(0, 1);
  //    System.out.println("Initial map: " + map);
  //    System.out.println();
  //
  //    for (int num : nums) {
  //      System.out.println("nums array " + Arrays.toString(nums));
  //      sum += num;
  //      System.out.println("Num: " + num + ", Sum: " + sum);
  //
  //      if (map.containsKey(sum - k)) {
  //        count += map.get(sum - k);
  //        System.out.println("Found (sum - k) in map. Count: " + count);
  //      }
  //
  //      map.put(sum, map.getOrDefault(sum, 0) + 1);
  //      System.out.println("Updated map: " + map);
  //      System.out.println();
  //    }
  //
  //    return count;
  //  }

  public int subarraySum(int[] nums, int k) {
    int count = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public int subarraySum_naive(int[] nums, int k) {
    int sum;
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      sum = 0;

      for (int j = i; j < nums.length; j++) {
        if (sum + nums[j] == k) {
          count++;
        }
        sum += nums[j];
      }
    }

    return count;
  }

  public static void main(String[] args) {
    SubarraySumEqualsK_M obj = new SubarraySumEqualsK_M();
    System.out.println(obj.subarraySum(new int[] {1, 1, 1}, 2)); // 2
    System.out.println(obj.subarraySum(new int[] {1, 2, 0, 3}, 3)); // 4
    //    System.out.println(obj.subarraySum(new int[] {1, 2, 3, 0, 2, 1, 1, 1}, 3)); // 2
  }
}
