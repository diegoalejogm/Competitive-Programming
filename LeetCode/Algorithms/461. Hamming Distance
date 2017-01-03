public class Solution {
    public int hammingDistance(int x, int y) {
        
        int dist = 0;
        int mix = x^y;
        
        while(mix != 0)
        {
            dist+=mix%2;
            mix/=2;
        }
        return dist;
    }
}
