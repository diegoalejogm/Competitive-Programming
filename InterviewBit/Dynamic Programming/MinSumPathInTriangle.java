/**
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
* For example, given the following triangle
*
* [
*     [2],
*    [3,4],
*   [6,5,7],
*  [4,1,8,3]
* ]
*
* The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*  Note:
*  Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
**/

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
	    
	    // Return 0 if Array empty or null
	    if(a == null || a.size() == 0) return 0;
	    
	    // DP Matrix (1D)
	    int[] mspt = new int[a.size()];
	    for(int i = a.size()-1; i >= 0 ; i--)
	    {
	        for(int j = 0; j < a.get(i).size(); j++)
	        {
	            int row = a.size() - 1 - i;
	            if(row == 0) mspt[j] = a.get(i).get(j);
	            else
	            {
	                mspt[j] = Math.min(mspt[j], mspt[j+1]) + a.get(i).get(j);
	            }
	        }
	    }
	    return mspt[0];
	}
}