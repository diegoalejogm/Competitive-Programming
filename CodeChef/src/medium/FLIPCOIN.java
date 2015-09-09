package medium;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Diego on 4/17/15.
 */
class FLIPCOIN {

    public static void main(String args[]) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {

            String[] line =in.readLine().split(" ");

            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);


            boolean[] heads = new boolean[n];

            while (k > 0) {

                line = in.readLine().split(" ");
                String action = line[0];
                int begin = Integer.parseInt(line[1]);
                int end = Integer.parseInt(line[2]);
                int cont = 0;
                if(action.equals("0"))
                {
                    for (int i = begin; i <= end; i++) {
                        heads[i] = !heads[i];
                    }
                }
                else if(action.equals("1"))
                {
                    for (int i = begin; i <= end; i++) {
                        cont+= heads[i]?1:0;
                    }
                    System.out.println(cont);
                }
                --k;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
