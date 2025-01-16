import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rowSize = 6;
		List<List<Integer>> ans = getRowData(rowSize);
		printData(ans);

	}
	
	private static List<List<Integer>> getRowData(int rowSize) {
		List<List<Integer>> result = new ArrayList();
        for (int row = 1 ; row <= rowSize ; row++) {
        	Integer ans = 1;
    		List<Integer> rowData = new ArrayList();
        	rowData.add(1);
            for (int col = 1 ; col < row ; col++) {
                ans = ans * (row - col);
                ans = ans / (col);
                rowData.add(ans);
            }
            result.add(rowData);
        }
        return result;
	}
	
	private static void printData(List<List<Integer>> result) {
		result.stream().forEach(n -> System.out.println(n));
	}

}
