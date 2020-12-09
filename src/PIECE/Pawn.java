package PIECE;

import GAME.State;

public class Pawn extends Piece implements color { 
	   
	   public int[][] pMoves (int[][] state, int y, int x, int color) {
	      
	      int arr[][] = new int[8][8];
	      int prey;
	      
	      prey = y;
	      if(color == white) y = y-1;
	      else y = y+1;
	      
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) {
	            arr[y][x] = 1;
	         }
	         
	         if(x>=1) {
	            if(enemy(state, prey, x, y, x-1) == 1) {
	               arr[y][x-1] = 1;
	            }
	         }
	         
	         if(x<=6) {
	            if(enemy(state, prey, x, y, x+1) == 1) {
	               arr[y][x+1] = 1;
	            }
	         }
	         
	         if((prey==1&&color==black)||(prey==6 && color==white)) {
	            if(color == white && hPiece(state, y-1, x) == 0 && hPiece(state, y, x) == 0) {
	               arr[y-1][x] = 1;
	            }
	            else if (color == black && hPiece(state, y+1, x) ==0 && hPiece(state, y, x) == 0) arr[y+1][x] = 1;
	            else;
	         
	         }
	      }
	      return arr;
	   }
	   
	   public int[][] pAttack (int[][] state, int y, int x, int color) {
	         
	      int arr[][] = new int[8][8];
	      
	      if(color == white) y = y-1;
	      else y = y+1;
	      
	      if(!out(x, y)) {
	         if(x>=1) arr[y][x-1] = 1;
	         if(x<=6) arr[y][x+1] = 1;   
	      }   
	      return arr;
	   }
	   
	   public int[][] pMoves2 (int[][] state, int y, int x, int color) {
	      
	      int arr[][] = new int[14][14];
	      int prey, prex;
	      
	      prey = y;
	      prex = x;
	      
	      if(color == white) y = y-1;
	      else if(color == black) y = y+1;
	      else if(color == red) x = x+1;
	      else x = x-1;
	      
	      if(color%2 == 1) {
	         if(!out2(x, y)) {
	            if(hPiece(state, y, x) == 0) {
	               arr[y][x] = 1;
	            }
	            
	            if(x>=1 && !out2(x-1, y)) {
	               if(enemy2(state, prey, x, y, x-1) == 1) {
	                  arr[y][x-1] = 1;
	               }
	            }
	            
	            if(x<=12 && !out2(y, x+1)) {
	               if(enemy2(state, prey, x, y, x+1) == 1) {
	                  arr[y][x+1] = 1;
	               }
	            }
	            
	            if((prey==1&&color==black)||(prey==12 && color==white)) {
	               if(color == white && hPiece(state, y-1, x) == 0 && hPiece(state, y, x) == 0) {
	                  arr[y-1][x] = 1;
	               }
	               else if (color == black && hPiece(state, y+1, x) ==0 && hPiece(state, y, x) == 0) arr[y+1][x] = 1;
	               else;
	            
	            }
	         }
	      }
	      
	      else {
	         if(!out2(x, y)) {
	            if(hPiece(state, y, x) == 0) {
	               arr[y][x] = 1;
	            }
	            
	            if(y>=1 && !out2(x, y-1)) {
	               if(enemy2(state, prey, prex, y-1, x) == 1) {
	                  arr[y-1][x] = 1;
	               }
	            }
	            
	            if(y<=12 && !out2(x, y+1)) {
	               if(enemy2(state, prey, prex, y+1, x) == 1) {
	                  arr[y+1][x] = 1;
	               }
	            }
	            
	            if((prex==1&&color==red)||(prex==12 && color==green)) {
	               if(color == red && hPiece(state, y, x+1) == 0 && hPiece(state, y, x) == 0) {
	                  arr[y][x+1] = 1;
	               }
	               else if (color == green && hPiece(state, y, x-1) ==0 && hPiece(state, y, x) == 0) arr[y][x-1] = 1;
	               else;
	            
	            }
	         }
	      }
	      return arr;
	   }
	   
	   public int[][] pAttack2 (int[][] state, int y, int x, int color) {
	      
	      int arr[][] = new int[14][14];
	      
	      if(color == white) y = y-1;
	      else if(color == black) y = y+1;
	      else if(color == red) x = x+1;
	      else x = x-1;
	      
	      if(!out2(x, y) && color%2 == 1) {
	         if(x>=1 && !out2(y, x-1)) arr[y][x-1] = 1;
	         if(x<=12 && !out2(y, x+1)) arr[y][x+1] = 1;
	      }
	      
	      else if(!out2(x, y) && color%2 == 0) {
	         if(y>=1 && !out2(y+1, x)) arr[y+1][x] = 1;
	         if(y<=12 && !out2(y-1, x)) arr[y-1][x] = 1;
	      }
	      return arr;
	   }
	}
