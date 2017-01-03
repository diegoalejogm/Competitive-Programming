package ch1.SuperEasy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by Diego on 5/24/15.
 */
class CostCutting11727 {

    public static void main(String[] args) {


        Scanner io = new Scanner(System.in);

        int t = io.nextInt();
        int top = t+1;
        while(t > 0)
        {
            int[] s = new int[4];
            s[1] = io.nextInt();
            s[2] = io.nextInt();
            s[3] = io.nextInt();
            Arrays.sort(s);
            System.out.printf("Case %d: %d\n",top-t, s[2]);
            --t;
        }
    }
}
