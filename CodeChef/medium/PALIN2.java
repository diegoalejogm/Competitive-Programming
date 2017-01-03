package medium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gordon
 */
import java.io.*;
import java.util.*;

class PALIN2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(sc.readLine());

        while(t-- > 0)
        {
            char input[] = sc.readLine().toCharArray();
            int length = input.length;
            int count = 0;

            for(int i = 0; i < input.length; i++)
            {
                if(input[i] == '9')
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
            if(count == length)
            {
                System.out.print(1);
                for(int i = 0; i < length - 1; i++)
                {
                    System.out.print(0);
                }
                System.out.println(1);
                continue;
            }

            boolean isEven = ((length % 2) == 0);
            int mid = length / 2;
            int i = isEven ? mid - 1 : mid;
            int j = mid;

            while(i >= 0 && input[i] == input[j])
            {
                i--;
                j++;
            }

            boolean isDone = false;

            if(i >= 0 && input[i] > input[j])
                isDone = true;

            while(i >= 0)
            {
                input[j] = input[i];
                i--;
                j++;
            }

            if(isDone)
            {
                System.out.println(new String(input));
                continue;
            }

            if(isEven)
            {
                i = mid - 1;
                j = mid;

                while(i >= 0)
                {
                    if(input[i] == '9')
                    {
                        input[i] = input[j] = '0';
                    }
                    else
                    {
                        input[i] = input[j] += 1;
                        break;
                    }
                    i--;
                    j++;
                }
            }
            else
            {
                i = mid - 1;
                j = mid + 1;

                isDone = false;

                if(input[mid] == '9')
                {
                    input[mid] = '0';
                }
                else
                {
                    input[mid] += 1;
                    isDone = true;
                }
                while(i >= 0 && !isDone)
                {

                    if(input[i] == '9')
                    {
                        input[i] = input[j] = '0';
                    }
                    else
                    {
                        input[i] = input[j] += 1;
                        isDone = true;
                        break;
                    }

                    i--;
                    j++;
                }
            }
            System.out.println(new String(input));
        }
    }
}
