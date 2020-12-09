package PIECE;

import java.util.ArrayList;

import GAME.Pos;
import GUI.Board;

interface color{
	   int empty = 0;
	   int white = 1;
	   int black = 3;
	   int red = 2;
	   int green = 4;
	}

	public class Piece implements color {
	   public int color;
	   int mode;
	   boolean moved;
	   boolean survive;
	   Board b = new Board();
	   
	   public void setColor(int color) {
	      if(color == 1) color = white;
	      else if(color == 2) color = red;
	      else if(color == 3) color = black;
	      else if(color ==4) color = green;
	      else color = empty;
	   }
	   
	   public int getColor() {
	      return color;
	   }
	   
	   public int enemy(int[][] state, int y, int x, int ey, int ex) {
	      int henemy = 0;
	      if((state[y][x]/10 != state[ey][ex]/10) && state[ey][ex]/10 != 0 && state[y][x]/10 != 0) {
	         henemy = 1;
	      }
	      return henemy;
	   }
	   
	   public int enemy2(int[][] state, int y, int x, int ey, int ex) {
	      int henemy = 0;
	      if(((state[y][x]/10)%2 != (state[ey][ex]/10)%2) && state[ey][ex] != 0 && state[y][x] != 0) {
	         henemy = 1;
	      }
	      return henemy;
	   }
	   
	   int hPiece(int[][] state, int y, int x) {
	      int hpiece = 0;
	      if(state[y][x] != 0) hpiece = 1;
	      return hpiece;
	   }
	   
	   public boolean out(int x, int y) {
	      if(x>7 || x<0 || y>7 || y<0) return true;
	      else return false;
	   }
	   
	   public boolean out2(int x, int y) {
		      if(x>13 || x<0 || y>13 || y<0) return true;
		      if(0<=x && x<=2 && 0<=y && y<=2) return true;
		      if(11<=x && x<=13 && 0<=y && y<=2) return true;
		      if(0<=x && x<=2 && 11<=y && y<=13) return true;
		      if(11<=x && x<=13 && 11<=y && y<=13) return true;
		      else return false;
		   }
}