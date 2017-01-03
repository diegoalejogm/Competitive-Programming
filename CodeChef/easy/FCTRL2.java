package easy;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Diego on 5/23/15.
 */
class FCTRL2 {


    public static void main(String[] args) {

        Scanner io = new Scanner(new InputStreamReader(System.in));

        int n = io.nextInt();
        while(n > 0)
        {
            int i = io.nextInt();
            BigInteger number = factorial(i);
            System.out.println(number);
            n--;
        }

    }


    public static BigInteger factorial(int i)
    {
        BigInteger num = new BigInteger("1");
        while(i > 1)
        {
            num = num.multiply(BigInteger.valueOf(i));
            i--;
        }
        return num;



    }
}
