package PIECE;

public class Bishop extends Piece implements color {
	   
	   public int[][] pMoves (int[][] state, int y, int x, int color){
	      
	      int arr[][] = new int[8][8];
	      int prey, prex;
	      
	      prey = y;
	      prex = x;
	      
	      //오른쪽위
	      x = prex+1;
	      y = prey-1;
	      while(!out(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x++;
	         y--;
	      }
	      
	      //왼쪽 위
	      x = prex-1;
	      y = prey-1;
	      while(!out(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x--;
	         y--;
	      }
	      
	      //오른쪽 아래
	      
	      x = prex+1;
	      y = prey+1;
	      while(!out(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x++;
	         y++;
	      }
	      
	      //왼쪽 아래
	      x = prex-1;
	      y = prey+1;
	      System.out.printf("%d %d", x, y);
	      System.out.println();
	      while(!out(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x--;
	         y++;
	      }
	      
	      return arr;
	      
	   }
	   
	public int[][] pMoves2 (int[][] state, int y, int x, int color){
	      
	      int arr[][] = new int[14][14];
	      int prey, prex;
	      
	      prey = y;
	      prex = x;
	      
	      //오른쪽위
	      x = prex+1;
	      y = prey-1;
	      while(!out2(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x++;
	         y--;
	      }
	      
	      //왼쪽 위
	      x = prex-1;
	      y = prey-1;
	      while(!out2(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x--;
	         y--;
	      }
	      
	      //오른쪽 아래
	      
	      x = prex+1;
	      y = prey+1;
	      while(!out2(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x++;
	         y++;
	      }
	      
	      //왼쪽 아래
	      x = prex-1;
	      y = prey+1;
	      while(!out2(y, x)) {
	         if(hPiece(state, y, x) == 0) arr[y][x] = 1;
	         else if(enemy2(state, prey, prex, y, x) == 1) {
	            arr[y][x] = 1;
	            break;
	         }
	         else break;
	         
	         x--;
	         y++;
	      }
	      
	      return arr;
	      
	   }
}
