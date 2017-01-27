// Unperfect solution
import java.io.*;
import java.util.*;

public class BearAndSteadyGene{//Solution {

  public static int N=0,i=0,j=0,min=0;
  public static int A=0,C=0,T=0,G=0;

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); String s = sc.next();


    int m = solution(s), n = solution(new StringBuilder(s).reverse().toString());
    System.out.println(Math.min(m,n));
  }

  public static int solution(String s){
    // Count leftovers
    for(int i = 0; i < N; i++){
      switch (s.charAt(i)){
        case 'A': A++; break;
        case 'C': C++; break;
        case 'T': T++; break;
        case 'G': G++; break;
      }
    }
    A-= N/4; C-= N/4; T-=N/4; G-=N/4;
    int min = Integer.MAX_VALUE; i = 0; j = 0;
    boolean isSolution = false;
    while(j < N){
      // Check if valid
      isSolution = A<=0 && C<=0 && T<=0 && G<=0;
      if(isSolution){
        min = Math.min(min, j+1-i);
        if(i == j){increase(s);}
        decrease(s);
      }
      else{
        increase(s);
      }
    }
    return min;
  }

  public static void increase(String s){
    j++;
    if(j==N){return;}
    switch (s.charAt(j)){
      case 'A': A--; break; case 'C': C--; break;
      case 'T': T--; break; case 'G': G--; break;
    }
  }

  public static void decrease(String s){
    if(i==j){return;}
    switch (s.charAt(i)){
      case 'A': A++; break; case 'C': C++; break;
      case 'T': T++; break; case 'G': G++; break;
    }
    i++;
  }
}
