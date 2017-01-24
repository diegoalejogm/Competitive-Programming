import java.io.*;
import java.util.*;

public class SherlockAndAnagrams{//Solution {

    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int T = sc.nextInt();
      for(int i = 0; i < T ; i++){
        String S = sc.next();
        int sol = UAP(S);
        pw.println(sol);
      }
      pw.close();
    }

    // Unordered Anagrammatic Pairs
    public static int UAP(String s){
      Hashtable<String,Integer> wordcnt = new Hashtable<String,Integer>();

      // O( |s|^3 log|s| )
      for(int i = 0; i < s.length(); i++){
        for(int j = i; j < s.length(); j++){
          String sub = s.substring(i,j+1);
          char[] ar = sub.toCharArray(); Arrays.sort(ar);
          String sorted = String.valueOf(ar);
          if(!wordcnt.containsKey(sorted)){wordcnt.put(sorted,1);}
          else{wordcnt.put(sorted, wordcnt.get(sorted)+1);}
        }
      }

      int UAPcount = 0;
      // O(\s\^2)
      for(String key: wordcnt.keySet()){
        int val = wordcnt.get(key);
        if(val !=1){ UAPcount += ( val*(val-1)/2) ;}
      }
      return UAPcount;
    }
}
