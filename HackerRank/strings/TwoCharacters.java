import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoCharacters{//Solution {

    private static Vector<Character> chars;
    private static String S;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt(); S = in.next();

        S = removeRepeated(S);
        chars = uniqueChars(S);
        //System.out.println(S);System.out.println(chars);
        int ans = maxT("",chars.size()-2, 0);
        System.out.println(ans);
    }

    public static String removeRepeated(String s){
      while(true){
        boolean repeats = false;
        boolean[] repeated = new boolean[26];
        for(int i = 1; i < s.length(); i++){
          if(s.charAt(i) == s.charAt(i-1)){
            repeated[s.charAt(i)-'a'] = true; repeats = true;
          }
        }
        if(!repeats){ break; }

        StringBuffer regex = new StringBuffer(); regex.append('[');
        for(int i = 0 ; i < repeated.length; i++){
          if(repeated[i]){regex.append( (char)(i+'a') );}
        } regex.append(']');
        s = s.replaceAll(regex.toString(), "");
      }
      return s;
}

    public static Vector<Character> uniqueChars(String s){
      boolean[] exist = new boolean[26]; int total =0;
      Vector<Character> unique = new Vector<Character>();

      for(int i = 0 ; i < s.length() ; i++){
        char c = s.charAt(i); int pos = c-'a';
        if(!exist[pos]){ exist[pos] = true; unique.add(c);}
      }
      return unique;
    }
    // Rem: Remove chars
    public static int maxT(String rem, int remning, int currenti ){

      if(remning == 0) {

        String regex = "["+rem+"]";
        String s = rem.isEmpty() ? S : S.replaceAll(regex,"");
        return countT(s);
      }
      if(currenti >= chars.size()) { return 0; }

      int removing = maxT(rem+chars.get(currenti), remning-1, currenti+1);
      int leaving = maxT(rem,remning,currenti+1);
      return Math.max(removing, leaving);
    }

    public static int countT(String s){
      for(int i = 1 ; i < s.length() ; i++){
        if(s.charAt(i) == s.charAt(i-1)){return 0;}
      }
      return s.length();
    }
}
