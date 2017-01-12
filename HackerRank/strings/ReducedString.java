import java.io.*;
import java.util.*;

public class ReducedString{// Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        String s = sc.nextLine(), empty = "Empty String";
        if(s.equals("")){pw.println(empty); pw.close(); return;}
        if(s.length() == 1){ pw.println(s); pw.close(); return;}

        StringBuilder red = new StringBuilder();
        Character current = s.charAt(0); long count = 1;

        for(int i = 1; i < s.length() ; i++)
        {
          Character c = s.charAt(i);
          if(c.equals(current)){ count++;}
          else{
            addRemoveChar(red, count, current);
            count = 1; current = c;
          }
        }
        addRemoveChar(red, count, current);

        pw.println(red.length()==0?empty:red.toString()); pw.close();
    }

    public static void addRemoveChar(StringBuilder sb, long count, char current){
      Character last = null;
      if(sb.length()>0) {last = sb.charAt(sb.length()-1);};
      if(count%2==1){
        if(last != null && last.equals(current)){sb.deleteCharAt(sb.length()-1);}
        else{sb.append(current);}
      }
    }
}
