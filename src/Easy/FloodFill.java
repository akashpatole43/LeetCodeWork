/*
 * Issue: https://leetcode.com/problems/flood-fill/description/
Youtube: https://www.youtube.com/watch?v=C-2_uSRli8o
	
Description:
	You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. 
	You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

	To perform a flood fill:

	Begin with the starting pixel and change its color to color.
	Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, 
			either horizontally or vertically) and shares the same color as the starting pixel.
	Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches 
	the original color of the starting pixel.
	The process stops when there are no more adjacent pixels of the original color to update.
	Return the modified image after performing the flood fill.
	
	
Explaination:
	1. use Depth first search way t update
	2. see the steps
	3. TC = O(n*4)  n = total element in image(x,y) and for every n we are checking for 4 neighbours
	4. SC = O(n*m)
	
	*/


package Easy;

import java.util.Arrays;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionFloodFill obj = new SolutionFloodFill();
		int[][] arr1 = {
				{1,1,1},
				{1,1,0},
				{1,0,1}};
		System.out.println(Arrays.deepToString(obj.floodFill(arr1, 1, 1, 2)));
		
		int[][] arr2 = {{0,0,0}, {0,0,0}};
		System.out.println(Arrays.deepToString(obj.floodFill(arr2, 0, 0, 0)));

	}

}

class SolutionFloodFill {

    private void dfs(
            int oldColor, 
            int newColor, 
            int[] rowN, 
            int[] colN, 
            int[][] image, 
            int[][] res, 
            int sr, 
            int sc) {
                // update the res image
                res[sr][sc] = newColor;
                // get the image row and col size;
                int n = image.length; //row
                int m = image[0].length; //col
                // we know the each box we have 4 neighbours i.e rowN and colN
                for (int i = 0 ; i < 4 ; i++) {
                    // get new row and col  index
                    int nRow = sr + rowN[i]; // new row
                    int nCol = sc + colN[i]; // new col
                    // get the vaild neighbours and check image with oldcolor and update result with newcolor
                    if ((nRow >= 0 && n > nRow && nCol >= 0 && m > nCol) 
                        && (image[nRow][nCol] == oldColor 
                            && res[nRow][nCol] != newColor)) {
                            //    call our recursive fun to update
                            dfs(
                                oldColor, 
                                newColor, 
                                rowN,
                                colN,
                                image,
                                res,
                                nRow,
                                nCol);
                            }
                }
            }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // get exising colour 
        int oldColour = image[sr][sc];
        // array for row's neighbours combination clockwise
        int[] rowN = {-1, 0, 1, 0};
        // array for coloumn's neighbours combination clockwise
        int[] colN = {0, 1, 0, -1};
        // create a copy of image to update and given as output
        int[][] res = image;
        // create DFS function to update result image
        dfs(
            oldColour, 
            color, 
            rowN, 
            colN, 
            image, 
            res, 
            sr, 
            sc);
        // return result image
        return res;


    }
}
