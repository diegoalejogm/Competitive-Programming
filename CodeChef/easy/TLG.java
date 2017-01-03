package easy;

import java.util.Scanner;

/**
 * Created by Diego on 4/11/15.
 */
class TLG {
    public static void main(String args[])
    {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        short winner = 0;
        int lead = 0;
        int p1 = 0;
        int p2 = 0;
        while(n > 0)
        {
            p1 += in.nextInt();
            p2 += in.nextInt();

            if(p1 > p2)
            {
                int currentLead = p1-p2;
                if(lead < currentLead)
                {
                    winner = 1;
                    lead = currentLead;
                }
            }
            else if(p1 < p2)
            {
                int currentLead = p2-p1;
                if(lead < currentLead)
                {
                    winner = 2;
                    lead = currentLead;
                }
            }
            n--;
        }
        System.out.println(winner+" "+lead);
    }
}