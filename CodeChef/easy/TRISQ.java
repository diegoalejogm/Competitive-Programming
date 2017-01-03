package easy;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Diego on 5/23/15.
 */
class TRISQ {


    public static void main(String[] args) {
        Scanner io = new Scanner(new InputStreamReader(System.in));
        int t = io.nextInt();

        while(t > 0)
        {
            double b = io.nextDouble();

            int highest = (int)b/2;
            int total = 0;
            while(--highest > 0)
            {
                total+=highest;
            }
            t--;

            System.out.println(total);
        }
    }
}
