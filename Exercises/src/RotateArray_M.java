import java.util.Arrays;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^5
 */
public class RotateArray_M {

  public int[] rotateArray(int[] nums, int k) {

    System.out.println(Arrays.toString(nums));
    reverse(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
    reverse(nums, 0, k - 1);
    System.out.println(Arrays.toString(nums));
    reverse(nums, k, nums.length - 1);

    return nums;
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  //  public int[] rotateArray(int[] nums, int k) {
  //    int n = nums.length;
  //    k %= n;
  //    reverse(nums, 0, n - 1);
  //    reverse(nums, 0, k - 1);
  //    reverse(nums, k, n - 1);
  //    return nums;
  //  }
  //
  //  private void reverse(int[] nums, int start, int end) {
  //    while (start < end) {
  //      int temp = nums[start];
  //      nums[start] = nums[end];
  //      nums[end] = temp;
  //      start++;
  //      end--;
  //    }
  //  }

  public void testing() {
//    int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
//    int k1 = 3;
//    rotateArray(nums1, k1);
//    System.out.println(Arrays.toString(nums1));

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotateArray(nums2, k2);
        System.out.println(Arrays.toString(nums2));
  }

  public static void main(String[] args) {
    RotateArray_M rotateArray = new RotateArray_M();
    rotateArray.testing();
  }
}
