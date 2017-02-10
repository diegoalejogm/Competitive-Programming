import java.io.*;
import java.util.*;

public class InsertionSortPart2{//Solution {

    public static void insertionSortPart2(int[] ar)
    {
        for(int i = 1; i < ar.length;i++){
            int ival = ar[i]; boolean done = false;
            for(int j = i-1; j>=0 && !done ; j--){
                int jval = ar[j];
                if(ival>=jval){ar[j+1]=ival;done=true;}
                else if(ival<jval){ar[j+1]=ar[j];}
            }
            if(!done){ar[0]=ival;}
            printArray(ar);
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
       }
       insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
