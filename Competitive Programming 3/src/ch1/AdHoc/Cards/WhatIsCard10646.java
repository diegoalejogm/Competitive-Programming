package ch1.AdHoc.Cards;

import java.util.Scanner;

/**
 * Created by Diego on 6/2/15.
 */
class WhatIsCard10646 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int l = t;
        sc.nextLine();
        while (t-->0)
        {
            String resp;

            String[] cards = sc.nextLine().split(" ");
            short times = 3;

            int total =0;
            int index = 26;
            while (times-- > 0)
            {
                int value = Character.getNumericValue(cards[index].charAt(0));
                if(value >10) value = 10;

                index -= (1 + (10-value));
                total+=value;
            }

            if(total <= index+1)
            {
                resp = cards[total-1];
            }
            else
            {
                resp= cards[26+(total-1-index)];
            }

            System.out.printf("Case %d: %s\n", l-t, resp);

        }

    }
}
