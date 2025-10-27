package Easy;

public class FindTheIndexOfTheFirstOccuranceInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionFindTheIndexOfTheFirstOccuranceInAString obj = new SolutionFindTheIndexOfTheFirstOccuranceInAString();
		int ans = 0;
		int result = obj.strStr("a", "a");
		System.out.println(ans==result);

	}

}

class SolutionFindTheIndexOfTheFirstOccuranceInAString {
    public int strStr(String haystack, String needle) {

        for (int i = 0, j = needle.length(); j <= haystack.length(); i++, j++) {
            if (needle.equals(haystack.substring(i, j ))) {
                return i;
            }
        }
        return -1;
    }
}
