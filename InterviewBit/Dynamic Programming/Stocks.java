/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/
public class Solution {
	public int maxProfit(final List<Integer> a) 
	{
	    if(a.size() < 2) return 0;
	    int[] profit = new int[a.size()];
	    
	    for(int i = 1 ; i < a.size(); i++)
	    {
	        profit[i] = profit[i-1];
	        for(int j = 0 ; j < i ; j++)
	        {
	            profit[i] = Math.max(profit[i], profit[j] + (a.get(i) - a.get(j)));
	        }
	    }
	    return profit[a.size()-1];
	}
}

