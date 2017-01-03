package ch1.AdHoc.Chess;

import java.util.Scanner;

/**
 * Created by Diego on 6/4/15.
 * NON ACCEPTED
 */
class ChessboardInFEN10284 {


    public static void main(String[] args) {


        Scanner io = new Scanner(System.in);
        int t = 0;
        while(io.hasNextLine())
        {
/*
            if(t>0)
            {
                System.out.print("\n");
            }
*/
            int count = 0;
            int MIN = 2;
            int MAX = 9;

            boolean[][] oc = new boolean[MIN+MAX+1+4][MIN+MAX+1+4]; // Occupied
            char[][] pie = new char[MIN+MAX+1+4][MIN+MAX+1+4]; // Piece
            boolean[][] da= new boolean[MIN+MAX+1+4][MIN+MAX+1+4]; // Danger


            int row = MIN;
            while (row <= MAX)
            {
                int col= MIN;
                while(col <= MAX)
                {
                    char act = io.findInLine(".").charAt(0);
                    if(Character.getNumericValue(act) < 10) // if is #
                    {
                        col = col+Character.getNumericValue(act);
                    }
                    else
                    {
                        oc[row][col] = true;
                        pie[row][col] = act;
                        col++;
                    }

                }
                if(row < MAX) io.findInLine(".").charAt(0); // Skip '/'
                row++;
            }

            for (int i = MIN; i <= MAX; i++) {
                for (int j = MIN; j <= MAX; j++) {
                    if(oc[i][j])
                    {
                        da[i][j] = true;
                        if(pie[i][j] == 'K' || pie[i][j] == 'k')
                        {
                            if(!oc[i+1][j]) da[i+1][j] = true;
                            if(!oc[i-1][j]) da[i-1][j] = true;
                            if(!oc[i][j+1]) da[i][j+1] = true;
                            if(!oc[i][j-1]) da[i][j-1] = true;

                        }

                        else if(pie[i][j] == 'N' || pie[i][j] == 'n')
                        {
                            if (!oc[i+2][j+1]) da[i+2][j+1] = true;
                            if (!oc[i+2][j-1]) da[i+2][j-1] = true;
                            if (!oc[i+1][j+2]) da[i+1][j+2] = true;
                            if (!oc[i-1][j+2]) da[i-1][j+2] = true;

                            if (!oc[i-2][j+1]) da[i-2][j+1] = true;
                            if (!oc[i-2][j-1]) da[i-2][j-1] = true;
                            if (!oc[i+1][j-2]) da[i+1][j-2] = true;
                            if (!oc[i-1][j-2]) da[i-1][j-2] = true;

                        }

                        else if(pie[i][j] == 'P' || pie[i][j] == 'p')
                        {
                            int dir = 0;

                            if( pie[i][j] == 'P' ) dir = -1;
                            else dir = 1;

                            if(!oc[i+dir][j+1]) da[i+dir][j+1] = true;
                            if(!oc[i+dir][j-1]) da[i+dir][j-1] = true;
                        }

                        if (pie[i][j] == 'B' || pie[i][j] == 'b' || pie[i][j] == 'Q' || pie[i][j] == 'q')
                        {
                            boolean eTL = false; int tl;
                            boolean eBL = false; int bl;
                            boolean eTR = false; int tr;
                            boolean eBR = false; int br;

                            for (int k = 1; !eBL || !eTL || !eTR || !eBR; k++) {
                                if(i+k > MAX)
                                {
                                    eBL = true;
                                    eBR = true;
                                }
                                if (i-k < MIN)
                                {
                                    eTL = true;
                                    eTR = true;
                                }
                                if (j+k > MAX)
                                {
                                    eTR = true;
                                    eBR = true;
                                }
                                if(j-k < MIN)
                                {
                                    eBL = true;
                                    eTL = true;
                                }

                                if (!eBR && !oc[i+k][j+k]) da[i+k][j+k] =true;
                                else eBR = true;
                                if (!eBL && !oc[i+k][j-k]) da[i+k][j-k] =true;
                                else eBL = true;
                                if (!eTR && !oc[i-k][j+k]) da[i-k][j+k] =true;
                                else eTR = true;
                                if (!eTL && !oc[i-k][j-k]) da[i-k][j-k] =true;
                                else eTL = true;
                            }
                        }
                        if (pie[i][j] == 'R' ||pie[i][j] == 'r'  || pie[i][j] == 'Q' || pie[i][j] == 'q')
                        {
                            boolean end =false;
                            for (int k = j+1; k <= MAX && !end; k++) {
                                if(!oc[i][k]) da[i][k] = true;
                                else end = true;

                            }
                            end  =false;
                            for (int k = j-1; k >= MIN && !end; k--) {
                                if(!oc[i][k]) da[i][k] = true;
                                else end = true;

                            }
                            end  =false;
                            for (int k = i+1; k <= MAX && !end; k++) {
                                if(!oc[k][j]) da[k][j] = true;
                                else end = true;

                            }
                            end  =false;
                            for (int k = i-1; k >= MIN && !end; k--) {
                                if(!oc[k][j]) da[k][j] = true;
                                else end = true;
                            }
                        }
/*
                        for (int m = MIN; m <= MAX; m++) {
                            for (int n = MIN; n <= MAX; n++) {
                                if(da[m][n]) System.out.print("X");
                                else System.out.print("O");
                            }
                            System.out.print("\n");
                        }
                        System.out.print("\n");
*/
                    }
                }
            }


            for (int i = MIN; i <= MAX; i++) {
                for (int j = MIN; j <= MAX; j++) {
                    if(!da[i][j]) count++;
                }
            }
            io.nextLine();
            System.out.println(count);
            //t++;
        }
    }
}
