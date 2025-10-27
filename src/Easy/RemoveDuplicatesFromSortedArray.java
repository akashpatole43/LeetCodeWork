/*
 * Description:
 * Given an integer array nums sorted in non-decreasing order, 
 * remove the duplicates in-place such that each unique element appears only once. 
 * The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
*/	

package Easy;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionRemoveDuplicatesFromSortedArray obj = new SolutionRemoveDuplicatesFromSortedArray();
		int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
		int ans = 5;
		int result = obj.removeDuplicates(nums1);
		System.out.println(result == ans);

	}

}

class SolutionRemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int s2 = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[s2] != nums[i]) {
                s2++;
                nums[s2] = nums[i];
            }
        }
        return ++s2;
    }
}
