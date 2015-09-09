package AdHoc.Others.Harder;

import java.util.Scanner;

/**
 * Created by Diego on 6/5/15.
 */
class TraditionalBINGO10813 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // REMAINING GAMES

        while (n-- > 0) {
            boolean[][] card = new boolean[6][6];
            card[3][3] = true; //MIDDLE

            short[] crow = new short[76];
            short[] ccol = new short[76];

            // GET CARD POSITION OF #s
            for (short i = 1; i < 6; i++) {
                for (short j = 1; j < 6; j++) {
                    if (i != 3 || j != 3) {
                        short act = in.nextShort();
                        crow[act] = i;
                        ccol[act] = j;
                    }
                }
            }
            short cnt = 1;
            while (cnt < 76) {
                short num = in.nextShort();

                if (crow[num] != 0)
                {
                    card[crow[num]][ccol[num]] = true;
                    boolean win = checkWin(crow[num], ccol[num], card);
                    if(win) break;
                }
                cnt++;
            }
            int remain = 75-cnt;
            while(remain-- > 0)
            {
                in.nextShort();
            }
            System.out.printf("BINGO after %d numbers announced\n", cnt);
        }
        in.close();
    }

    public static boolean checkWin(short iNum, short jNum , boolean[][] card )
    {
        //CHECK HORIZONTAL

        boolean hor = true;
        boolean ver = true;
        boolean dlt = true;
        boolean dlb = true;

        for (int k = 1; k < 6; k++)
        {
            hor &= card[iNum][k];
            ver &= card[k][jNum];
            //DIAGONALS
            dlt &= card[k][k];
            dlb &= card[6 - k][k];
        }
        return hor || ver || dlt || dlb;
    }
}