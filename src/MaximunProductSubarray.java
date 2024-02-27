import java.util.Iterator;

public class MaximunProductSubarray {

	public static void main(String[] args) {
		Solution01 solution = new Solution01();
		int[] arr = new int[] {2,3,-2,4};
		int ans = solution.maxProduct(arr);
		if (6 == ans) {
			System.out.println("Successfull "+ ans);
		} else {
			System.out.println("Failed "+ ans);
		}
		int[] arr1 = new int[] {-2, 0 , -1};
		int ans1 = solution.maxProduct(arr1);
		if (0 == ans1) {
			System.out.println("Successfull "+ ans1);
		} else {
			System.out.println("Failed "+ ans1);
		}
		int[] arr2 = new int[] {-3, -1, -1};
		int ans2 = solution.maxProduct(arr2);
		if (3 == ans2) {
			System.out.println("Successfull "+ ans2);
		} else {
			System.out.println("Failed" + ans2);
		}
		int[] arr3 = new int[] {0, 2};
		int ans3 = solution.maxProduct(arr3);
		if (2 == ans3) {
			System.out.println("Successfull "+ ans3);
		} else {
			System.out.println("Failed " + ans3);
		}
		int[] arr4 = new int[] {3, -1, 4};
		int ans4 = solution.maxProduct(arr4);
		if (4 == ans4) {
			System.out.println("Successfull "+ ans4);
		} else {
			System.out.println("Failed " + ans4);
		}
		
	}
}

class Solution01 {
    public int maxProduct(int[] nums) {
        int prod = 1;
    	int product = nums[0];
    	for (int i = 0; i < nums.length; i++) {
			prod *= nums[i]; // 3
			product = prod > product ? prod : product;
			if ((i+1) < nums.length && nums[i+1] >= 0) {
				if (prod <= 0) {
					prod = 1;
				} 
			} 			
		}
    	return product;
    }
}