package easy;
import java.util.Scanner;

/**
 * Created by Diego on 4/11/15.
 */
class INTEST_Scanner {
    public static void main(String args[])
    {
        long t1  = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);



        int n = in.nextInt(); // Number of t values
        int k = in.nextInt(); // k

        int amountDivisible = 0;

        while(n > 0)
        {
            int act = in.nextInt();
            if(act % k == 0){
                amountDivisible++;
            }
            n--;
        }
        System.out.println(amountDivisible);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

    }
}