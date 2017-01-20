public class Solution {
	public int firstMissingPositive(ArrayList<Integer> a) {

    	int n = a.size();
    	for(int i = 0; i < n ; i++){

    		int x = a.get(i);

    		while(x > i+1 && x <= n){
    			int temp = x;
    			a.set(i, a.get(temp-1));
    			a.set(temp-1, temp);
    			x = a.get(i);
    		}
    		if(x == i+1) a.set(i, 1);
    		else if(x<=0 || x > n) a.set(i, 0);
    		else{
    			a.set(x-1, 1);
    			a.set(i,0);
    		}
    	}

    	int firstMissing = 1;
    	for(int i = 0 ; i < n ; i++)
    	{
    		if(a.get(i) == 0) return firstMissing;
    		firstMissing++;
    	}

    	return firstMissing;
	}
}
