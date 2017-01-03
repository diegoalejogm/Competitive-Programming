package ch1.Medium;

import java.util.Scanner;

/**
 * Created by Diego on 5/25/15.
 */
class TheSnail573 {

    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);
        int h = io.nextInt();
        while(h > 0)
        {
            int u = io.nextInt();
            int d = io.nextInt();
            float f = io.nextFloat()/100;

            int day = 0;

            float initialHeight=0;
            float distanceClimbed = 0;
            float heightAfterClimbing=0;
            float heightAfterSliding = 0;

            while(heightAfterSliding < h)
            {
                initialHeight = heightAfterSliding;

                distanceClimbed= (u - u*(f*day));
                if(distanceClimbed < 0) distanceClimbed=0;
                heightAfterClimbing = initialHeight+distanceClimbed;
                day++;

                if(heightAfterClimbing > h) break;
                heightAfterSliding = heightAfterClimbing-d;
                if(heightAfterSliding < 0) break;
            }
            System.out.print((heightAfterClimbing > h) ? "success" : "failure");
            System.out.printf(" on day %d\n",day);

            h=io.nextInt();
        }
    }
}
