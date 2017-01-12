import java.io.*;
import java.util.*;

public class ReducedString{// Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        String s = sc.nextLine();
        if(s.equals("") || s.length() == 1){ pw.println(s); pw.close(); return;}

        StringBuilder red = new StringBuilder();
        Character current = s.charAt(0); int count = 1;

        for(int i = 1; i < s.length() ; i++)
        {
          Character c = s.charAt(i);
          if(c.equals(current)){ count++; }
          else{
            Character last = null;
            if(red.length()>0) {last = red.charAt(red.length()-1);};
            if(count%2==1){
              if(last == null || last.equals(current)){red.append(current);}
              else{red.deleteCharAt(red.length()-1);}
            }
            count = 1; current = c;
          }

          Character last = null;
          if(red.length()>0) {last = red.charAt(red.length()-1);};
          if(count%2==1){
            if(last == null || last.equals(current)){red.append(current);}
            else{red.deleteCharAt(red.length()-1);}
          }

          pw.println(red.toString());
          pw.close();
        }
    }
}
