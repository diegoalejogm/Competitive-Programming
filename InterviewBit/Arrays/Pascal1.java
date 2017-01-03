/*
Given numRows, generate the first numRows of Pascal’s triangle.
Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
Example:
Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/

public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	    
	    for(int i = 0; i < a; i++)
	    {
	        ArrayList<Integer> act = new ArrayList<Integer>();
	        for(int j = 0; j < i+1; j++)
	        {
	            if(j==0 || j == i) act.add(1);
	            else
	            {
	                Integer num = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
	                act.add(num);
	            }
	        }
	        ans.add(act);
	    }
	    return ans;
	    
	}
}
