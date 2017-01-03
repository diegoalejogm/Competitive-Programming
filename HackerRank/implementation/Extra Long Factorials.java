import java.io.*;
import java.util.*;
import java.math.BigInteger;


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(factorial(n).toString());
    }
    
    
    public static BigInteger factorial(long n){
        
        BigInteger N = BigInteger.valueOf(n);
        while(--n > 0){
            N = N.multiply(BigInteger.valueOf(n));
        }
        return N;
    }
}
