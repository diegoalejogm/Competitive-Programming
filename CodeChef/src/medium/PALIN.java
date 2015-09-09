package medium;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
     * Created by Diego on 4/14/15.
     */
    class PALIN {

        public static void main(String args[]) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {

                int k = Integer.parseInt(in.readLine());


                while (k > 0) {

                    int number = Integer.parseInt(in.readLine());
                    System.out.println(getNextPalindrome(number));
                    k--;

                }
            } catch (Exception e) {

                e.printStackTrace();


            }
        }

    public static int getNextPalindrome(int n)
    {
        n++;
        String number = String.valueOf(n);


        if(n < 10)
        {
            return n;
        }

        else {
            int lenght = number.length();

            int left = 0;
            int right = lenght - 1;

            while (left < right) {


                int leftDigit =  ( n / (int) Math.pow(10,lenght-1-left)) % 10;
                int rightDigit = ( n / (int) Math.pow(10,lenght-1-right)) % 10;

                if (leftDigit > rightDigit) {

                    n += (leftDigit-rightDigit)*Math.pow(10,lenght-1-right);
                    left++;
                    right--;

                } else if (leftDigit < rightDigit) {
                    n += Math.pow(10,lenght-right);

                    n -= (rightDigit-leftDigit)*Math.pow(10,lenght-1-right);

                    left = 0;
                    right = lenght-1;
                }
                else
                {
                    left++;
                    right--;
                }
            }
            return n;
        }
    }
}
