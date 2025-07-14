import java.util.Iterator;

/*
Problem - 
	You are given an array prices where prices[i] is the price of a given stock on the ith day.
	You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
	Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Solution -
	Start with day 2, since we will not be buying and selling stocks on the same day,
	then compare day 2 with day 1 and keep the profit track as well as min stock track
*/

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices1 = {7,1,5,3,6,4};
		int expectedOp1 = 5;
//		Solution_BestTimeToBuyAndSellStock obj = new Solution_BestTimeToBuyAndSellStock();
//		int op1 = obj.maxProfit(prices1);
//		boolean ans1 = expectedOp1 == op1 ? true : false;
//		System.out.println(ans1);
//		System.out.println(op1);
		Solution_BestTimeToBuyAndSellStock_sol2 obj = new Solution_BestTimeToBuyAndSellStock_sol2();
		int op1 = obj.maxProfit(prices1);
		boolean ans1 = expectedOp1 == op1 ? true : false;
		System.out.println(ans1);
		System.out.println(op1);

	}

}

//	Solution_2 and this is the best solution
class Solution_BestTimeToBuyAndSellStock_sol2 {
    public int maxProfit(int[] prices) {
    	int min = prices[0];
    	int maxProfit = 0;
    	for(int i = 1; i < prices.length ; i++) {
    		int cost = prices[i] - min;
    		maxProfit = Integer.max(maxProfit, cost);
    		min = Integer.min(min, prices[i]);
    	}
		return maxProfit;
    }
}

//	Solution_1 
class Solution_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int list1 = Integer.MAX_VALUE;
        int var1 = 0;
        int var2 = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < list1){
                list1 = prices[i];
            }
            var2 = prices[i] - list1;
            if(var1 < var2){
                var1 = var2;
            }
        }
        return var1;
    }
}