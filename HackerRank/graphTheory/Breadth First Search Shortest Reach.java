package algorithms.graphTheory;

import java.io.*;
import java.util.*;

public class BreadthFirstSearchShortestReach {
    
    static ArrayList<ArrayList<Integer>> adjList;
    static Queue<Integer> q;
    static int[] d;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String[] ln = br.readLine().split(" ");
            int n = Integer.parseInt(ln[0]);
            int m = Integer.parseInt(ln[1]);
            adjList = new ArrayList<ArrayList<Integer>>();
            q = new LinkedList<Integer>();
            d = new int[n+1];
            Arrays.fill(d, -1);
            for(int i = 0; i <= n; i++) adjList.add(new ArrayList<Integer>());
            while(m-->0)
            {
                ln = br.readLine().split(" ");
                int u = Integer.parseInt(ln[0]);
                int v = Integer.parseInt(ln[1]);
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
            int s = Integer.parseInt(br.readLine());
            
            q.offer(s);
            d[s] = 0;
            
            while(q.peek() != null)
            {
                int u = q.poll();
                for(int i = 0; i < adjList.get(u).size() ; i++)
                {
                    int v = adjList.get(u).get(i);
                    if(d[v] == -1)
                    {
                        d[v] = d[u]+6;
                        q.offer(v);
                    }
                }
            }
            for(int i = 1 ; i < d.length ; i++)
            {
                if(i != s) System.out.print(d[i]+ " ");
                
            }
            System.out.println();
        }
    }
} 