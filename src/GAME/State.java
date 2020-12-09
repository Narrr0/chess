package GAME;

import java.awt.image.BufferedImage;

import GUI.Board;
import PIECE.Bishop;
import PIECE.Knight;
import PIECE.Pawn;
import PIECE.Queen;
import PIECE.Rook;
import SWproject.ImagePanel;


public class State extends Board{
	
	Pawn pawn=new Pawn();
    Queen queen=new Queen();
    Rook rook=new Rook();
    Bishop bishop= new Bishop();
    Knight knight=new Knight();
    
	private int[][] state;
	private int[][] Moves;
	
	public int[][] getState(ImagePanel[][] panel){
		int length=panel.length;
		state=new int[length][length];
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				state[i][j]=IsWhat(panel[i][j]);
			}
		}
		return state;
	}
	
	public int[][] getAllMoves(int[][] state, int color){   
		int length=state.length;
		Moves=new int[length][length];
		int[][] allMoves=new int[length][length];
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(state[i][j]/10==color) {
					if(state[i][j]%10==1) {
						Moves=pawn.pAttack(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
					if(state[i][j]%10==2) {
						Moves=knight.pMoves(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
					if(state[i][j]%10==3) {
						Moves=rook.pMoves(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
					if(state[i][j]%10==4) {
						Moves=bishop.pMoves(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
					if(state[i][j]%10==5) {
						Moves=queen.pMoves(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
				}
			}
		}
		return allMoves;
	}
	
	public int[][] getAllMoves2(int[][] state, int color){	 //color가 포함된 팀의 전체 공격 범위를 구함
		int length=state.length;
		int teamColor=color%2;		//0은 적녹, 1은 흑백
		Moves=new int[length][length];
		int[][] allMoves=new int[length][length];
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if((state[i][j]/10)%2==teamColor) {
					if(state[i][j]%10==1) {
						Moves=pawn.pAttack2(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
					if(state[i][j]%10==2) {
						Moves=knight.pMoves2(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
					if(state[i][j]%10==3) {
						Moves=rook.pMoves2(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
					if(state[i][j]%10==4) {
						Moves=bishop.pMoves2(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
					if(state[i][j]%10==5) {
						Moves=queen.pMoves2(state,i,j,state[i][j]/10);
						for(int I=0;I<length;I++) {
							for(int J=0;J<length;J++) {
								allMoves[I][J]+=Moves[I][J];
							}
						}
					}
				}
			}
		}
		return allMoves;
	}
	
	public int IsWhat(ImagePanel panel) {
		BufferedImage what=panel.getImage();
		if(what==WhitePawn) 
			return 11;
		if(what==WhiteKnight) 
			return 12;
		if(what==WhiteRook) 
			return 13;
		if(what==WhiteBishop) 
			return 14;
		if(what==WhiteQueen) 
			return 15;
		if(what==WhiteKing)
			return 16;
		if(what==RedPawn) 
			return 21;
		if(what==RedKnight) 
			return 22;
		if(what==RedRook) 
			return 23;
		if(what==RedBishop) 
			return 24;
		if(what==RedQueen) 
			return 25;
		if(what==RedKing)
			return 26;
		if(what==BlackPawn) 
			return 31;
		if(what==BlackKnight) 
			return 32;
		if(what==BlackRook) 
			return 33;
		if(what==BlackBishop) 
			return 34;
		if(what==BlackQueen) 
			return 35;
		if(what==BlackKing)
			return 36;
		if(what==GreenPawn) 
			return 41;
		if(what==GreenKnight) 
			return 42;
		if(what==GreenRook) 
			return 43;
		if(what==GreenBishop) 
			return 44;
		if(what==GreenQueen) 
			return 45;
		if(what==GreenKing)
			return 46;
		else
			return 0;
	}
}