package easy;
import java.util.Scanner;

/**
 * Created by Diego on 4/11/15.
 */
class TEST {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        int act;

        while(in.hasNextInt()){

            act = in.nextInt();
            if(act == 42){
                break;
            }
            System.out.println(act);
        }
    }
}