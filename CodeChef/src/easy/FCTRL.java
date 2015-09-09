package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Diego on 4/11/15.
 */
class FCTRL {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // Number of lines
        while(n > 0)
        {
            long nextInt = factorial(in.nextInt());
            int counter = 0;
            boolean endInt = false;

            while(!endInt)
            {
                if(nextInt % 10 == 0){
                    counter++;
                    nextInt/=10;
                }
                else
                {
                    endInt = true;
                }
            }
            System.out.println(counter);
            n--;
        }
    }

    public static long factorial(long n)
    {
        long m = n;
        while(m > 1){
            n*=m;
            m--;
        }
        return n;
    }
}