package Easy;

import java.util.Scanner;

/**
 * Created by Diego on 5/24/15.
 * NOT SOLVED YET
 */
public class LoansomeCarBuyer10114 {


    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);

        int duration = io.nextInt();
        while(duration > 0)
        {
            double downPayment = io.nextDouble();
            double loan = io.nextDouble();
            double carValue = downPayment + loan;
            int nDeprecationRecords = io.nextInt();

            int actualMonth = io.nextInt();
            double deprecation = io.nextFloat();
            carValue -= carValue*deprecation;
            actualMonth++;

            int nextMonth=-1;
            double nextDeprecation=-1;

            if(nDeprecationRecords > 1)
            {
                nextMonth = io.nextInt();
                nextDeprecation = io.nextFloat();
                nDeprecationRecords--;
            }

            while(loan > carValue)
            {
                if(nextMonth == actualMonth)
                {
                    deprecation = nextDeprecation;
                    if(nDeprecationRecords > 1)
                    {
                        nextMonth = io.nextInt();
                        nextDeprecation = io.nextFloat();
                        nDeprecationRecords--;
                    }

                }
                carValue-=deprecation*carValue;
                loan-=downPayment;
                actualMonth++;
            }
            System.out.printf("%d month"+((actualMonth>1)?"s\n":"\n"),actualMonth-1);



            duration = io.nextInt();
        }



    }
}
