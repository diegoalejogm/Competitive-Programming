public class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {

        int steps = 0;
//        if(X.size() != Y.size()) throw new Exception("Sizes don't match");
        for(int i = 1 ; i < X.size() ; i++){
            int movX = Math.abs(X.get(i)- X.get(i-1));
            int movY = Math.abs(Y.get(i)- Y.get(i-1));
            steps += Math.max(movX, movY);
        }
        return steps;
    }
}
