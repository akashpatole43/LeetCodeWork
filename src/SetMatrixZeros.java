
public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = { {1}, {0} ,{3}};
		matrix = setZeroes(matrix);
		for (int i = 0 ; i < matrix.length ; i ++) {
			for(int j = 0 ; j < matrix[0].length ; j ++) {
				System.out.println(matrix[i][j]);
			}
//			System.out.println("\n");
		}
	}
	
	public static int[][] setZeroes(int[][] matrix) {
        int col0 = 1;
        for(int i = 0; i < matrix.length ; i ++) {
            for(int j = 0 ; j< matrix[0].length ; j++) {
                if (matrix[i][j]==0) {
                    if(j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i =1 ; i < matrix.length ; i++) {
            for(int j=1 ; j <matrix[0].length ; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
        	for(int j = 0 ; j < matrix[0].length ; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for(int i = 0 ; i < matrix.length ; i++) {
                matrix[i][0] = 0;
            }
        }
       return matrix;
    }

}
