
import java.util.*;
import java.io.*;

class InternetBandwidth820{//Main{

  static int INF = 2000000000;
  static int f, mf, S, T, C;
  static int[] p;
  static Hashtable<IntegerPair, Integer> res;

  public static void main(String[] args) throws Exception{
      Scanner sc = new Scanner(System.in);
      PrintWriter pw = new PrintWriter(System.out);

      Vector<Vector<Integer>> adj = new Vector<Vector<Integer>>();
      for( int network = 1; ;network++){
        mf=0; res = new Hashtable<IntegerPair, Integer>();
        int N = sc.nextInt(); if(N==0){break;}
        S = sc.nextInt(); T = sc.nextInt(); C = sc.nextInt();

        for(int i = 0 ; i <= N ; i++){ adj.add(new Vector<Integer>());}
        for(int i = 0 ; i < C ; i++){
          int x = sc.nextInt(), y = sc.nextInt(), b = sc.nextInt();
          IntegerPair pair1 = new IntegerPair(x,y), pair2 = new IntegerPair(y,x);
          if(res.containsKey(pair1)){ b+=res.get(pair1);}
          else{ adj.get(x).add(y); adj.get(y).add(x);}
          res.put(pair1,b); res.put(pair2,b);
        }
        // MaxFlow
        while(true){
          f = 0;
          Queue<Integer> q = new LinkedList<Integer>();
          int[] dist = new int[N+1]; Arrays.fill(dist, INF);
          p = new int[N+1]; Arrays.fill(p,-1);
          dist[S]=0; q.offer(S);

          while(!q.isEmpty()){
            int u = q.poll();
            if(u == T){ break; }
            for(int v : adj.get(u)){
              if(res.containsKey(new IntegerPair(u,v)) &&
                  res.get(new IntegerPair(u,v)) > 0 && dist[v] == INF){
                dist[v] = dist[u]+1; p[v] = u; q.offer(v);}
            }
          }
          augment(T,INF);
          if(f==0){break;}
          mf += f;
        }
        pw.printf("Network %d\nThe bandwidth is %d.\n\n", network, mf);
      }
      pw.flush(); pw.close();
  }

  public static void augment(int v, int minEdge){
    if(v==S){f = minEdge;}
    else if(p[v] != -1){
      IntegerPair pair1 = new IntegerPair(p[v],v);
      IntegerPair pair2 = new IntegerPair(v, p[v]);
      augment(p[v], Math.min(minEdge, res.get(pair1)));
      res.put(pair1, res.get(pair1)-f); res.put(pair2, res.get(pair2)+f);
    }
  }
}

class IntegerPair {
  Integer _first, _second;

  public IntegerPair(Integer f, Integer s) {
                   _first = f;
                   _second = s;
  }
  @Override
  public int hashCode(){
    return Objects.hash(_first,_second);
  }
  @Override
  public boolean equals(Object o){
    if(o == this) {return true;}
    if(!(o instanceof IntegerPair)) { return false;}
    IntegerPair ip = (IntegerPair) o;
    return _first == ip._first && _second == ip._second;
  }

  Integer first() { return _first; }
  Integer second() { return _second; }
  public String toString() { return first() + " " + second(); }
}
