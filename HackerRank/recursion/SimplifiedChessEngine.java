// INCOMPLETE

import java.io.*;
import java.util.*;

public class SimplifiedChessEngine{//Solution {

  public static ArrayList<String> plays;
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int G = sc.nextInt();

      while(G-->0){

        int w = sc.nextInt(), b = sc.nextInt(), m = sc.nextInt();
        Hashtable<String, String> whites = new Hashtable<>();
        Hashtable<String, String> blacks = new Hashtable<>();
        pw.println(100-G);
        pw.println(w+" "+b+" "+m);
        while(w-->0){
          String p = sc.next(), c = sc.next(), r = sc.next();
          whites.put(c+r,p);
        }
        while(b-->0){
          String p = sc.next(), c = sc.next(), r = sc.next();
          blacks.put(c+r,p);
        }

        plays = new ArrayList<String>();
        boolean win = play(whites,blacks,m,true, getQueen(whites), getQueen(blacks));
        pw.println(win?"YES":"NO");
      }
      pw.close();
    }

    public static void addMove(boolean wactive, String piece, String pos, String move, int m){
      String who = wactive? "WHITE" : "BLACK";
      plays.add(who+ "   " +piece+"-"+pos+" : "+move);
      System.out.println(m+":  MV "+who+ "   " +piece+"-"+pos+" : "+move);
    }

    public static void removeMove(boolean wactive, String piece, String pos, String move, int m){
      String who = wactive? "WHITE" : "BLACK";
      plays.remove(who+ "   " +piece+"-"+pos+" : "+move);
      System.out.println(m+":  RM "+who+ "   " +piece+"-"+pos+" : "+move);
    }

    public static boolean play(Hashtable<String,String> player,Hashtable<String,String> opponent, int m, boolean wactive, String whitequeen, String blackqueen){

      if(m<=0){return false;}
      boolean whitesWin = !wactive;

      for (String pos: player.keySet()) {
        String piece = player.get(pos);
        for(String move : getLegalMoves(piece, pos, player, opponent)){
          Hashtable<String,String> playerCP = (Hashtable<String,String>)player.clone();
          Hashtable<String,String> opponentCP = (Hashtable<String,String>)opponent.clone();
          playerCP.put(move,playerCP.get(pos)); playerCP.remove(pos);
//          addMove(wactive,piece,pos,move,m);
          if(opponentCP.containsKey(move)){
            if(opponentCP.get(move).equals("Q")){return wactive;}
            opponentCP.remove(move);
          }
          String oldWQ = whitequeen, oldBQ = blackqueen;
          if(piece.equals("Q")){
            if(wactive){whitequeen=move;} else{blackqueen=move;}
          }
          if(wactive && queenInDanger(whitequeen, playerCP, opponentCP)){continue;}//removeMove(wactive,piece,pos,move,m);continue;}
          else if(!wactive && queenInDanger(blackqueen, playerCP, opponentCP)){continue;}//removeMove(wactive,piece,pos,move,m);continue;}

          if(wactive){whitesWin |= play(opponentCP, playerCP, m-1,!wactive,whitequeen, blackqueen);}
          else{whitesWin &= play(opponentCP, playerCP, m-1,!wactive, whitequeen, blackqueen);}
          whitequeen=oldWQ; blackqueen = oldBQ;
          if(wactive && whitesWin){return true;}
          if(!wactive && !whitesWin){return false;}
//          removeMove(wactive,piece,pos,move,m);
        }
      }
      return false;
    }

    public static String getQueen(Hashtable<String,String> player){
      for(String pos: player.keySet()){
        if(player.get(pos).equals("Q")){return pos;}
      }
      return null;
    }

    public static boolean queenInDanger(String queenPos, Hashtable<String,String> player,  Hashtable<String,String> opponent){
      for(String oppPos : opponent.keySet()){
        if(getLegalMoves(opponent.get(oppPos), oppPos, opponent, player).contains(queenPos)){return true;}
      }
      return false;
    }
    public static ArrayList<String> getLegalMoves(String piece, String pos, Hashtable<String,String> player, Hashtable<String,String> opponent){
      boolean isQ = piece.equals("Q"), isN = piece.equals("N");
      boolean isR = piece.equals("R"), isB = piece.equals("B");
      int c = pos.charAt(0), r = pos.charAt(1);
      ArrayList<String> moves = new ArrayList<>();
      if(isN){ moves = legalMovesKnight(c,r,pos,player); }
      else if(isB){ moves = legalMovesBishop(c,r,pos,player, opponent);}
      else if(isR){ moves = legalMovesRook(c,r,pos,player, opponent);}
      else if(isQ) {
        moves = legalMovesRook(c,r,pos,player, opponent);
        moves.addAll(legalMovesBishop(c,r,pos,player,opponent));
      }
      return moves;
    }

    public static ArrayList<String> legalMovesRook(int c, int r, String pos, Hashtable<String,String> player, Hashtable<String,String> opponent){
      ArrayList<String> moves = new ArrayList<String>();
      int[] cols = { 1, -1,  0, 0};
      int[] rows = { 0,  0, -1, 1};
      for(int i = 0 ; i < cols.length; i++){
        boolean possible = true; int mult = 1;
        while(possible){
          char nCol = (char)(c+mult*cols[i]), nRow = (char)(r+mult*rows[i]);
          String nPos = ""+nCol+nRow;
          if(isValidCol(nCol) && isValidRow(nRow) && !player.containsKey(nPos)){
            moves.add(nPos); mult++;
            if(opponent.containsKey(nPos)){possible=false;}
          } else{possible=false;}
        }
      }
      return moves;
    }


    public static ArrayList<String> legalMovesKnight(int c, int r, String pos, Hashtable<String,String> player){
      int[] cols = {-2, -2, -1, -1, 1, 1, 2, 2};
      int[] rows = {-1,  1, -2,  2,-2, 2,-1, 1};
      ArrayList<String> moves = new ArrayList<String>();
      for(int i = 0; i < cols.length; i++){
        char nCol = (char)(c+cols[i]), nRow = (char)(r+rows[i]);
        String nPos = ""+nCol+nRow;
        if(isValidCol(nCol) && isValidRow(nRow) && !player.containsKey(nPos)){moves.add(nPos);}
      }
      return moves;
    }

    public static ArrayList<String> legalMovesBishop(int c, int r, String pos, Hashtable<String,String> player, Hashtable<String,String> opponent){
      ArrayList<String> moves = new ArrayList<String>();
      int[] cols = {-1, -1,  1, 1};
      int[] rows = {-1,  1, -1, 1};
      for(int i = 0 ; i < cols.length; i++){
        boolean possible = true; int mult = 1;
        while(possible){
          char nCol = (char)(c+mult*cols[i]), nRow = (char)(r+mult*rows[i]);
          String nPos = ""+nCol+nRow;
          if(isValidCol(nCol) && isValidRow(nRow) && !player.containsKey(nPos)){
            moves.add(nPos); mult++;
            if(opponent.containsKey(nPos)){possible=false;}
          } else{possible=false;}
        }
      }
      return moves;
    }

    public static boolean isValidCol(char c){
      return (c=='A'|| c=='B'|| c=='C' || c=='D');
    }

    public static boolean isValidRow(char c){
      return (c=='1'|| c=='2'|| c=='3' || c=='4');
    }
}
