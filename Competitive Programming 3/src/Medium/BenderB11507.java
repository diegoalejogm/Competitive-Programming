package Medium;

import java.util.Scanner;

/**
 * Created by Diego on 6/1/15.
 */
public class BenderB11507 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){


            int l = sc.nextInt();

            if (l==0) break;

            char[] act = {'+','x'};
            while(l > 1)
            {
                char[] next = sc.next().toCharArray();

                if (next[0]!='N')
                {
                    if (act[1] == 'x')
                    {
                        act[1] = next[1];
                        if(act[0]=='+')
                        {
                            act[0] = next[0];
                        }
                        else
                        {
                            act[0] = (next[0]=='+')?'-':'+';
                        }
                    }

                    else if (act[1]==next[1])
                    {
                        act[1] ='x';

                        if(act[0]==next[0])
                        {
                            act[0]= '-';
                        }
                        else
                        {
                            act[0]='+';
                        }
                    }
                }
                l--;
            }
            System.out.printf("%c%c\n", act[0], act[1]);

        }


    }
}
