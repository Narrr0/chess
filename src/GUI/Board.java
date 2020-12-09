package GUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

import GAME.CheckStatus;
import GAME.State;
import GAME.Turn;
import PIECE.Bishop;
import PIECE.King;
import PIECE.Knight;
import PIECE.Pawn;
import PIECE.Queen;
import PIECE.Rook;
import SWproject.ChessPieceSprite;
import SWproject.ImagePanel;
import SWproject.ChessPieceSprite.ChessPieceSpriteType;

public class Board extends JFrame{
	   
	   public BufferedImage BlackPawn = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_PAWN);
	   public BufferedImage BlackKnight = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_KNIGHT);
	   public BufferedImage BlackRook = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_LOOK);
	   public  BufferedImage BlackBishop = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_BISHOP);
	   public  BufferedImage BlackQueen = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_QUEEN);
	   public BufferedImage BlackKing = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_KING);
	   public BufferedImage WhitePawn = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_PAWN);
	   public  BufferedImage WhiteKnight = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_KNIGHT);
	   public  BufferedImage WhiteRook = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_LOOK);
	   public  BufferedImage WhiteBishop = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_BISHOP);
	   public  BufferedImage WhiteQueen = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_QUEEN);
	   public  BufferedImage WhiteKing = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_KING);
	   public BufferedImage RedPawn = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_PAWN);
	   public BufferedImage RedKnight = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_KNIGHT);
	   public BufferedImage RedRook = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_LOOK);
	   public  BufferedImage RedBishop = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_BISHOP);
	   public  BufferedImage RedQueen = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_QUEEN);
	   public BufferedImage RedKing = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_KING);
	   public BufferedImage GreenPawn = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_PAWN);
	   public BufferedImage GreenKnight = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_KNIGHT);
	   public BufferedImage GreenRook = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_LOOK);
	   public  BufferedImage GreenBishop = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_BISHOP);
	   public  BufferedImage GreenQueen = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_QUEEN);
	   public BufferedImage GreenKing = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_KING);
	   
	   private int select;
	   private int x,y;
	   private int prex,prey;
	   int Bking_x, Bking_y;
	   int Wking_x, Wking_y;
	   int Rking_x, Rking_y;
	   int Gking_x, Gking_y;
	   
	   private boolean check=false;
	   private int checkmate=0;
	   private int checkmateW,checkmateB,checkmateR,checkmateG;
	   private boolean staelmate=false;
	   
	   int[][] state;
	   int[][] canMove;
	   int[][] canAttack;
	   int[][] enemyMoves;
	   int[][] myMoves;
	   
	   public void Board1() {
	      int[] player= {1,3};
	      boolean[] survive= {true,true};
	      select=0;
	      Bking_x=4; Bking_y=0;
	      Wking_x=4; Wking_y=7;
	      
	      state=new int[8][8];
	      canMove=new int[8][8];
	      canAttack=new int[8][8];
	      enemyMoves=new int[8][8];
	      
	       State State = new State(); 
	       CheckStatus check_status=new CheckStatus();
	       Turn turn=new Turn(player);
	       
	       Pawn pawn=new Pawn();
	       Queen queen=new Queen();
	       Rook rook=new Rook();
	       Bishop bishop= new Bishop();
	       Knight knight=new Knight();
	       King king=new King(); 
	       Message message=new Message();
	       
	       JFrame frame = new JFrame("Chess game");
	       frame.setSize(1000, 1000);
	       frame.setLocationRelativeTo(null);
	       ImagePanel[][] panel=new ImagePanel[8][8];
	       JButton[][] button= new JButton[8][8];
	       
	       ActionListener move = new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	              JButton button=(JButton)e.getSource();
	              setPos(button.getName());
	              state=State.getState(panel);
	              
	              if(state[y][x]%10==1) 
	                 canMove=pawn.pMoves(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==5) 
	                 canMove=queen.pMoves(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==4) 
	                 canMove=bishop.pMoves(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==3) 
	                 canMove=rook.pMoves(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==2) 
	                 canMove=knight.pMoves(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==6) {
	                 enemyMoves=State.getAllMoves(state,4-(state[y][x]/10));
	                 canMove=king.pMoves(state,y,x,state[y][x]/10,enemyMoves);
	              }
	                 
	            if (select==1) {   // 말을 선택했던 상황에서
	               if (panel[y][x].getBackground()==Color.pink){   // 이동가능범위 클릭한 경우
	                  select=0;
	                  panel[y][x].setImage(null);
	                  panel[y][x].setImage(panel[prey][prex].getImage());
	                  
	                  if(state[prey][prex]==36) {
	                     Bking_x=x;
	                     Bking_y=y;
	                  }
	                  if(state[prey][prex]==16) {
	                     Wking_x=x;
	                     Wking_y=y;
	                  }
	                  
	                  state=State.getState(panel);
	                  
	                  if(state[y][x]%10==1) {
	                     canAttack=pawn.pAttack(state,y,x,state[y][x]/10);
	                  }
	                  if(state[y][x]%10==2) {
	                     canAttack=knight.pMoves(state,y,x,state[y][x]/10);
	                  }
	                  if(state[y][x]%10==3) {
	                     canAttack=rook.pMoves(state,y,x,state[y][x]/10);
	                  }
	                  if(state[y][x]%10==4) {
	                     canAttack=bishop.pMoves(state,y,x,state[y][x]/10);
	                  }
	                  if(state[y][x]%10==5) {
	                     canAttack=queen.pMoves(state,y,x,state[y][x]/10);
	                  }
	                  
	                  panel[y][x].updateUI();
	                  panel[prey][prex].setImage(null);
	                  panel[prey][prex].setBorder(BorderFactory.createEmptyBorder());
	                  initBackground(panel);
	                  
	                  System.out.println("흑킹의 좌표: "+Bking_x+","+Bking_y);
	                  System.out.println("백킹의 좌표: "+Wking_x+","+Wking_y);
	                  
	                  enemyMoves=State.getAllMoves(state,state[y][x]/10);  //움직인 말의 총 공격범위
	                  myMoves=State.getAllMoves(state,4-(state[y][x]/10));
	                  for(int i=0;i<8;i++) {
	                	  for(int j=0;j<8;j++) {
	                		  System.out.print(enemyMoves[i][j]);
	                	  }
	                	  System.out.println();
	                  }
	                  System.out.println();
	                 
	                  if(state[y][x]/10==1) {
	                     check=check_status.check_1(Bking_y, Bking_x,  enemyMoves);
	                     checkmate=check_status.checkmate(Bking_y, Bking_x, state, king.pMoves(state, Bking_y, Bking_x, 3, enemyMoves),
	                           enemyMoves,check,3);
	                     for(int i=0;i<8;i++) {
		                	  for(int j=0;j<8;j++) {
		                		  System.out.print(king.pMoves(state, Bking_y, Bking_x, 3, enemyMoves)[i][j]);
		                	  }
		                	  System.out.println();
		                  }
	                  }
	                  
	                  else {
	                     check=check_status.check_1(Wking_y, Wking_x, enemyMoves);
	                   
	                        checkmate=check_status.checkmate(Wking_y, Wking_x, state, king.pMoves(state, Wking_y, Wking_x, 1, enemyMoves),
	                              enemyMoves,check,1);
	                     
	                      for(int i=0;i<8;i++) {
	  	                	  for(int j=0;j<8;j++) {
	  	                		  System.out.print(king.pMoves(state, Wking_y, Wking_x, 1, enemyMoves)[i][j]);
	  	                	  }
	  	                	  System.out.println();
	  	                  }
	                     
	                  }
	                  System.out.println();
	                  for(int i=0;i<8;i++) {
  	                	  for(int j=0;j<8;j++) {
  	                		  System.out.print(myMoves[i][j]);
  	                	  }
  	                	  System.out.println();
  	                  }
	                
	                      System.out.println("체크: "+check);
	                      System.out.println("체크메이트 당한 플레이어: "+checkmate);
	                      System.out.printf("말(%d, %d)이 ", prex, prey);
	                      System.out.printf("위치(%d, %d)로 이동되었습니다\n", x, y);
	                  }
	                  
	                  else {     // 이동가능범위 아닌 곳을 눌렀을 때
	                     turn.Rotate(true,survive);
	                     if(panel[y][x].getImage()==null)    // 빈 칸을 눌렀을 때
	                     {
	                        select=0;
	                        panel[prey][prex].setBorder(BorderFactory.createEmptyBorder());
	                        initBackground(panel);
	                     }
	                     else {   // 다른 말을 눌렀을 때
	                        select=1;
	                        System.out.println();
	                        panel[prey][prex].setBorder(BorderFactory.createEmptyBorder());
	                        panel[y][x].setBorder(BorderFactory.createLineBorder(Color.RED, 4));
	                        initBackground(panel);
	                        paintBackground(canMove,panel);
	                     }
	                  }
	               }
	               else {   // select==0
	                  if(turn.MyTurn(state[y][x]/10,survive)){
	                     if(panel[y][x].getImage()!=null) {
	                        select=1;
	                        System.out.printf("말(%d, %d)를 선택하였습니다.\n", x, y); 
	                        panel[prey][prex].setBorder(BorderFactory.createEmptyBorder());
	                        panel[y][x].setBorder(BorderFactory.createLineBorder(Color.RED, 4));
	                        initBackground(panel);
	                        paintBackground(canMove,panel);
	                     }
	                     else {
	                        System.out.printf("위치(%d, %d)를 선택하였습니다.\n", x, y); 
	                     }
	                  }
	                  else {
	                     //System.out.printf("잘못된 칸을 선택하셨습니다.\n");
	                  }
	               }
	               panel[prey][prex].updateUI();
	               prex=getx();
	               prey=gety();
	                 }
	              
	        };
	        
	       for(int i=0;i<8;i++) {
	          for(int j=0;j<8;j++) {
	             panel[i][j] = new ImagePanel();
	             button[i][j]= new JButton();
	             if((i%2==0||j%2==0)&&(i%2!=0||j%2!=0)) {
	                panel[i][j].setBackground(Color.white);
	                panel[i][j].add(button[i][j]);
	                button[i][j].setName(String.valueOf(j)+","+String.valueOf(i));
	                button[i][j].setBackground(Color.white);
	                button[i][j].setOpaque(false);
	                button[i][j].addActionListener(move);
	                panel[i][j].setLayout(new GridLayout(1,1));
	             }
	             else {
	                panel[i][j].setBackground(Color.gray);
	                panel[i][j].add(button[i][j]);
	                button[i][j].setName(String.valueOf(j)+","+String.valueOf(i));
	                button[i][j].setBackground(Color.white);
	                button[i][j].setOpaque(false);
	                button[i][j].addActionListener(move);
	                panel[i][j].setLayout(new GridLayout(1,1));
	             }
	             if(i==1) 
	                panel[i][j].setImage(BlackPawn);
	             if(i==6) 
	                panel[i][j].setImage(WhitePawn);
	             frame.add(panel[i][j]);
	          }
	       }
	       panel[0][0].setImage(BlackRook);
	       panel[0][7].setImage(BlackRook);
	       panel[0][1].setImage(BlackKnight);
	       panel[0][6].setImage(BlackKnight);
	       panel[0][2].setImage(BlackBishop);
	       panel[0][5].setImage(BlackBishop);
	       panel[0][3].setImage(BlackQueen);
	       panel[0][4].setImage(BlackKing);
	       panel[7][0].setImage(WhiteRook);
	       panel[7][7].setImage(WhiteRook);
	       panel[7][1].setImage(WhiteKnight);
	       panel[7][6].setImage(WhiteKnight);
	       panel[7][2].setImage(WhiteBishop);
	       panel[7][5].setImage(WhiteBishop);
	       panel[7][4].setImage(WhiteKing);
	       panel[7][3].setImage(WhiteQueen);
	    
	       frame.setLayout(new GridLayout(8,8));
	       frame.setVisible(true);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   public void Board2() {
	      int[] player= {1,2,3,4};
	      boolean[] survive= {true,true,true,true};
	      
	      select=0;
	      Bking_x=7; Bking_y=0;
	      Wking_x=7; Wking_y=13;
	      Rking_x=0; Rking_y=7;
	      Gking_x=13; Gking_y=7;
	      
	      state=new int[14][14];
	      canMove=new int[14][14];
	      canAttack=new int[14][14];
	      enemyMoves=new int[14][14];
	      
	       State State = new State(); 
	       CheckStatus check_status=new CheckStatus();
	       Turn turn=new Turn(player);
	       
	       Pawn pawn=new Pawn();
	       Queen queen=new Queen();
	       Rook rook=new Rook();
	       Bishop bishop= new Bishop();
	       Knight knight=new Knight();
	       King king=new King(); 
	       
	      JFrame frame = new JFrame("Chess game");
	       frame.setSize(1000, 1000);
	       frame.setLocationRelativeTo(null);
	       ImagePanel[][] panel=new ImagePanel[14][14];
	       JButton[][] button= new JButton[14][14];
	       
	       ActionListener move = new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	              JButton button=(JButton)e.getSource();
	              setPos(button.getName());
	              state=State.getState(panel);
	              
	              if(state[y][x]%10==1)
	                 canMove=pawn.pMoves2(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==5) 
	                 canMove=queen.pMoves2(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==4) 
	                 canMove=bishop.pMoves2(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==3) 
	                 canMove=rook.pMoves2(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==2) 
	                 canMove=knight.pMoves2(state,y,x,state[y][x]/10);
	              if(state[y][x]%10==6) {
	                 enemyMoves=State.getAllMoves2(state,5-(state[y][x]/10));
	                 canMove=king.pMoves2(state,y,x,state[y][x]/10,enemyMoves);
	              }
	             
	                 
	            if (select==1) {   // 말을 선택했던 상황에서
	               if (panel[y][x].getBackground()==Color.pink){   // 이동가능범위 클릭한 경우
	                  select=0;
	                  panel[y][x].setImage(null);
	                  panel[y][x].setImage(panel[prey][prex].getImage());
	                  
	                  if(state[prey][prex]==36) {
	                     Bking_x=x;
	                     Bking_y=y;
	                  }
	                  if(state[prey][prex]==16) {
	                     Wking_x=x;
	                     Wking_y=y;
	                  }
	                  if(state[prey][prex]==26) {
	                     Rking_x=x;
	                     Rking_y=y;
	                  }
	                  if(state[prey][prex]==46) {
	                     Gking_x=x;
	                     Gking_y=y;
	                  }
	                  
	                  
	                  state=State.getState(panel);
	                  
	                  if(state[y][x]%10==1) {
	                     canAttack=pawn.pAttack2(state,y,x,state[y][x]/10);
	                  }
	                  if(state[y][x]%10==2) {
	                     canAttack=knight.pMoves2(state,y,x,state[y][x]/10);
	                  }
	                  if(state[y][x]%10==3) {
	                     canAttack=rook.pMoves2(state,y,x,state[y][x]/10);
	                  }
	                  if(state[y][x]%10==4) {
	                     canAttack=bishop.pMoves2(state,y,x,state[y][x]/10);
	                  }
	                  if(state[y][x]%10==5) {
	                     canAttack=queen.pMoves2(state,y,x,state[y][x]/10);
	                  }
	                  
	                  panel[y][x].updateUI();
	                  panel[prey][prex].setImage(null);
	                  panel[prey][prex].setBorder(BorderFactory.createEmptyBorder());
	                  initBackground(panel);
	                  
	                  System.out.println("흑킹의 좌표: "+Bking_x+","+Bking_y);
	                  System.out.println("백킹의 좌표: "+Wking_x+","+Wking_y);
	                  System.out.println("홍킹의 좌표: "+Rking_x+","+Rking_y);
	                  System.out.println("녹킹의 좌표: "+Gking_x+","+Gking_y);
	                  
	                  enemyMoves=State.getAllMoves2(state,state[y][x]/10);	//움직인 말의 상대팀의 공격 범위
	                  
	                  if((state[y][x]/10)%2==0) {
	                     check=check_status.check_1(Bking_y, Bking_x, canAttack)||check_status.check_1(Wking_y, Wking_x, canAttack);
	                     if(check==true) {
	                     checkmateB=check_status.checkmate2(Bking_y, Bking_x, state, king.pMoves2(state, Bking_y, Bking_y, 3, enemyMoves),
	                           State.getAllMoves2(state,1),check,3);
	                     checkmateW=check_status.checkmate2(Wking_y, Wking_x, state, king.pMoves2(state, Wking_y, Wking_y, 1, enemyMoves),
	                           State.getAllMoves2(state,1),check,1);
	                     }
	                  }
	                  else {
	                     check=check_status.check_1(Rking_y, Rking_x, canAttack)||check_status.check_1(Gking_y, Gking_x, canAttack);
	                     if(check==true) {
	                        checkmateR=check_status.checkmate2(Rking_y, Rking_x, state, king.pMoves2(state, Rking_y, Rking_y, 2, enemyMoves),
	 	                           State.getAllMoves2(state,2),check,2);
	                        checkmateG=check_status.checkmate2(Gking_y, Gking_x, state, king.pMoves2(state, Gking_y, Gking_y, 4, enemyMoves),
	 	                           State.getAllMoves2(state,2),check,4);
	                     }
	                  }
	                  setDead(checkmateB,survive);
	                  setDead(checkmateW,survive);
	                  setDead(checkmateR,survive);
	                  setDead(checkmateG,survive);
	                  
                      System.out.println("체크: "+check);
                      if(check=true) {
                    	  System.out.print("체크메이트 당한 플레이어: ");
	                      if(checkmateB!=0) {
	                    	  System.out.print(checkmateB+" ");
	                      }
	                      if(checkmateW!=0) {
	                    	  System.out.print(checkmateW+" ");
	                      }
	                      if(checkmateR!=0) {
	                    	  System.out.print(checkmateR+" ");
	                      }
	                      if(checkmateG!=0) {
	                    	  System.out.print(checkmateG+" ");
	                      }
	                      System.out.println();
                      }
                      System.out.printf("말(%d, %d)이 ", prex, prey);
                      System.out.printf("위치(%d, %d)로 이동되었습니다\n", x, y);
	               }
	                  else {     // 이동가능범위 아닌 곳을 눌렀을 때
	                     //turn.Rotate(true,survive);
	                     if(panel[y][x].getImage()==null)    // 빈 칸을 눌렀을 때
	                     {
	                        select=0;
	                        panel[prey][prex].setBorder(BorderFactory.createEmptyBorder());
	                        initBackground(panel);
	                     }
	                     else {   // 다른 말을 눌렀을 때
	                        select=1;
	                        System.out.println();
	                        panel[prey][prex].setBorder(BorderFactory.createEmptyBorder());
	                        panel[y][x].setBorder(BorderFactory.createLineBorder(Color.RED, 4));
	                        initBackground(panel);
	                        paintBackground(canMove,panel);
	                     }
	                  }
	                  
	              }
	               else {   // select==0
	                  //if(turn.MyTurn(state[y][x]/10,survive)){
	                     if(panel[y][x].getImage()!=null) {
	                        select=1;
	                        System.out.printf("말(%d, %d)를 선택하였습니다.\n", x, y); 
	                        panel[prey][prex].setBorder(BorderFactory.createEmptyBorder());
	                        panel[y][x].setBorder(BorderFactory.createLineBorder(Color.RED, 4));
	                        initBackground(panel);
	                        paintBackground(canMove,panel);
	                     }
	                     else {
	                        System.out.printf("위치(%d, %d)를 선택하였습니다.\n", x, y); 
	                     }
	                  }
	                  //else {
	                     //System.out.printf("잘못된 칸을 선택하셨습니다.\n");
	                  //}
	               
		               panel[prey][prex].updateUI();
		               prex=getx();
		               prey=gety();
		               
		               cleanPiece(survive,panel,state);
	                 }
	              
	        };
	        
	        for(int i=0;i<14;i++) {
	             for(int j=0;j<14;j++) {
	                panel[i][j] = new ImagePanel();
	                button[i][j]= new JButton();
	                if(2<i&&i<11||2<j&&j<11) {
	                   if((i%2==0||j%2==0)&&(i%2!=0||j%2!=0)) {
	                      panel[i][j].setBackground(Color.white);
	                      panel[i][j].add(button[i][j]);
	                      button[i][j].setName(String.valueOf(j)+","+String.valueOf(i));
	                      button[i][j].setBackground(Color.white);
	                      button[i][j].setOpaque(false);
	                      button[i][j].addActionListener(move);
	                      panel[i][j].setLayout(new GridLayout(1,1));
	                   }
	                   else {
	                      panel[i][j].setBackground(Color.gray);
	                      panel[i][j].add(button[i][j]);
	                      button[i][j].setName(String.valueOf(j)+","+String.valueOf(i));
	                      button[i][j].setBackground(Color.white);
	                      button[i][j].setOpaque(false);
	                      button[i][j].addActionListener(move);
	                      panel[i][j].setLayout(new GridLayout(1,1));
	                   }
	                   if(i==1) 
	                      panel[i][j].setImage(BlackPawn);
	                   if(i==12) 
	                      panel[i][j].setImage(WhitePawn);
	                   if(j==1)
	                      panel[i][j].setImage(RedPawn);
	                   if(j==12)
	                      panel[i][j].setImage(GreenPawn);
	                }
	                else {
	                   panel[i][j].setBackground(Color.lightGray);
	                }
	                frame.add(panel[i][j]);
	             }
	          }
	          panel[0][3].setImage(BlackRook);
	          panel[0][10].setImage(BlackRook);
	          panel[0][4].setImage(BlackKnight);
	          panel[0][9].setImage(BlackKnight);
	          panel[0][5].setImage(BlackBishop);
	          panel[0][8].setImage(BlackBishop);
	          panel[0][6].setImage(BlackQueen);
	          panel[0][7].setImage(BlackKing);
	          panel[13][3].setImage(WhiteRook);
	          panel[13][10].setImage(WhiteRook);
	          panel[13][4].setImage(WhiteKnight);
	          panel[13][9].setImage(WhiteKnight);
	          panel[13][5].setImage(WhiteBishop);
	          panel[13][8].setImage(WhiteBishop);
	          panel[13][6].setImage(WhiteQueen);
	          panel[13][7].setImage(WhiteKing);
	          panel[3][0].setImage(RedRook);
	          panel[10][0].setImage(RedRook);
	          panel[4][0].setImage(RedKnight);
	          panel[9][0].setImage(RedKnight);
	          panel[5][0].setImage(RedBishop);
	          panel[8][0].setImage(RedBishop);
	          panel[6][0].setImage(RedQueen);
	          panel[7][0].setImage(RedKing);
	          panel[3][13].setImage(GreenRook);
	          panel[10][13].setImage(GreenRook);
	          panel[4][13].setImage(GreenKnight);
	          panel[9][13].setImage(GreenKnight);
	          panel[5][13].setImage(GreenBishop);
	          panel[8][13].setImage(GreenBishop);
	          panel[6][13].setImage(GreenQueen);
	          panel[7][13].setImage(GreenKing);
	       frame.setLayout(new GridLayout(14,14));
	       frame.setVisible(true);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
	   
	   private void paintBackground(int[][] arrange, ImagePanel[][] panel) {
	      for(int i=0;i<panel.length;i++) {
	         for(int j=0;j<panel.length;j++) {
	            if(arrange[i][j]==1) {
	            panel[i][j].setBackground(Color.pink);
	            panel[i][j].updateUI();
	            }
	         }
	      }
	   }
	   
	   private void setDead(int checkmate,boolean[] survive) {
		   if(checkmate!=0) {
			   survive[checkmate-1]=false;
		   }
	   }
	   
	   private void cleanPiece(boolean[] survive ,ImagePanel[][] panel,int[][] state) {
		   int dead;
		   for(int i=0;i<survive.length;i++) {
			   if(survive[i]==false) {
				   dead=i+1;
				   for(int I=0;I<panel.length;I++) {
					   for(int J=0;J<panel.length;J++) {
						   if(state[I][J]/10==dead) {
							   panel[I][J].setImage(null);
							   panel[I][J].updateUI();
						   }
					   }
				   }
			   }
		   }
	   }
	   
	   private void initBackground(ImagePanel[][] panel) {
		   if(panel.length==14) {
			   for(int i=0;i<panel.length;i++) {
			         for(int j=0;j<panel.length;j++) {
			        	 if(2<i&&i<11||2<j&&j<11) {
				            if((i%2==0||j%2==0)&&(i%2!=0||j%2!=0)) {
				                panel[i][j].setBackground(Color.white);
				                panel[i][j].updateUI();
				            }
				            else {
				                panel[i][j].setBackground(Color.gray);
				                panel[i][j].updateUI();
				            }
			        	 }
			         }
			   }
		   }
		   else {
		      for(int i=0;i<panel.length;i++) {
		         for(int j=0;j<panel.length;j++) {
		            if((i%2==0||j%2==0)&&(i%2!=0||j%2!=0)) {
		                panel[i][j].setBackground(Color.white);
		                panel[i][j].updateUI();
		            }
		            else {
		                panel[i][j].setBackground(Color.gray);
		                panel[i][j].updateUI();
		            }
		         }
		      }
	      }
	   }
	   
	   private void setPos(String name) {
	      String[] result=name.split(",");
	      this.x=Integer.valueOf(result[0]);
	      this.y=Integer.valueOf(result[1]);
	   }

	   private int getx() {
	      return x;
	   }
	   private int gety() {
	      return y;
	   }
	}

