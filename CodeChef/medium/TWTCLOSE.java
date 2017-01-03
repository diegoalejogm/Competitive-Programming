package medium;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
     * Created by Diego on 4/14/15.
     */
    class TWTCLOSE {

        public static void main(String args[])
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {

                String[] first = in.readLine().split(" ");
                int n = Integer.parseInt(first[0]);
                int k = Integer.parseInt(first[1]);

                boolean[] openedTweets = new boolean[n];
                int counter = 0;

                while(k > 0)
                {

                    String line = in.readLine();
                    String[] words = line.split(" ");
                    String action = words[0];

                    if(action.equals("CLICK"))
                    {
                        int tweet = Integer.parseInt(words[1]);
                        int localCount = 0;
                        if(openedTweets[tweet-1])
                        {
                            localCount = -1;
                        }
                        else
                        {
                            localCount = 1;
                        }
                        openedTweets[tweet-1] = !openedTweets[tweet-1];
                        counter+=localCount;
                    }
                    else
                    {
                        Arrays.fill(openedTweets,Boolean.FALSE);
                        counter = 0;
                    }

                    System.out.println(counter);

                    --k;

                }
            }
            catch (Exception e)
            {

            }
        }
    }
