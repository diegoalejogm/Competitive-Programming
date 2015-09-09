package AdHoc.Others.Easier;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Diego on 6/4/15.
 * NON CORRECT
 */
class SnakesAndLadders11459 {

    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);
        int c = io.nextInt(); // CASES
        while(c-- > 0)
        {
            int pls = io.nextInt(); // PLAYERS
            short[] pp = new short[pls]; // PLAYER POSITIONS
            Arrays.fill(pp, (short)1);
            int sl = io.nextInt(); // SNAKES OR LADDERS
            short[] tato = new short[101]; // TAIL -> TOP
            int di = io.nextInt(); // DIES ROLL

            int cn = 0; // COUNT
            while(cn < sl )
            {
                tato[io.nextShort()] = io.nextShort();
                cn++;
            }

            cn = 0; // COUNT TURNS

            while(cn < di)
            {

                int pl = cn%pls;
                cn++;
                short dr = io.nextShort(); // DIE ROLL

                short np = (short)(pp[pl]+dr);

                if(np >=100)
                {
                    pp[pl] = 100;
                    break; // PLAYER WIN
                }
                else if(tato[np] != 0)
                {
                    pp[pl] = tato[np];
                }

                else
                {
                    pp[pl] = np;
                }

                if(pp[pl] >=100)
                {

                    break; // PLAYER WIN
                }
            }

            while(cn < di)
            {
                io.nextInt();
                cn++;
            }

            for (int i = 0; i < pls; i++) {
                System.out.printf("Position of player %d is %d.\n", i+1, pp[i]);
//                if(i != pls-1 || c != 0) System.out.println();
            }
        }
        io.close();
    }
}
