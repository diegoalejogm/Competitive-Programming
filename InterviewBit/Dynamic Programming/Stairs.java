/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class Solution {
    int[] waysTo;
	public int climbStairs(int a) {
	    waysTo = new int[a+1];
	    Arrays.fill(waysTo, -1);
	    return waysTo(a);
	}
	
	public int waysTo(int n)
	{
	    int total = 0;
	    if(n==0) return 1;
	    if(n<0) return 0;
	    if(waysTo[n] == -1) waysTo[n] = waysTo(n-1) + waysTo(n-2);
	    return waysTo[n];
	}
}

