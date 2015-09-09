package AdHoc.Palindromes;

import java.util.Scanner;

/**
 * Created by Diego on 6/5/15.
 */
class MagicSquare11221 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int i = in.nextInt();
        int cnt = 0;
        in.nextLine();
        while(cnt++ < i)
        {
            String str = in.nextLine().replaceAll("[^a-z]", "");
            int len = str.length();
            int ans = -1;
            if(len == 1)
            {
                ans = 1;
            }
            else
            {
                int sqln = (int)Math.sqrt(str.length());
                if(sqln*sqln == len)
                {
                    char[] strChar = str.toCharArray();
                    char[][] table = new char[sqln][sqln];
                    for (int j = 0; j < sqln; j++) {
                        for (int k = 0; k < sqln; k++) {
                            table[j][k] = strChar[j*sqln+k];
                        }
                    }

                    boolean magic = true;
                    int max = sqln-1;
                    for (int j = 0; j < sqln && magic; j++) {
                        for (int k = 0; k < sqln && magic; k++) {

                            if(table[j][k] != table[k][j] ||
                               table[k][j] != table[max-j][max-k] ||
                               table[max-j][max-k] != table[max-k][max-j] )
                            {
                                magic = false;
                            }
                        }
                    }
                    if(magic) ans=sqln;
                }
            }
            System.out.printf("Case #%d:\n", cnt);
            if(ans != -1)
            {
                System.out.println(ans);
            }
            else
            {
                System.out.println("No magic :(");
            }
        }
    }
}
