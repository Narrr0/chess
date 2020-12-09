package GAME;

import PIECE.Bishop;
import PIECE.King;
import PIECE.Knight;
import PIECE.Pawn;
import PIECE.Queen;
import PIECE.Rook;

public class CheckStatus extends King {

	  public boolean check_1(int king_y, int king_x, int[][] preAttackable_space) {
	         if(preAttackable_space[king_y][king_x]!=0)return true;
	         else return false;
	      }//end of check_1()
	      
	      public boolean stalemate(int [][] king_possible_space, boolean Check) {
	         if(Check==false) {
	            for(int i = 0 ; i < 8 ; i++) {
	               for(int j = 0 ; j < 8 ; j++) {
	                  if(king_possible_space[i][j]==1) return false;
	               }
	            }return true;
	         }else return false;
	      }//end of stalemate()
	      
	      public int checkmate(int x, int y, int state[][], int [][] king_pMoves, int [][] my_pMoves, boolean Check, int color) {
	         int empty[][] = new int[8][8];
	         int attack[] = new int[21];
	         int n, ecolor = 0;
	         
	         if(color == black) ecolor = white;
	         else if(color == white) ecolor = black;
	         
	         King king = new King();
	         Pawn p=new Pawn();
	         Queen q=new Queen();
	         Rook r=new Rook();
	         Bishop b= new Bishop();
	         Knight knight=new Knight();
	        if(Check==true) {
	           if(empty == king_pMoves) {
	              int i, j, k;
	              attack = king.pAttackfrom(y, x, state);
	              n = attack[0];
	              int checkcm[][] = new int[8][8];
	              
	              for(i=1 ; i<=n ; i+=2) {
	                 if(state[attack[i]][attack[i+1]]%10 == 1) {
	                    checkcm = p.pMoves(state, attack[i], attack[i+1], ecolor); 
	                    for(j=0 ; j<8 ; j++) {
	                       for(k=0 ; k<8 ; k++) {
	                          if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                       }
	                    }
	                 }
	                 
	                 if(state[attack[i]][attack[i+1]]%10 == 2) {
	                    checkcm = knight.pMoves(state, attack[i], attack[i+1], ecolor); 
	                    for(j=0 ; j<8 ; j++) {
	                       for(k=0 ; k<8 ; k++) {
	                          if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                       }
	                    }
	                 }
	                 
	                 if(state[attack[i]][attack[i+1]]%10 == 3) {
	                    checkcm = r.pMoves(state, attack[i], attack[i+1], ecolor); 
	                    for(j=0 ; j<8 ; j++) {
	                       for(k=0 ; k<8 ; k++) {
	                          if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                       }
	                    }
	                 }
	                 
	                 if(state[attack[i]][attack[i+1]]%10 == 4) {
	                    checkcm = b.pMoves(state, attack[i], attack[i+1], ecolor);
	                    for(j=0 ; j<8 ; j++) {
	                       for(k=0 ; k<8 ; k++) {
	                          if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                       }
	                    }
	                 }
	                 
	                 if(state[attack[i]][attack[i+1]]%10 == 5) {
	                    checkcm = q.pMoves(state, attack[i], attack[i+1], ecolor); 
	                    for(j=0 ; j<8 ; j++) {
	                       for(k=0 ; k<8 ; k++) {
	                          if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                       }
	                    }
	                 }
	              }
	           }
	           else return 0;
	        }
	        
	      else if(Check==false) return 0;
	      return 0;
	      
	      }//end of checkmate()
	      
