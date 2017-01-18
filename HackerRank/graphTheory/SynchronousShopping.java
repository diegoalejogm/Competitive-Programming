// NOTE: Partially solved
import java.io.*;
import java.util.*;

public class SynchronousShopping{// Solution {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      ArrayList<BitSet> typSold = new ArrayList<BitSet>();
      ArrayList<ArrayList<IntegerPair>> adj = new ArrayList<ArrayList<IntegerPair>>();
      typSold.add(new BitSet()); adj.add(new ArrayList<IntegerPair>());
      int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
      for(int i = 0 ; i < N ; i++){
        int Ti = sc.nextInt(); BitSet types = new BitSet();
        for(int j = 0; j < Ti; j++){ types.set(sc.nextInt());}
        typSold.add(types); adj.add(new ArrayList<IntegerPair>());
      }

      for(int i = 0; i < M; i++){
        int X = sc.nextInt(), Y = sc.nextInt(), Z = sc.nextInt();
        adj.get(X).add(new IntegerPair(Y,Z));
        adj.get(Y).add(new IntegerPair(X,Z));
      }

      Hashtable<Node, Integer> cost = new Hashtable<Node,Integer>();
      Hashtable<Node, Integer> costBig = new Hashtable<Node,Integer>(); // Cost
      PriorityQueue<Node> q = new PriorityQueue<Node>();

      Node first= new Node(1,1,0,typSold.get(1)), last = null;
      cost.put(first,0); costBig.put(first,0); q.offer(first);

      while(!q.isEmpty()){
        Node n = q.poll();//System.out.println(n);
        int card = n.types().cardinality();
        if(n.Z() > cost.get(n)){continue;}
        if(n.X() == N && n.Y() == N && card==K){last=n;break;}

        for(IntegerPair e : adj.get(n.X())){
          BitSet newBitSet = new BitSet(); newBitSet.or(n.types());
          newBitSet.or(typSold.get(e.first()));
          Node next = new Node(e.first(), n.Y(), cost.get(n)+e.second(), newBitSet);
          Node alt = new Node(n.Y(), e.first(), cost.get(n)+e.second(), newBitSet);
          if( (!cost.containsKey(alt) || next.Z() < cost.get(alt)) &&
          (!cost.containsKey(next) || next.Z() < cost.get(next)) ){
            q.offer(next); cost.put(next,next.Z()); costBig.put(next,costBig.get(n)+e.second());
          }
        }
        if(n.X() == n.Y()) {continue;}
        for(IntegerPair f : adj.get(n.Y())){
          BitSet newBitSet = new BitSet(); newBitSet.or(n.types());
          newBitSet.or(typSold.get(f.first()));
          Node next = new Node(n.X(), f.first(), cost.get(n)+f.second(), newBitSet);
          Node alt = new Node(f.first(), n.X(), cost.get(n)+f.second(), newBitSet);
          if( (!cost.containsKey(alt) || next.Z() < cost.get(alt)) &&
          (!cost.containsKey(next) || next.Z() < cost.get(next)) ){
            q.offer(next); cost.put(next,next.Z()); costBig.put(next,costBig.get(n));
          }
        }
      }
      int BC = costBig.get(last), LC = cost.get(last)-costBig.get(last); // BigCat & LittleCat times
//      pw.println("BC: "+BC+ " LC: "+ LC); pw.close();
      pw.println(Math.max(BC,LC)); pw.close();

    }

    public static class IntegerPair {
      private int first, second;

      public IntegerPair(int first, int second){
        this.first= first; this.second = second;
      }
      public int first(){return first;}
      public int second(){return second;}
    }
    public static class Node implements Comparable{

      private int X, Y; private int Z;
      private BitSet types;

      public Node(int X, int Y, int Z, BitSet types){
        this.X = X; this.Y = Y; this.Z = Z; this.types = types;
      }

      public int compareTo(Object o){
        Node node = (Node)o;
        if(this.Z > node.Z){return 1;}
        else if(this.Z == node.Z){return types.cardinality()-node.types.cardinality();}
        else{return -1;}
      }

      public int X(){return X;}
      public int Y(){return Y;}
      public int Z(){return Z;}
      public BitSet types(){return types;}
      public String toString(){return "X: "+X+". Y: "+Y+". Z: "+Z+". T: "+types;}
      @Override
      public int hashCode(){
        return Objects.hash(X,Y,types);
      }
      @Override
      public boolean equals(Object o){
        if(o == this) {return true;}
        if(!(o instanceof Node)) { return false;}
        Node node = (Node) o;
        return X == node.X && Y== node.Y && types.equals(node.types);
      }
    }
}
