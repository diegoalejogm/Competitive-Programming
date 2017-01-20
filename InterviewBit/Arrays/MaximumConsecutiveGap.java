public class Solution {
	// DO NOT MODIFY THE LIST
	public int maximumGap(final List<Integer> a) {

	    if(a.size() < 2) return 0;

	    Collections.sort(a);
	    int maxDiff = 0;
	    for(int i = 1; i < a.size(); i++)
	    {
	        Integer first = a.get(i-1);
	        Integer secnd = a.get(i);
	        Integer diff = Math.abs(first-secnd);
	        if(diff > maxDiff) maxDiff = diff;
	    }
	    return maxDiff;
	}
}
