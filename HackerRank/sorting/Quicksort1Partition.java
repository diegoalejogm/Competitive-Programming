import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); int[] ar = new int[N];
        for(int i = 0; i < N ; i++){ ar[i]=sc.nextInt();}

        int k = 0; //ThreadLocalRandom.current().nextInt(0, N);
        switchAtIndex(ar,k,0); int p = ar[k];

        int l = 0, h = ar.length, i=1;

        while(i<h){
            int val = ar[i];
            if(val<p){switchAtIndex(ar,++l,i++);}
            else if(val>p){switchAtIndex(ar, --h,i);}
        }
        switchAtIndex(ar,0,l);
        printArray(ar);
    }
    public static void switchAtIndex(int[] ar, int i, int j){
        int val = ar[i];ar[i] = ar[j]; ar[j] = val;
    }
    private static void printArray(int[] ar) {
      for(int n: ar){ System.out.print(n+" ");}
      System.out.println("");
   }
}
