import java.util.Arrays;

/*
Algorithem
1. find the break point from backward
2. swap the breakpoint value with the its closest larger value from its right side array
3. after swap rearrange the right side array in accesending order i.e reverse the remaing array
*/ 

public class NextPermutation {
	public static void main(String[] args) {
		SolutionNextPermutation s = new SolutionNextPermutation();
		
//		int[] a = {1,2,3};
//		int[] aAns = s.nextPermutation(a);
//		int[] expectedAns = {1, 3, 2};
//		boolean ans = Arrays.equals(aAns, expectedAns);
//		System.out.println(ans == true ? "Pass" : "fail");
//		System.out.println(Arrays.toString(aAns));
//		
//		int[] ab = {3,2,1};
//		int[] abAns = s.nextPermutation(ab);
//		int[] expectedabAns = {1, 2, 3};
//		boolean abns = Arrays.equals(abAns, expectedabAns);
//		System.out.println(abns == true ? "Pass" : "fail");
//		System.out.println(Arrays.toString(abAns));
//		
//		int[] c = {1, 1, 5};
//		int[] cAns = s.nextPermutation(c);
//		int[] cexpectedAns = {1, 5, 1};
//		boolean cans = Arrays.equals(cAns, cexpectedAns);
//		System.out.println(cans == true ? "Pass" : "fail");
//		System.out.println(Arrays.toString(cAns));
		
		int[] d = {1, 3, 2};
		int[] dAns = s.nextPermutation(d);
		int[] dexpectedAns = {2, 1, 3};
		boolean dans = Arrays.equals(dAns, dexpectedAns);
		System.out.println(dans == true ? "Pass" : "fail");
		System.out.println(Arrays.toString(dAns));
	}

}

class SolutionNextPermutation {
	public int[] nextPermutation(int[] nums) {
		int index = -1;
//		1. find the break point from backward
		for (int i = nums.length-2 ; i >= 0 ; i--) {
			if (nums[i] < nums[i+1]) {
				index = i;
				break;
			}
		}
		System.out.println(index);
		if (index == -1) {
			/*
			 * we are on the last permutation i.e the largest value so we need to smallest
			 * permutation value therfore reverse the array
			 */
			return reverseArray(nums, 0, nums.length-1);
		}
		
//		2. swap the breakpoint value with the its closest larger value from its right side array
		for (int i = nums.length-1 ; i > index ; i--) {
			if (nums[i] > nums[index]) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
				break;
			}
		}
		
//		3. after swap rearrange the right side array in accesending order i.e reverse the remaing array
		return reverseArray(nums, index+1, nums.length-1);
    }
	
	private int[] reverseArray(int[] arr, int startIndex, int endIndex) {
		System.out.println(startIndex + " " + endIndex);
		int temp;
		while (startIndex < endIndex) {
			System.out.println(Arrays.toString(arr));
			temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		return arr;
	}

}
