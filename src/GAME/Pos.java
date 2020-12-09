package GAME;

public class Pos {
	 int x;
	   int y;
	   
	   public Pos(int x, int y) {
	      this.x = x;
	      this.y = y;
	   }
	   
	   public void setX(int x){
	      this.x = x;
	   }
	   
	   public void setY(int y) {
	      this.y = y;
	   }
	   
	   public int getX(){
	      return x;
	   }
	   
	   public int getY(){
	      return y;
	   }
	   
	   public boolean equals(Pos pos) {
	      boolean isit;
	      isit = (pos.getX() == this.getX()) && (pos.getY() == this.getY());
	      return isit;
	   }
}
