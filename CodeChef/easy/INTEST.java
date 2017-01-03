package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Created by Diego on 4/11/15.
 */
class INTEST {
    public static void main(String args[])
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] arrayNK = br.readLine().split(" ");
            int n = Integer.parseInt(arrayNK[0]); // Number of t values
            int k = Integer.parseInt(arrayNK[1]); // k

            int amountDivisible = 0;

            while (n > 0) {
                int act = Integer.parseInt(br.readLine());
                if (act % k == 0) {
                    amountDivisible++;
                }
                n--;
            }
            System.out.println(amountDivisible);
        }
        catch (Exception e)
        {

        }
    }
}