	      public int checkmate2(int x, int y, int state[][], int [][] king_pMoves, int [][] my_pMoves, boolean Check, int color) {
	            int empty[][] = new int[14][14];
	            int attack[] = new int[21];
	            int n, ecolor1 = 0, ecolor2 = 0;
	            
	            if(color%2 == 1) {
	               ecolor1 = red;
	               ecolor2 = green;
	            }
	            
	            else if(color%2 == 0) {
	               ecolor1 = white;
	               ecolor2 = black;
	            }
	            
	            King king = new King();
	            Pawn p=new Pawn();
	            Queen q=new Queen();
	            Rook r=new Rook();
	            Bishop b= new Bishop();
	            Knight knight=new Knight();
	           if(Check==true) {
	              if(empty == king_pMoves) {
	                 int i, j, k;
	                 attack = king.pAttackfrom2(y, x, state);
	                 n = attack[0];
	                 int checkcm[][] = new int[14][14];
	                 int checkcm2[][] = new int[14][14];
	                 
	                 for(i=1 ; i<=n ; i+=2) {
	                    if(state[attack[i]][attack[i+1]]%10 == 1) {
	                       checkcm = p.pMoves2(state, attack[i], attack[i+1], ecolor1); 
	                       checkcm2 = p.pMoves2(state, attack[i], attack[i+1], ecolor2); 
	                       for(j=0 ; j<14 ; j++) {
	                          for(k=0 ; k<14 ; k++) {
	                             if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                             if(checkcm2[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                          }
	                       }
	                    }
	                    
	                    if(state[attack[i]][attack[i+1]]%10 == 2) {
	                       checkcm = knight.pMoves2(state, attack[i], attack[i+1], ecolor1);
	                       checkcm2 = knight.pMoves2(state, attack[i], attack[i+1], ecolor2);
	                       for(j=0 ; j<14 ; j++) {
	                          for(k=0 ; k<14 ; k++) {
	                             if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                             if(checkcm2[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                          }
	                       }
	                    }
	                    
	                    if(state[attack[i]][attack[i+1]]%10 == 3) {
	                       checkcm = r.pMoves2(state, attack[i], attack[i+1], ecolor1);
	                       checkcm2 = r.pMoves2(state, attack[i], attack[i+1], ecolor2);
	                       for(j=0 ; j<14 ; j++) {
	                          for(k=0 ; k<14 ; k++) {
	                             if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                             if(checkcm2[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                          }
	                       }
	                    }
	                    
	                    if(state[attack[i]][attack[i+1]]%10 == 4) {
	                       checkcm = b.pMoves2(state, attack[i], attack[i+1], ecolor1);
	                       checkcm2 = b.pMoves2(state, attack[i], attack[i+1], ecolor2);
	                       for(j=0 ; j<14 ; j++) {
	                          for(k=0 ; k<14 ; k++) {
	                             if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                             if(checkcm2[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                          }
	                       }
	                    }
	                    
	                    if(state[attack[i]][attack[i+1]]%10 == 5) {
	                       checkcm = q.pMoves2(state, attack[i], attack[i+1], ecolor1);
	                       checkcm2 = q.pMoves2(state, attack[i], attack[i+1], ecolor2);
	                       for(j=0 ; j<14 ; j++) {
	                          for(k=0 ; k<14 ; k++) {
	                             if(checkcm[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                             if(checkcm2[j][k] != 0 && my_pMoves[j][k] != 0) return 0;
	                          }
	                       }
	                    }
	                 }
	              }
	              else return 0;
	           }
	           
	         else if(Check==false) return 0;
	         return 0;
	         
	         }//end of checkmate2()
	      
	      public int[][] king_self_check(int [][]king_possible_space, int[][]opponent_attackable_space){
	         for(int i = 0 ; i < 8 ; i++) {
	            for(int j = 0 ; j < 8 ; j++) {
	               if((king_possible_space[i][j]!=0)&&(opponent_attackable_space[i][j]!=0)) {
	                  king_possible_space[i][j]=0;
	               }
	            }
	         }
	         return king_possible_space;
	      }//end of king_self_check() : king이 스스로 체크당하는 위치를 제외한, 이동 가능한 좌표값 반환
	      
	      public int[][] king_self_check2(int [][]king_possible_space, int[][]opponent_attackable_space){
	            for(int i = 0 ; i < 14 ; i++) {
	               for(int j = 0 ; j < 14 ; j++) {
	                  if((king_possible_space[i][j]!=0)&&(opponent_attackable_space[i][j]!=0)) {
	                     king_possible_space[i][j]=0;
	                  }
	               }
	            }
	            return king_possible_space;
	         }//end of king_self_check2() 
	      
	      
}