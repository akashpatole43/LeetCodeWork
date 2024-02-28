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
		int[] arr5 = new int[] {-2,3,-4};
		int ans5 = solution.maxProduct(arr5);
		if (24 == ans5) {
			System.out.println("Successfull "+ ans5);
		} else {
			System.out.println("Failed " + ans5);
		}
		
	}
}

class Solution01 {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
    	int product = nums[0];
    	int prod;
    	int temp;
    	for (int i = 0; i < nums.length; i++) {
    		
			prod = (max * nums[i]) > nums[i] ? (max * nums[i]) : nums[i];
			if ((min * nums[i]) > prod) prod = (min * nums[i]);
			
			temp = (min * nums[i]) < nums[i] ? (min * nums[i]) : nums[i];
			if ((min * nums[i]) > prod) min = temp;
			min = (min * nums[i]) > prod ? temp : (min * nums[i]);
			
			max = prod;
			product = max > product ? max : product;
		}
    	return product;
    }
}

class Solution02 {
	public int maxProduct(int[] nums) {
		int largestProduct = nums[0];
        int minCurrentProduct = nums[0];
        int maxCurrentProduct = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	int currentProduct = Math.max(maxCurrentProduct * nums[i], nums[i]);
        	
        	if (minCurrentProduct * nums[i] > currentProduct)
        		currentProduct = minCurrentProduct * nums[i];
        	
        	int temp = Math.min(maxCurrentProduct * nums[i], nums[i]);
        	
        	if (minCurrentProduct * nums[i] > temp)
        		minCurrentProduct = temp;
        	else
        		minCurrentProduct = minCurrentProduct * nums[i];
        	
        	maxCurrentProduct = currentProduct;
        	largestProduct = Math.max(maxCurrentProduct, largestProduct);
        }
        
		return largestProduct;
	}
}