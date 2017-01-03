package easy;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Diego on 5/23/15.
 */
class RRJOKE {

    public static void main(String[] args) {

        Scanner io = new Scanner(new InputStreamReader(System.in));

        int i = io.nextInt();
        while(i> 0)
        {
            int x = 0;
            int p = io.nextInt();
            while(p > 0)
            {
                x ^= p;
                io.nextInt();
                io.nextInt();
                p--;
            }
            System.out.println(x);
            i--;
        }
    }
}
