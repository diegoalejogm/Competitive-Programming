import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.*;
import java.util.*;

class CrazyKing11352//Main
{
  public static int MAX = 10000;
  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

    String ln = "";
    int T = Integer.parseInt(br.readLine());

    while(T --> 0){

      ln = br.readLine();
      int M = Integer.parseInt(ln.split(" ")[0]);
      int N = Integer.parseInt(ln.split(" ")[1]);

      char[][] board = new char[M][N];
      // Fill board
      for(int i = 0 ; i < M ; i++){
        board[i] = br.readLine().toCharArray();
      }
      // Mark occupied
      for(int i = 0 ; i < M ; i++){
        for(int j = 0 ; j < N ; j++){
          char c = board[i][j];
          if(c == 'Z') markHorseJumps(i,j,board);
        }
      }
      // Find path
      int d = findDist(board, M, N);

      String msg = (d==MAX)? "King Peter, you can't go now!" :
       "Minimal possible length of a trip is " + d;

      pw.println(msg);

    }
    pw.flush();
    pw.close();
    br.close();
  }

  public static int findDist(char[][] board, int M, int N){

    // Find A & B
    int Ai=0, Aj=0;

    for(int i = 0 ; i < M ; i++){
      for(int j = 0 ; j < N ; j++){
        char c = board[i][j];
        if(c == 'A'){ Ai = i; Aj = j;}
      }
    }

    int dist = MAX;
    int[] pos = {Ai, Aj, 0};
    Queue<int[]> q = new LinkedList<int[]>();
    q.offer(pos);

    while(q.peek() != null && dist == MAX)
    {
      pos = q.poll();
      int i = pos[0], j = pos[1], d = pos[2];

      if(!inBounds(i,j,board) || board[i][j] == 'X') { continue; }
      else if( board[i][j] == 'B'){ dist = d;}
      else{
        board[i][j] = 'X';
        int[] ver = {1,1,1,0,0,-1,-1,-1}, hor = {-1,0,1,-1,1,-1,0,1};
        for(int k = 0; k < ver.length; k++){
          int x = i+hor[k], y = j+ver[k];
          int[] neighbor = {x,y,d+1};
          q.offer(neighbor);
        }
      }
    }
    return dist;
  }
  public static void markHorseJumps(int i, int j, char[][] board){

    int[] ver = {-1,  1, -2,  2,-2, 2,-1, 1};
    int[] hor = {-2, -2, -1, -1, 1, 1, 2, 2};

    for(int k = 0; k < ver.length; k++){
      int x = i+hor[k];
      int y = j+ver[k];
      if(inBounds(x,y, board) && board[x][y] == '.') board[x][y] = 'X';
    }
    board[i][j] = 'X';
  }

  public static boolean inBounds(int i , int j, char[][] board){

    int height = board.length;
    if(height == 0 ) return false;
    int width = board[0].length;

    return 0<=i && i<height && 0<=j && j< width;

  }
}
