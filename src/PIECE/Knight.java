package PIECE;

public class Knight extends Piece implements color {
	   public int[][] pMoves (int[][] state, int y, int x, int color){
	      
	      int arr[][] = new int[8][8];
	      int prey, prex;
	      
	      prey = y;
	      prex = x;
	      
	      //��2��1
	      x = prex+2;
	      y = prey-1;
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      //��2�Ʒ�1
	      x = prex+2;
	      y = prey+1;
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      //��2��1
	      x = prex-2;
	      y = prey-1;
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      //��2�Ʒ�1
	      x = prex-2;
	      y = prey+1;
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      //�Ʒ�2��1
	      x = prex+1;
	      y = prey+2;
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      x = prex-1;
	      y = prey+2;
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      x = prex+1;
	      y = prey-2;
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      x = prex-1;
	      y = prey-2;
	      if(!out(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      
	      return arr;
	      
	   }
	   
	   public int[][] pMoves2 (int[][] state, int y, int x, int color){
	      
	      int arr[][] = new int[14][14];
	      int prey, prex;
	      
	      prey = y;
	      prex = x;
	      
	      //��2��1
	      x = prex+2;
	      y = prey-1;
	      if(!out2(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      //��2�Ʒ�1
	      x = prex+2;
	      y = prey+1;
	      if(!out2(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      //��2��1
	      x = prex-2;
	      y = prey-1;
	      if(!out2(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      //��2�Ʒ�1
	      x = prex-2;
	      y = prey+1;
	      if(!out2(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      //�Ʒ�2��1
	      x = prex+1;
	      y = prey+2;
	      if(!out2(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      x = prex-1;
	      y = prey+2;
	      if(!out2(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      x = prex+1;
	      y = prey-2;
	      if(!out2(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      x = prex-1;
	      y = prey-2;
	      if(!out2(x, y)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) arr[y][x] = 1;
	      }
	      
	      
	      return arr;
	      
	   }
}