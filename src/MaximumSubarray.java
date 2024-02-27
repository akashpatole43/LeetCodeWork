
public class MaximumSubarray {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int output = solution.maxSubArray(arr);
		if (output == 6) {
			System.out.println("Successful");
		} else {
			System.out.println("Failed");
		}

	}
	

}

class Solution {
    public int maxSubArray(int[] nums) {
        int maxV = nums[0];
        int sum = 0;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];

            maxV = Math.max(sum, maxV);
            if(sum < 0) sum = 0;
        }
        return maxV;
    }
}
