package ch4;

import java.io.*;
import java.util.*;

class WordTransformation429 {

	static ArrayList<String> allWords;
	static ArrayList<ArrayList<String>> adj;
	static Hashtable<String, Integer> indexOfWord;
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		String ln;
		int testSet = Integer.parseInt(br.readLine()); br.readLine();
		boolean first = true;
		while( testSet--> 0)
		{
			if(!first) pw.println();
			else first = false;
			
			indexOfWord = new Hashtable<String, Integer>();
			adj = new ArrayList<ArrayList<String>>();
			
			allWords = new ArrayList<String>();
			while(!(ln = br.readLine()).equals("*"))
			{
				indexOfWord.put(ln, allWords.size());
				allWords.add(ln);
				adj.add(new ArrayList<String>());
				
				for(int j = 0; j < allWords.size(); j++)
				{
					String prevWord = allWords.get(j); 
					if(prevWord.length() != ln.length()) continue;
					int count = 0;
					for(int i = 0; i < ln.length() && count <= 1; i++)
					{
						if(ln.charAt(i) != prevWord.charAt(i)) count++;
					}
					if(count == 1)
					{
						adj.get(indexOfWord.get(prevWord)).add(ln);
						adj.get(indexOfWord.get(ln)).add(prevWord);
					}
				}
			}
			while((ln = br.readLine()) != null && !ln.equals(""))
			{
				String[] words = ln.split(" ");
				int ans = bfs(words[0], words[1]);
				pw.println(ln +" "+ans);
			}
			pw.flush();
		}
		pw.close();
	}		
	
	static int bfs(String u, String v)
	{
		int[] dist = new int[adj.size()];
		Arrays.fill(dist, -1);
		Queue<String> q = new LinkedList<String>();
		dist[indexOfWord.get(u)] = 0;
		q.add(u);
		while(!q.isEmpty())
		{
			String top = q.poll();
			if(top.equals(v)) break;
			for(String word : adj.get(indexOfWord.get(top)))
			{
				if(dist[indexOfWord.get(word)]== -1)
				{
					dist[indexOfWord.get(word)] = dist[indexOfWord.get(top)]+1;
					q.add(word);					
				}
			}
		}
		return dist[indexOfWord.get(v)];
	}
}
