import java.util.HashMap;
import java.util.Map;

/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
 */
public class ContiguousArray_M {

//  public int findMaxLength(int[] nums) {
//    int maxLength = 0;
//    int count = 0;
//    Map<Integer, Integer> map = new HashMap<>();
//    map.put(0, -1);
//    for (int i = 0; i < nums.length; i++) {
//      count += nums[i] == 1 ? 1 : -1;
//      if (map.containsKey(count)) {
//        int prevIndex = map.get(count);
//        int length = i - prevIndex;
//        maxLength = Math.max(maxLength, length);
//      } else {
//        map.put(count, i);
//      }
//    }
//    return maxLength;
//  }

  public int findMaxLength(int [] nums) {
    int count = 0;
    int maxLength = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) count += 1;
      else count += -1;
      if (map.containsKey(count)) {
        int prevIndex = map.get(count);
        int length = i - prevIndex;
        maxLength = Math.max(length, maxLength);
      } else {
        map.put(count, i);
      }
    }
    return maxLength;
  }

  public int findMaxLength1(int[] nums) {
    int maxLength = 0;
    int count0;
    int count1;
    int len = nums.length;

    for (int i = 0; i < len; i++) {
      count0 = 0;
      count1 = 0;

      for (int j = i; j < len; j++) {
        if (nums[j] == 0) count0++;
        else count1++;
        if (count0 == count1)
          maxLength = Math.max(maxLength, j - i + 1);
      }
    }

    return maxLength;
  }

  public int findMaxLength2(int[] nums) {

    int maxLength = 0;
    int runningSum = 0;
    Map<Integer, Integer> sumIndices = new HashMap<>();
    sumIndices.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      runningSum += nums[i] == 0 ? -1 : 1;
      if (sumIndices.containsKey(runningSum)) {
        maxLength = Math.max(maxLength, i - sumIndices.get(runningSum));
      } else {
        sumIndices.put(runningSum, i);
      }
    }

    return maxLength;
  }

  public void testing() {
    System.out.println(findMaxLength(new int[] {0, 1}));
    System.out.println(findMaxLength(new int[] {0, 1, 0, 1, 0, 1, 1, 1, 0, 1}));
  }

  public static void main(String[] args) {
    ContiguousArray_M contiguousArray = new ContiguousArray_M();
    contiguousArray.testing();
  }
}
