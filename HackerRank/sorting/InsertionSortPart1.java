import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSortPart1{//Solution {


    public static void insertIntoSorted(int[] ar) {
        int val = ar[ar.length-1];
        boolean done = false;
        for(int i = ar.length-2; i>=0 && !done ; i--){
            int act = ar[i];
            if(val>=act){ar[i+1]=val;done=true;}
            else if(val<act){ ar[i+1]=ar[i];}
            printArray(ar);
        }
            if(!done){ar[0]=val; printArray(ar);}
    }




/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
         }
         insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }


}
