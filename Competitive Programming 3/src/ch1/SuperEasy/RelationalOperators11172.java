package ch1.SuperEasy;

import java.util.Scanner;

/**
 * Created by Diego on 5/24/15.
 */
class RelationalOperators11172 {

    public static void main(String[] args) {


        Scanner io = new Scanner(System.in);

        int t = io.nextInt();
        while(t > 0)
        {

            int a = io.nextInt();
            int b = io.nextInt();

            String r = (a > b)? ">" : ((a < b)? "<" : "=");

            System.out.println(r);

            --t;
        }
    }
}
