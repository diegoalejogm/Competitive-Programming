import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        
        long sum = a+b+c+d+e;
        
        long max = sum-findMin(a,b,c,d,e);
        long min = sum+findMin(-a,-b,-c,-d,-e);
        System.out.println(min + " " + max);
    }
    
    public static long findMin(long a,long b,long c,long d,long e){
        
        long min = Math.min(a,b);
        min = Math.min(min,c);
        min = Math.min(min,d);
        min = Math.min(min,e);
        return min;
    }
}


