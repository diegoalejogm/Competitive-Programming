package ch2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Diego on 8/27/15.
 */
public class NewsPaper11340 {
    public static void main(String args[])
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            while(n-->0)
            {
                double fCost = 0;
                int k = Integer.parseInt(br.readLine());
                double[] cost = new double[100000];
                while(k-->0)
                {
                    String line = br.readLine();
                    char act = line.charAt(0);
                    cost[act] = Integer.parseInt(line.split(" ")[1]);
                }
                int m = Integer.parseInt(br.readLine());
                while(m-->0)
                {
                    String line = br.readLine();
                    for(int i = 0; i < line.length(); i++)
                    {
                        fCost+= cost[line.charAt(i)];
                    }
                }
                System.out.printf("%.2f$\n", (fCost/100) );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
