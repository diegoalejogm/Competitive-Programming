package ch3;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Diego on 10/22/16.
 */
public class MaximumSum {

    static int[][] csum;
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();

        int[][] csum = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            for (int j = 0; j < N; j++) {

                csum[i][j] = sc.nextInt();
                if (i > 0) csum[i][j] += csum[i - 1][j];
                if (j > 0) csum[i][j] += csum[i][j - 1];

                if (i > 0 && j > 0) csum[i][j] -= csum[i - 1][j - 1];
            }
        }

        int max = -127*100*100;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = i; k < N ; k++) {
                    for (int l = j; l < N; l++) {

                        int sum = csum[k][l];
                        if(i>0) sum-= csum[i-1][l];
                        if(j>0) sum-= csum[k][j-1];
                        if(i>0 && j>0) sum+=csum[i-1][j-1];

                        if(sum>max) max = sum;
                    }
                }
            }
        }

        pw.println(max);
        pw.close();
    }


}
