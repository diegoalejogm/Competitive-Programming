/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
	public ArrayList<Integer> getRow(int a) {
	    
	    
	    Integer[] diag = new Integer[a+1];
	    ArrayList<Integer> resp = new ArrayList<Integer>();
	    
	    for(int i = 0; i < a+1; i++)
	    {
	        for(int j = 0; j < a+1-i; j++)
	        {
	            if(i==0) diag[j]=1;
                else if(j==0) diag[j]=1;
	            else diag[j]+=diag[j-1];
	        }
	        resp.add(diag[a-i]);
	    }
	    return resp;
	}
}
