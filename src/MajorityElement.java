class MajorityElement {
	public static void main(String[] args) {
		int[] arr = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
		SolutionM s = new SolutionM();
		System.out.println(s.majorityElement(arr));
	}
}

class SolutionM {
    public int majorityElement(int[] nums) {

        int ele = 0;
        int count = 0;

        for(int i = 0 ; i <nums.length ; i++) {
            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else if (ele == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }
}