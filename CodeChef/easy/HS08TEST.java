package easy;
import java.util.Scanner;

/**
 * Created by Diego on 4/11/15.
 */
class HS08TEST {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt(); // Withdraw
        double y = in.nextDouble(); // Balance
        double cost = 0.5;

        double totalTransaction = x+cost;
        if(y>=totalTransaction &&  x%5 == 0){
            System.out.println(y-totalTransaction);
        }
        else
        {
            System.out.println(y);
        }
    }
}