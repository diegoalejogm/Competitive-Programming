/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

Warning : DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submissions retroactively and will give you penalty points
*/


 public class Solution {
	public void nextPermutation(ArrayList<Integer> a) {
	    Integer last = a.get(a.size()-1);
	    Integer indexLow = -1;
	    Integer indexHigh = -1;
	    for(int i = a.size()-2; i >=0 && indexLow == -1 ; i-- )
	    {
	        Integer act = a.get(i);
	        if(last <= act) last = act;
	        else indexLow = i;
	        
	        if(indexLow != -1)
	        {
	            boolean end = false;
	            for(int j = indexLow+1 ; j < a.size() && !end; j++)
	            {
	                indexHigh = j;
	                Integer act2 = a.get(j);
	                if(act2 <= a.get(indexLow))
	                {
	                  indexHigh--;
	                  end = true;
	                }
	            }
	            Integer tmp = a.get(indexLow);
	            a.set(indexLow, a.get(indexHigh));
	            a.set(indexHigh, tmp);
	        }
	    }
        int cnt = 0;
        for(int j = indexLow+1; j < indexLow+(a.size()-1-indexLow)/2+1; j++)
        {
	        Integer tmp = a.get(j);
	        a.set(j, a.get(a.size()-1-cnt));
	        a.set(a.size()-1-cnt, tmp);
	        cnt++;
        }	    
	}
}
