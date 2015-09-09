package Easy;

import java.util.Scanner;

/**
 * Created by Diego on 5/24/15.
 */
public class EventPlanning11559 {


    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);


        while(io.hasNext())
        {
            int n = io.nextInt();
            int b = io.nextInt();
            int h = io.nextInt();
            int w = io.nextInt();

            int bestBudget = Integer.MAX_VALUE;
            for (int i = 0; i < h; i++) {
                int p = io.nextInt();
                for (int j = 0; j < w; j++) {
                    int a = io.nextInt();
                    if(a >= n && b >= p*n && bestBudget > p*n)
                    {
                        bestBudget = p*n;
                    }
                }

            }
            System.out.println((bestBudget<Integer.MAX_VALUE)?bestBudget:"stay home");
        }
    }
}
