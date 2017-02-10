import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); int[] ar = new int[N];
        for(int i = 0; i < N ; i++){ ar[i]=sc.nextInt();}
        quicksort2(ar,0,ar.length);
    }

    private static void quicksort2(int[] ar, int min, int max){
        if(min>=max || min+1==max){return;}
        int p = ar[min];
        Vector<Integer> lower = new Vector<Integer>(), higher=new Vector<Integer>();
        Vector<Integer> equal = new Vector<Integer>();
        for(int i = min; i < max; i++){
            if(ar[i]<p){lower.add(ar[i]);}
            if(ar[i]==p){equal.add(ar[i]);}
            if(ar[i]>p){higher.add(ar[i]);}
        }
        int i = min;
        for(Integer val: lower){ar[i++] = val;}
        for(Integer val: equal){ar[i++] = val;}
        for(Integer val: higher){ar[i++] = val;}

        quicksort2(ar, min, min+lower.size());
        quicksort2(ar,max-higher.size(), max);
        printArray(ar,min,max);

    }

    private static void quicksort(int[] ar, int min, int max){
        if(min>=max || max==min+1){return;}
        int k = min; int p = ar[k];
        int l = min, h = max, i=min+1;
        while(i<h){
            int val = ar[i];
            if(val<p){switchAtIndex(ar,++l,i++);}
            else if(val>p){switchAtIndex(ar, --h,i);}
        }
        switchAtIndex(ar,min,l--);
        quicksort(ar, min, l+1);
        quicksort(ar, h, max);
        printArray(ar,min,max);
    }

    private static void printArray(int[] ar, int min, int max) {
      for(int i=min; i < max; i++){ System.out.print(ar[i]+" ");}
      System.out.println("");
   }
    public static void switchAtIndex(int[] ar, int i, int j){
        int val = ar[i];ar[i] = ar[j]; ar[j] = val;
    }
}
