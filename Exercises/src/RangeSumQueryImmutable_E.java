/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right
inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

Example 1:
Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

Constraints:
1 <= nums.length <= 10^4
-10^5 <= nums[i] <= 10^5
0 <= left <= right < nums.length
At most 10^4 calls will be made to sumRange.
 */
public class RangeSumQueryImmutable_E {

  private final int[] prefixSums;

  public RangeSumQueryImmutable_E(int[] nums) {
    prefixSums = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      prefixSums[i + 1] = prefixSums[i] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    return prefixSums[right + 1] - prefixSums[left];
  }

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
//    int[] nums = {1, 1, 1, 1, 1, 1};
    RangeSumQueryImmutable_E obj = new RangeSumQueryImmutable_E(nums);
    System.out.println(obj.sumRange(0, 2)); // 1
    System.out.println(obj.sumRange(2, 5)); // -1
    System.out.println(obj.sumRange(0, 5)); // -3
  }
}
