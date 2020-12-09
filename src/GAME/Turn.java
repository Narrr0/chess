package GAME;

public class Turn {
	   int i=1;
	   public int turnColor=1;
	   boolean isMyTurn=true;
	   private int[] rotate;
	 
	   public Turn(int[] array) {
	      this.rotate = array;
	   }

	   public boolean MyTurn(int color,boolean[] survive) {
		 
		  Rotate(isMyTurn, survive);
		  
	      if (turnColor == color)
	         isMyTurn = true;
	      else
	         isMyTurn = false;
	      return isMyTurn;
	   }

	   public void Rotate(boolean isMyTurn, boolean[] survive) {
	      //try {
	         if(rotate.length == 4) {
	            while (isMyTurn) {
	               i++;
	               if (i > 4)
	                  i = i - 4;
	               if (survive[i]) {
	                  turnColor = rotate[i];
	                  break;
	               }
	            }
	         }
	         else if(rotate.length == 2) {
	            while (isMyTurn) {
	            	i++;
	            	if(i>1) {
	            		i=0;
	            	}
	               if (survive[i]) {
	                  turnColor = rotate[i];
	                  break;
	               }
	            }
	         }
	   }

}
