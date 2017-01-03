package ch1.Medium;

import java.util.Scanner;

/**
 * Created by Diego on 5/25/15.
 * NOT SOLVED
 */
class RequestforProposal10141 {

    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);

        int n = io.nextInt();
        int p = io.nextInt();
        int nRFP = 0;
        while(n > 0 && p > 0)
        {
            nRFP++;

            io.next();

            String opt = "";
            int comp = 0;
            double price = Double.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                io.nextLine();
            }

            while (p > 0)
            {
                String aOpt = io.nextLine();
                double aPrice = io.nextFloat();
                int aComp = io.nextInt();

                if(aComp > comp || (aComp == comp && aPrice < price))
                {
                    comp = aComp;
                    price = aPrice;
                    opt = aOpt;
                }
                io.next();
                for (int i = 0; i < aComp; i++) {
                    io.nextLine();
                }
                p--;
            }

            if (nRFP > 1) System.out.print("\n");
            System.out.printf("RFP #%d\n%s\n",nRFP,opt);
            n = io.nextInt();
            p = io.nextInt();
        }
    }
}
