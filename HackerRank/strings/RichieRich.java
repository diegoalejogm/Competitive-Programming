import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RichieRich{//Solution {

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();

        int reqChanges = changesToPalindrome(number, n, k);
        if(reqChanges>k) {System.out.println(-1);}
        else{
          int freeChanges = k-reqChanges;
          char[] nums = number.toCharArray();
          for(int i = 0; i < n/2; i++){
            int j = n-(i+1); char left = nums[i], right = nums[j];
            boolean different = left != right;

            if(left < right){nums[i] = right;}
            else if(left > right){nums[j] = left;}

            if(nums[i] != '9' && freeChanges > 0) {
              if( different || (!different && freeChanges>=2) ){
                  nums[i] = '9';nums[j] = '9';
              }
              if(different){freeChanges--;}
              else if(freeChanges>=2){freeChanges-=2;}
            }
          }
          if(n%2==1 && freeChanges>0){nums[n/2]='9';}

          System.out.println(new String(nums));
        }
    }

    public static int changesToPalindrome(String number, int n, int k){
      int countWrong = 0;
      for(int i = 0; i < n/2; i++){
        char left = number.charAt(i), right = number.charAt(n-(1+i));
        if(left != right){ countWrong++; }
      }
      return countWrong;
    }
}
