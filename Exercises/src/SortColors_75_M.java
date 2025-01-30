import java.util.Arrays;

/*
Help me understand the following problem and provide a naive solution and
then move to a more optimized approach:

Given an array nums with n objects colored red, white, or blue, sort them in-place
so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */
public class SortColors_75_M {

  // Naive solution
  public void sortColorsNaive(int[] nums) {
    int zer = 0;
    int one = 0;
    int two = 0;

    for (int n : nums) {
      if (n == 0) zer++;
      else if (n == 1) one++;
      else two++;
    }

    int i = 0;
    while (zer-- > 0) nums[i++] = 0;
    while (one-- > 0) nums[i++] = 1;
    while (two-- > 0) nums[i++] = 2;
  }

  // Optimized solution (Dutch National Flag problem)
  public void sortColorsOptimized(int[] nums) {

    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {
      if (nums[mid] == 0) {
        swap(nums, low, mid);
        low++;
        mid++;
      } else if(nums[mid] == 1){
        mid++;
      } else {
        swap(nums, mid, high);
        high--;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    SortColors_75_M sorter = new SortColors_75_M();

    int[] nums1 = {2, 0, 2, 1, 1, 0};
    sorter.sortColorsNaive(nums1);
    System.out.println("Naive sorted: " + Arrays.toString(nums1));

    int[] nums2 = {2, 0, 2, 1, 1, 0};
    sorter.sortColorsOptimized(nums2);
    System.out.println("Optimized sorted: " + Arrays.toString(nums2));

    int[] nums3 = {2, 0, 1};
    sorter.sortColorsNaive(nums3);
    System.out.println("Naive sorted: " + Arrays.toString(nums3));

    int[] nums4 = {2, 0, 1};
    sorter.sortColorsOptimized(nums4);
    System.out.println("Optimized sorted: " + Arrays.toString(nums4));
  }
}
