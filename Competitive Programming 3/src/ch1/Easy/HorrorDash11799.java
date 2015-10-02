package ch1.Easy;

import java.util.Scanner;

/**
 * Created by Diego on 5/24/15.
 */
public class HorrorDash11799 {


    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);
        int t = io.nextInt();
        int top = t+1;
        io.nextLine();
        while (t > 0)
        {

            String[] spds = io.nextLine().split(" ");
            int max = 0;
            for (int i = 0; i < spds.length; i++) {
                int act = Integer.parseInt(spds[i]);
                if(max < act)
                {
                    max = act;
                }
            }
            System.out.printf("Case %d: %d\n", top-t, max);
            t--;
        }
    }
}
