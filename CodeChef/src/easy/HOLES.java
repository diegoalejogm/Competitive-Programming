package easy;

import java.util.Scanner;

/**
 * Created by Diego on 4/11/15.
 */
class HOLES {
    public static void main(String args[])
    {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        while(n > 0)
        {
            int holes = 0;
            String currentLine = in.nextLine();
            char[] chars = currentLine.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char charAct = chars[i];
                if(charAct == 'B')
                {
                    holes+=2;
                }
                else if(charAct =='A' || charAct =='D'||charAct =='O'||charAct =='P'||charAct =='Q'||charAct =='R')
                {
                    holes++;
                }
            }
            System.out.println(holes);
            n--;
        }
    }
}