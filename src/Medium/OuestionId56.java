package Medium;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Title = 56. Merge Intervals
 * 
 * Question = Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * 
 * Solution  = site solution me se liya
 * 
 * Time complexity: O(nlogn) and Space complexity: O(n)
 */
public class OuestionId56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SolutionOuestionId56 {
    public int[][] merge(int[][] intervals) {
        // Step 1:
        // Sort 2d array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Step 2: create resualt List<int[]>
        List<int[]> res = new ArrayList()<>();
        // Step 3: get 0 index array
        int[] prev = intervals[0];

        // Step 4:
        // loop from 1st to last index array
        for (int i = 1; i < intervals.length; i++) {
            // Step 5: get the interval to compare
            int[] interval = intervals[i];
            // Step 6:
            // compare the end of prev and start of interval
            if (prev[1] >= interval[0]) {
                // update the prev's end
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                // add prev in final result list and change the prev with interval
                res.add(prev);
                prev = interval;
            }
        }
        // Step 7:
        // add prev in res list
        res.add(prev);

        // Step 8:
        // return the res list on converting it to array
        return res.toArray(new int[res.size()][]); 
    }
}
