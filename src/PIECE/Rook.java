package PIECE;

public class Rook extends Piece implements color {
	   
	   public int[][] pMoves (int[][] state, int y, int x, int color){
	      int arr[][] = new int[8][8];
	      int prey, prex;
	      
	      prey = y;
	      prex = x;
	      
	      //��
	      y = prey-1;
	      while(!out(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         y--;
	      }
	      
	      //�Ʒ�
	      y=prey+1;
	      while(!out(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         y++;
	      }
	      
	      //������
	      x = prex+1;
	      y = prey;
	      while(!out(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x++;
	      }
	      
	      //����
	      x = prex-1;
	      while(!out(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x--;
	      }
	      
	      return arr;
	      
	   }
	   
	   
	   public int[][] pMoves2 (int[][] state, int y, int x, int color){
	      int arr[][] = new int[14][14];
	      int prey, prex;
	      
	      prey = y;
	      prex = x;
	      
	      //��
	      y = prey-1;
	      while(!out2(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         y--;
	      }
	      
	      //�Ʒ�
	      y=prey+1;
	      while(!out2(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         y++;
	      }
	      
	      //������
	      x = prex+1;
	      y = prey;
	      while(!out2(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x++;
	      }
	      
	      //����
	      x = prex-1;
	      while(!out2(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x--;
	      }
	      
	      return arr;
	      
	   }

}