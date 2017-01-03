/*
Find the longest increasing subsequence of a given sequence / array.

In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.
*/

public class Solution {
	public int lis(final List<Integer> a) {
	    if(a == null || a.size() == 0) return 0;
	    int[] lis = new int[a.size()];
	    Arrays.fill(lis, 1);
	    for(int i = 0; i < a.size(); i++)
	    {
	        for(int j = 0 ; j < i; j++)
	        {
	            if(a.get(i) > a.get(j)) lis[i] = Math.max(lis[i], lis[j]+1);
	        }
	    }
	    
	    int lisN = Integer.MIN_VALUE;
	    for(int i = 0; i < lis.length; i++) if(lisN < lis[i]) lisN = lis[i];
	    
	    
	    return lisN;
	}
}

