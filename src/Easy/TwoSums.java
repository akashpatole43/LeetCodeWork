/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.*/
package Easy;

public class TwoSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 9;
		int[] arr = new int[] {2,7,11,15};
		int[] expected = new int[] {0,1};
		int actual[] = twoSum(arr, target);
		boolean flag = true;
		for(int j=0 ; j<actual.length ; j++) {
			if(!(actual[j] == expected[j])) {
				flag = false;
				break;
			}
		}
		if (flag)
			System.err.println("Passed");
		else
			System.out.println("Failed");

	}
	
	
    public static int[] twoSum(int[] nums, int target) {
        int k[] = new int[2];
        for (int h=0 ; h<nums.length ; h++) {
            for (int j=h+1 ; j<nums.length ; j++) {
                if (target == nums[h] + nums[j]) {
                    k[0] = h;
                    k[1] = j;
                } 
            }
        }
        return k;
    }
	

}
