/* You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
*/
public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    
	    if(a.size() > 0)
	    {
	        int size = a.size();
	        int m = 0;
	        
	        
	        for(int i = 0; i < size/2; i++)
	        {
	            Integer act = a.get(i).get(i);
	            Integer tmp = a.get(i).get(size-1-i);
	            a.get(i).set(size-1-i, act );
	                
	            act = tmp;
	            tmp = a.get(size-1-i).get(size-1-i);
	            a.get(size-1-i).set(size-1-i, act);
	                
	            act = tmp;
	            tmp = a.get(size-1-i).get(i);
	            a.get(size-1-i).set(i, act);
	                
	            act = tmp;
	            a.get(i).set(i,act);
	        }
	        while(m < size/2)
	        {
	            for(int i = m+1 ; i < size-m-1; i++)
	            {
	                Integer act = a.get(m).get(i);
	                Integer tmp = a.get(i).get(size-1-m);
	                a.get(i).set(size-1-m, act );
	                
	                act = tmp;
	                tmp = a.get(size-1-m).get(size-1-i);
	                a.get(size-1-m).set(size-1-i, act);
	                
	                act = tmp;
	                tmp = a.get(size-1-i).get(m);
	                a.get(size-1-i).set(m, act);
	                
	                act = tmp;
	                a.get(m).set(i,act);
	                
	            }
	            m++;
	        }
	    }
	}
}
