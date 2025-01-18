import java.util.HashMap;
import java.util.Map;

/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement_E {

  public int majorityElement(int[] nums) {
    int majority = nums.length / 2;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      if (map.get(i) > majority) {
        return i;
      }
    }
    return -1;
  }

  //    public int majorityElement(int[] nums) {
  //        int majority = nums.length / 2;
  //
  //        Map<Integer, Integer> majorityMap = new HashMap<>();
  //
  //        for (int i = 0; i < nums.length; i++) {
  //            if (majorityMap.containsKey(nums[i])) {
  //                majorityMap.put(nums[i], majorityMap.get(nums[i]) + 1);
  //            } else {
  //                majorityMap.put(nums[i], 1);
  //            }
  //
  //            if (majorityMap.get(nums[i]) > majority) {
  //                return nums[i];
  //            }
  //        }
  //
  //        return -1;
  //    }

  public void testing() {
    System.out.println(majorityElement(new int[] {3, 2, 3}));
    System.out.println(majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
  }

  public static void main(String[] args) {
    MajorityElement_E majorityElement = new MajorityElement_E();
    majorityElement.testing();
  }
}
