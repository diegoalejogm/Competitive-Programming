import java.io.*;
import java.util.*;

class TransportationSystem11228{

  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    String ln = br.readLine(); Integer T = Integer.parseInt(ln);

    for(int i = 0; i < T; i++){
      solve(i+1, br, pw);
    }
    br.close(); pw.close();
  }

  public static void solve(int T, BufferedReader br, PrintWriter pw) throws Exception{

    String[] sp = br.readLine().split(" ");
    int N = Integer.parseInt(sp[0]), R = Integer.parseInt(sp[1]);

    Vector<IntegerPair> position = new Vector<IntegerPair>();
    Vector<IntegerTriple> EdgeList = new Vector<IntegerTriple>();

    for(int i = 0; i < N ; i++){
      sp = br.readLine().split(" ");
      position.add(new IntegerPair(Integer.parseInt(sp[0]), Integer.parseInt(sp[1])));
      for(int j = 0 ; j < i ; j++){
        IntegerPair n1 = position.get(i), n2 = position.get(j);
        double dist = dist(n1, n2);
        EdgeList.add(new IntegerTriple(dist, j, i));
      }
    }
    Collections.sort(EdgeList);

    double road_cost = 0, rail_cost=0; int states = 1;       	// all V are disjoint sets at the beginning
    UnionFind UF = new UnionFind(N);
    for (int i = 0; i < EdgeList.size(); i++) {               	// for each edge, O(E)
      IntegerTriple front = EdgeList.get(i);
      if (!UF.isSameSet(front.second(), front.third())) {      	// check
        if(front.first()<=R){road_cost+=front.first();}
        else{ rail_cost += front.first(); states++;}
        UF.unionSet(front.second(), front.third());        	// link them
    } }
    // note: the number of disjoint sets must eventually be 1 for a valid MST
    pw.printf("Case #%d: %d %.0f %.0f\n", T, states, road_cost, rail_cost);
  }

  public static double dist(IntegerPair p1, IntegerPair p2){
    double c1 = Math.pow(Math.abs(p1.first()-p2.first()),2);
    double c2 = Math.pow(Math.abs(p1.second()-p2.second()),2);
    return Math.sqrt(c1+c2);
  }
}




// Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
class UnionFind {                                          	// OOP style
  private Vector<Integer> p, rank, setSize;
  private int numSets;

  public UnionFind(int N) {
    p = new Vector<Integer>(N);
    rank = new Vector<Integer>(N);
    setSize = new Vector<Integer>(N);
    numSets = N;
    for (int i = 0; i < N; i++) {
      p.add(i);
      rank.add(0);
      setSize.add(1);
    }
  }

  public int findSet(int i) {
    if (p.get(i) == i) return i;
    else {
      int ret = findSet(p.get(i)); p.set(i, ret);
      return ret; } }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) {
    if (!isSameSet(i, j)) { numSets--;
    int x = findSet(i), y = findSet(j);
    // rank is used to keep the tree short
    if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
    else                       	{ p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                                 	if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
  public int numDisjointSets() { return numSets; }
  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
}


class IntegerPair implements Comparable {
	Integer _first, _second;

	public IntegerPair(Integer f, Integer s) {
                   _first = f;
                   _second = s;
	}

	public int compareTo(Object o) {
                   if (this.first() != ((IntegerPair )o).first())
                   return this.first() - ((IntegerPair )o).first();
                   else
                   return this.second() - ((IntegerPair )o).second();
	}

	Integer first() { return _first; }
	Integer second() { return _second; }
  public String toString() { return first() + " " + second(); }
}

class IntegerTriple implements Comparable {
  Double _first; Integer _second, _third;

  public IntegerTriple(Double f, Integer s, Integer t) {
    _first = f;
    _second = s;
    _third = t;
  }

  public int compareTo(Object o) {
    if (!this.first().equals(((IntegerTriple)o).first())){
      if(this.first() > ((IntegerTriple)o).first() ){ return 1;}
      else{return -1;}
    }

    else if (!this.second().equals(((IntegerTriple)o).second()))
      return this.second() - ((IntegerTriple)o).second();
    else
      return this.third() - ((IntegerTriple)o).third();
  }

  Double first() { return _first; }
  Integer second() { return _second; }
  Integer third() { return _third; }

  public String toString() { return first() + " " + second() + " " + third(); }
}
