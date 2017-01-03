/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
*/
public class Solution {
	public int minPathSum(ArrayList<ArrayList<Integer>> a) {
	    
	    if(a.size() == 0) return 0;
	    if(a.get(0).size() == 0) return 0;
	    
	    ArrayList<Integer> steps = (ArrayList<Integer>) a.get(0).clone();
	    
	    for(int i = 0; i < a.size(); i++)
	    {
	        for(int j = 0; j < a.get(i).size(); j++)
	        {
	            Integer currentNum = a.get(i).get(j);
	            if(i == 0 && j == 0) continue;
	            else if(i == 0) steps.set(j, currentNum + steps.get(j-1));
	            else if(j == 0) steps.set(j, currentNum + steps.get(j));
	            else steps.set(j, currentNum + Math.min(steps.get(j-1), steps.get(j)));
	        }
	    }
	    return steps.get(steps.size()-1);
	}
}
