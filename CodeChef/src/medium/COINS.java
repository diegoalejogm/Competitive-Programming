package medium;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
/**
     * Created by Diego on 4/14/15.
     */
    class COINS {

        static HashMap<Long, Long> table = new HashMap<Long, Long>();

        public static void main(String args[])
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                while(true)
                {

                    String line = in.readLine();
                    long n = Long.parseLong(line);
                    System.out.println(getExchange(n));


                }
            }
            catch (Exception e)
            {

            }
        }

        public static long getExchange(long n)
        {


            if(n <= 4)
            {
                return n;
            }
            else
            {
                Long n2 = (Long)n;
                Long exchange = table.get(n);
                if(exchange == null)
                {
                    exchange = Math.max(n,getExchange(n/2)+getExchange(n/3)+getExchange(n/4));
                    table.put(n2,exchange);
                }

                return exchange;
            }
        }
    }
