package ch2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 * Created by Diego on 8/27/15.
 */
public class JollyJumpers10038 {

    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String line;

            while( (line=br.readLine()) != null)
            {
                boolean jolly = true;
                String[] nums = line.split(" ");
                int n = Integer.parseInt(nums[0]);
                BitSet bs = new BitSet(n);

                if(nums.length>2) {
                    for (int i = 2; i < n + 1 && jolly; i++) {
                        String first = nums[i - 1];
                        String act = nums[i];
                        int dif = Math.abs(Integer.parseInt(first) - Integer.parseInt(act));

                        if (dif == 0) jolly = false;
                        if (dif >= n) jolly = false;
                        if (bs.get(dif)) jolly = false;
                        else bs.set(dif);
                    }
                }
                if(!jolly) System.out.println("Not jolly");
                else System.out.println("Jolly");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}