import java.io.*;
import java.util.*;

public class Pairs{//Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>(),
                          subs = new ArrayList<Integer>();
        int N = sc.nextInt(), K = sc.nextInt();
        for(int i = 0; i < N ; i++){ list.add(sc.nextInt());}
        Collections.sort(list);
        for(int i = 0; i < N ; i++){ subs.add(list.get(i)-K);}

        int i = 0, j = 0, count = 0;
        while(i < N && j < N){
          int ni = list.get(i), nj = subs.get(j);
          if(ni == nj){count++;}
          if(ni <= nj){i++;}
          else{j++;}
        }

        System.out.println(count);
    }
}
