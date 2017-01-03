package ch1.SuperEasy;

import java.util.Scanner;

/**
 * Created by Diego on 5/24/15.
 */
class DivisionofNlogonia11498 {

    public static void main(String[] args) {


        Scanner io = new Scanner(System.in);



        while(true)
        {
            int t = io.nextInt();
            if(t == 0)
            {
                break;
            }

            int n = io.nextInt();
            int m = io.nextInt();

            while(t > 0)
            {
                String response = "";

                int x = io.nextInt();
                int y = io.nextInt();

                if(y == m || x ==n)
                {
                    response = "divisa";
                }

                else
                {
                    response += (y>m)? "N": "S";
                    response += (x>n)? "E": "O";
                }

                System.out.println(response);
                t--;
            }
        }
    }
}
