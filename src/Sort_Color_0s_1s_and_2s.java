import java.util.Arrays;


/*
Problem- 
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Solution-
Using Dutch  National Algorithem- 
where,
arr[0] .... low-1 = 0,
low .... mid-1 = 1,
mid .... high-1 = unsorted data(0,1,2)
high+1 .... arr[n-1] = 2

i.e with about case we will be able to sort the array
consider above cases we have to play on mid 
i.e. 
if mid == 0 then swap mid with low and then increase mid++ and low++
if mid == 1 then just incerase mid++
if mid == 2 then swap mid with high and then decrease high--
*/

public class Sort_Color_0s_1s_and_2s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_Sort_Color_0s_1s_and_2s obj = new Solution_Sort_Color_0s_1s_and_2s();
		int[] nums1 = {2,0,2,1,1,0};
		obj.sortColors(nums1);
		int[] eNums1 = {0,0,1,1,2,2};
		boolean ans1 = Arrays.equals(nums1, eNums1);
		System.out.println(ans1);
		System.out.println(Arrays.toString(nums1));
		
		int[] nums2 = {2,0,1};
		obj.sortColors(nums2);
		int[] eNums2 = {0,1,2};
		boolean ans2 = Arrays.equals(nums2, eNums2);
		System.out.println(ans2);
		System.out.println(Arrays.toString(nums2));
	}

}

class Solution_Sort_Color_0s_1s_and_2s {
    public void sortColors(int[] nums) {
       int low = 0;
       int mid = 0;
       int high = nums.length-1;
       int temp;
       while(mid <= high) {
        if (nums[mid] == 0) {
            temp = nums[mid];
            nums[mid] = nums[low];
            nums[low] = temp;
            mid++;
            low++;
        } else if (nums[mid] == 1) {
            mid++;
        } else if (nums[mid] == 2) {
            temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;
            high--;
        }
       } 
    }
}
