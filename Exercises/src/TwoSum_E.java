import java.util.HashMap;
import java.util.Map;

public class TwoSum_E {
  /*
  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

  You may assume that each input would have exactly one solution, and you may not use the same element twice.

  You can return the answer in any order.

  Example 1:

  Input: nums = [2,7,11,15], target = 9
  Output: [0,1]
  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
   */
  public int[] twoSum(int[] nums, int target) {

    //        int sum = 0;
    //        int[] res = new int[2];
    //        for (int i = 0; i < nums.length; i++) {
    //            for (int j = 1; j < nums.length; j++) {
    //                sum = nums[i] + nums[j];
    //                if (sum == target && i != j) {
    //                    res[0] = i;
    //                    res[1] = j;
    //                }
    //            }
    //        }
    //
    //        return res;
    int[] res = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        res[0] = map.get(diff);
        res[1] = i;
        return res;
      }
      map.put(nums[i], i);
    }
    return res;
  }

  public int[] twoSumRevisited(int[] nums, int target) {
    int[] res = new int[2];
    Map<Integer, Integer> pairs = new HashMap<>();
    int diff;
    for (int i = 0; i < nums.length; i++) {
      diff = target - nums[i];
      if (pairs.containsKey(diff)) {
        res[0] = pairs.get(diff);
        res[1] = i;
        return res;
      }
      pairs.put(nums[i], i);
    }

    return res;
  }

  public void testing() {

    int[] testingArray = new int[6];
    testingArray[0] = 2;
    testingArray[1] = 7;
    testingArray[2] = 11;
    testingArray[3] = 15;
    int target = 9;

    TwoSum_E testing = new TwoSum_E();
    int[] result = testing.twoSum(testingArray, target);

    System.out.println("Result: " + result[0] + " " + result[1]);
  }
}
