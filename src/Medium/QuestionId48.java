package Medium;


/*
 * Brute force solution- time = n2 and space = O(n2)
 * 		travel in each element and place it in new position in answer
 * 		formula = arr(i,j) -> new postion new(j, (arr.[o].length - 1) -i)
 * 		i.e (n-1)-i
 * 
 */
/*
 * Optimal solution - 
 * 		Step 1: Transpose the metrix (meaning first row will become first column and so on)
 * 				formula =  [i][j] = [j][i]
 * 		Step 2: Reverse each row to get the final ans as 90 degree clockwise rotation
 * 				to reverse we will use two pointer approach
 * 
 * 
 * Youtube = https://www.youtube.com/watch?v=Z0R2u6gd3GU
 */
public class QuestionId48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SolutionQuestionId48 {
 private void swapImage(int[][] matrix, int i1, int j1, int i2, int j2) {
     int temp = matrix[i1][j1];
     matrix[i1][j1] = matrix[i2][j2];
     matrix[i2][j2] = temp;
 }

 public void rotate(int[][] matrix) {

     // Step 1: get martix size
     int n = matrix[0].length;

     // Step 2: transpose the matrix i.e [i][j] = [j][i]
     // here we need to travel only the half matrix(only the diagonal part)
     for (int i = 0; i < n-1 ; i++) { // from 1st row to 2nd last row
         for (int j = i+1 ; j < n ; j++) { // from i+1(to trave daigonal) to last column
                 // matrix[j][i] = matrix[i][j];
             swapImage(matrix, j, i, i, j);
         }
     }

     // Step 3; reverse each row
     // to reverse we will use two pointer approach
     for (int i = 0 ; i < n ; i++) {
         // p1 will points to start and p2 points to last
         int p1 = 0, p2 = n-1;
         while (p1 < p2) {
                 // matrix[i][p1] = matrix[i][p2];
             swapImage(matrix, i, p1, i, p2);
             ++p1;
             --p2;
         }
     }
     
 }
}
