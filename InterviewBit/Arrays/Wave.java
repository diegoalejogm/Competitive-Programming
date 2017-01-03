/* Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.  So, in example case, you will return [2, 1, 4, 3]

*/

 public class Solution {
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    
	    Collections.sort(a);
	    ArrayList<Integer> ans = new ArrayList<Integer>();
	    
	    for(int i = 0; i < a.size(); i+=2)
	    {
	        if(i+1 < a.size())
	        {
	            ans.add(a.get(i+1));
	        }
	        ans.add(a.get(i));
	    }
	    return ans;
	}
}
