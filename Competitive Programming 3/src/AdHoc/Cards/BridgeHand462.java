package AdHoc.Cards;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Created by Diego on 6/1/15.
 * ERROR
 */
class BridgeHand462 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> clubIndex = new HashMap<Character, Integer>();
        clubIndex.put('S', 0); clubIndex.put('H', 1); clubIndex.put('D', 2); clubIndex.put('C', 3);
        String ans;

        while(sc.hasNext())
        {
            short[] count = new short[4];
            boolean[] stop = new boolean[4];

            short total = 0;

            String[] cards = sc.nextLine().split(" ");

            for (String card : cards)
            {
                char cardName = card.charAt(0);
                char cardSuit= card.charAt(1);

                if(cardName == 'A') total+=4;
                else if(cardName == 'K') total+=3;
                else if(cardName == 'Q') total+=2;
                else if(cardName == 'J') total+=1;

                count[clubIndex.get(cardSuit)]++;

            }

            for(String card : cards)
            {
                char cardName = card.charAt(0);
                char cardSuit= card.charAt(1);
                short minCards = Short.MAX_VALUE;

                if(cardName =='K') minCards = 2;
                if(cardName =='Q') minCards = 3;
                if(cardName =='J') minCards = 4;

                if(cardName == 'A')
                {
                    stop[clubIndex.get(cardSuit)]=true;
                }

                if(count[clubIndex.get(cardSuit)]>= minCards){
                    stop[clubIndex.get(cardSuit)] = true;
                }
                else if(minCards != Short.MAX_VALUE)
                {
                    total--;
                }
            }

            boolean stopAll = true;
            for (boolean x: stop )
            {
                stopAll = stopAll && x;
            }
            if(total >= 16 && stopAll)
            {
             ans = "BID NO-TRUMP";
            }
            else
            {
                for (short amount : count)
                {
                    total+= (amount == 2)?1:(amount <2)?2:0;
                }

                if(total >=14)
                {
                    char[] suits = {'S', 'H', 'D', 'C'};
                    int max = count[0]; char maxs = 'S';
                    for (char suit: suits)
                    {
                        short act = count[clubIndex.get(suit)];
                        if ( act > max)
                        {
                            max = act;
                            maxs = suit;
                        }
                    }
                    ans = String.format("BID %c", maxs);
                }
                else
                {
                    ans= "PASS";
                }
            }
            System.out.println(ans);
        }
    }
}