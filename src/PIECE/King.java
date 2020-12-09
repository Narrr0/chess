package PIECE;
import GAME.CheckStatus;

public class King extends Piece implements color{
    
    public int[][] pMoves(int[][] state, int y, int x, int color, int[][] opponent_Arr){
         int arr[][] = new int [8][8];
         int prey = y, prex = x;
         
         //킹의 위 : 한칸만 가능
         y=prey;
         x=prex-1;
         if(!out(y,x)) {
            if(hPiece(state, y, x)==0) arr[y][x]=1;
            else if(enemy(state, prey, prex, y, x)==1) {
               arr[y][x]=1;
            }
         }
         //킹의 아래
         y=prey;
         x=prex+1;
         if(!out(y,x)) {
            if(hPiece(state, y, x)==0) arr[y][x]=1;
            else if(enemy(state, prey, prex, y, x)==1) {
               arr[y][x]=1;
            }
         }
         //킹의 오른쪽
         y=prey+1;
         x=prex;
         if(!out(y,x)) {
            if(hPiece(state, y, x)==0) arr[y][x]=1;
            else if(enemy(state, prey, prex, y, x)==1) {
               arr[y][x]=1;
            }
         }
         //킹의 왼쪽
         y=prey-1;
         x=prex;
         if(!out(y,x)) {
            if(hPiece(state, y, x)==0) arr[y][x]=1;
            else if(enemy(state, prey, prex, y, x)==1) {
               arr[y][x]=1;
            }
         }
         //킹의 오른 대각선 위
         y=prey+1;
         x=prex-1;
         if(!out(y,x)) {
            if(hPiece(state, y, x)==0)arr[y][x]=1;
            else if(enemy(state, prey, prex, y,x)==1)arr[y][x]=1;
         }
         //킹의 왼 대각선 위
         y=prey-1;
         x=prex-1;
         if(!out(y,x)) {
            if(hPiece(state, y, x)==0)arr[y][x]=1;
            else if(enemy(state, prey, prex, y,x)==1)arr[y][x]=1;
         }
         //킹의 왼 대각선 아래
         y=prey-1;
         x=prex+1;
         if(!out(y,x)) {
            if(hPiece(state, y, x)==0)arr[y][x]=1;
            else if(enemy(state, prey, prex, y,x)==1)arr[y][x]=1;
         }
         //킹의 오른 대각선 아래
         y=prey+1;
         x=prex+1;
         if(!out(y,x)) {
            if(hPiece(state, y, x)==0)arr[y][x]=1;
            else if(enemy(state, prey, prex, y,x)==1)arr[y][x]=1;
         }
         
         CheckStatus king_way_check = new CheckStatus();
         int[][] checked_arr = king_way_check.king_self_check(arr, opponent_Arr);//자살 방지 메서드
         
         return checked_arr;
      }
    
    public int[][] pMoves2(int[][] state, int y, int x, int color, int[][] opponent_Arr){
         int arr[][] = new int [14][14];
         int prey = y, prex = x;
         
         //킹의 위 : 한칸만 가능
         y=prey;
         x=prex-1;
         if(!out2(y,x)) {
            if(hPiece(state, y, x)==0) arr[y][x]=1;
            else if(enemy2(state, prey, prex, y, x)==1) {
               arr[y][x]=1;
            }
         }
         //킹의 아래
         y=prey;
         x=prex+1;
         if(!out2(y,x)) {
            if(hPiece(state, y, x)==0) arr[y][x]=1;
            else if(enemy2(state, prey, prex, y, x)==1) {
               arr[y][x]=1;
            }
         }
         //킹의 오른쪽
         y=prey+1;
         x=prex;
         if(!out2(y,x)) {
            if(hPiece(state, y, x)==0) arr[y][x]=1;
            else if(enemy2(state, prey, prex, y, x)==1) {
               arr[y][x]=1;
            }
         }
         //킹의 왼쪽
         y=prey-1;
         x=prex;
         if(!out2(y,x)) {
            if(hPiece(state, y, x)==0) arr[y][x]=1;
            else if(enemy2(state, prey, prex, y, x)==1) {
               arr[y][x]=1;
            }
         }
         //킹의 오른 대각선 위
         y=prey+1;
         x=prex-1;
         if(!out2(y,x)) {
            if(hPiece(state, y, x)==0)arr[y][x]=1;
            else if(enemy2(state, prey, prex, y,x)==1)arr[y][x]=1;
         }
         //킹의 왼 대각선 위
         y=prey-1;
         x=prex-1;
         if(!out2(y,x)) {
            if(hPiece(state, y, x)==0)arr[y][x]=1;
            else if(enemy2(state, prey, prex, y,x)==1)arr[y][x]=1;
         }
         //킹의 왼 대각선 아래
         y=prey-1;
         x=prex+1;
         if(!out2(y,x)) {
            if(hPiece(state, y, x)==0)arr[y][x]=1;
            else if(enemy2(state, prey, prex, y,x)==1)arr[y][x]=1;
         }
         //킹의 오른 대각선 아래
         y=prey+1;
         x=prex+1;
         if(!out2(y,x)) {
            if(hPiece(state, y, x)==0)arr[y][x]=1;
            else if(enemy2(state, prey, prex, y,x)==1)arr[y][x]=1;
         }
         
         CheckStatus king_way_check = new CheckStatus();
         int[][] checked_arr = king_way_check.king_self_check2(arr, opponent_Arr);//자살 방지 메서드
         
         return checked_arr;
      }
    
    public int[] pAttackfrom(int y, int x, int state[][]){
       int i, cntarr = 1;
       int[] attack = new int[21];
       int prey, prex;
       
       prey=y;
       prex=x;
       
       //가로세로-룩, 퀸
       for(i=prey+1 ; i<8 ; i++) {
          if(hPiece(state, i,prex) == 1 && enemy(state, prey, prex, i, prex) == 0) break;
          else if(hPiece(state, i,prex) == 0) continue;
          else if(enemy(state, prey, prex, i, prex) == 1 && (state[i][prex]%10 == 5 || state[i][prex]%10 == 3)){
             attack[cntarr] = i; attack[cntarr+1] = prex;
             cntarr += 2;
          }
          else break;
       }
       
       for(i=prey-1 ; i>=0 ; i--) {
          if(hPiece(state, i,prex) == 1 && enemy(state, prey, prex, i, prex) == 0) break;
          else if(hPiece(state, i,prex) == 0) continue;
          else if(enemy(state, prey, prex, i, prex) == 1 && (state[i][prex]%10 == 5 || state[i][prex]%10 == 3)){
             attack[cntarr] = i; attack[cntarr+1] = prex;
             cntarr += 2;
          }
          else break;
       }
       
       for(i=prex+1 ; i<8 ; i++) {
          if(hPiece(state, prey, i) == 1 && enemy(state, prey, prex, prey, i) == 0) break;
          else if(hPiece(state, prey, i) == 0) continue;
          else if(enemy(state, prey, prex, prey, i) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 3)){
             attack[cntarr] = prey; attack[cntarr+1] = i;
             cntarr += 2;
          }
          else break;
       }
       
       for(i=prex-1 ; i>=0 ; i--) {
          if(hPiece(state, prey, i) == 1 && enemy(state, prey, prex, prey, i) == 0) break;
          else if(hPiece(state, prey, i) == 0) continue;
          else if(enemy(state, prey, prex, prey, i) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 3)){
             attack[cntarr] = prey; attack[cntarr+1] = i;
             cntarr += 2;
             break;
          }
          else break;
       }
       
       //대각선-비숍, 퀸
      x = prex+1;
      y = prey-1;
      while(!out(y, x)) {
         if(hPiece(state, y, x) == 1 && enemy(state, prey, prex, y, x) == 0) break;
         else if(hPiece(state, y, x) == 0) continue;
         else if(enemy(state, prey, prex, y, x) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 4)){
            attack[cntarr] = y; attack[cntarr+1] = x;
            cntarr += 2;
            break;
         }
         
         x++;
         y--;
      }
      
      x = prex+1;
      y = prey+1;
      while(!out(y, x)) {
         if(hPiece(state, y, x) == 1 && enemy(state, prey, prex, y, x) == 0) break;
         else if(hPiece(state, y, x) == 0) continue;
         else if(enemy(state, prey, prex, y, x) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 4)){
            attack[cntarr] = y; attack[cntarr+1] = x;
            cntarr += 2;
            break;
         }
         
         x++;
         y++;
      }
      
      x = prex-1;
      y = prey-1;
      while(!out(y, x)) {
         if(hPiece(state, y, x) == 1 && enemy(state, prey, prex, y, x) == 0) break;
         else if(hPiece(state, y, x) == 0) continue;
         else if(enemy(state, prey, prex, y, x) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 4)){
            attack[cntarr] = y; attack[cntarr+1] = x;
            cntarr += 2;
            break;
         }
         
         x--;
         y--;
      }
      
      x = prex-1;
      y = prey+1;
      while(!out(y, x)) {
         if(hPiece(state, y, x) == 1 && enemy(state, prey, prex, y, x) == 0) break;
         else if(hPiece(state, y, x) == 0) continue;
         else if(enemy(state, prey, prex, y, x) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 4)){
            attack[cntarr] = y; attack[cntarr+1] = x;
            cntarr += 2;
            break;
         }
         
         x--;
         y++;
      }
      
      //나이트
      int knightx[]={prex+1,prex+1,prex+2,prex+2,prex-1,prex-1,prex-2,prex-2};
      int knighty[]={prey-2,prey+2,prey-1,prey+1,prey-2,prey+2,prey-1,prey+1};
      
      for(i=0 ; i<8 ; i++) {
         if(enemy(state, prey, prex, knighty[i], knightx[i]) == 1 && state[knighty[i]][knightx[i]]%10 == 2) {
            attack[cntarr] = knighty[i]; attack[cntarr+1] = knightx[i];
            cntarr += 2;
         }
      }
      
      //폰
      if(state[prey][prex]/10 == white) {
         y = prey+1;
         x = prex;
         if(enemy(state, prey, prex, y, x+1) == 1 && state[y][x+1]%10 == 1) {
            attack[cntarr] = y; attack[cntarr+1] = x+1;
            cntarr += 2;
         }
         else if(enemy(state, prey, prex, y, x-1) == 1 && state[y][x+1]%10 == 1) {
            attack[cntarr] = y; attack[cntarr+1] = x-1;
            cntarr += 2;
         }
      }
      
      else if(state[prey][prex]/10 == black) {
         y = prey-1;
         x = prex;
         if(enemy(state, prey, prex, y, x+1) == 1 && state[y][x+1]%10 == 1) {
            attack[cntarr] = y; attack[cntarr+1] = x+1;
            cntarr += 2;
         }
         else if(enemy(state, prey, prex, y, x-1) == 1 && state[y][x+1]%10 == 1) {
            attack[cntarr] = y; attack[cntarr+1] = x-1;
            cntarr += 2;
         }
      }
      
      attack[0] = cntarr;
       
      return attack;
    }

    
    public int[] pAttackfrom2(int y, int x, int state[][]){
       int i, cntarr = 1;
       int[] attack = new int[21];
       int prey, prex;
       
       prey=y;
       prex=x;
       
       //가로세로-룩, 퀸
       for(i=prey+1 ; i<14 ; i++) {
          if(!out2(i, prex)) break;
          else if(hPiece(state, i, prex) == 1 && enemy2(state, prey, prex, i, prex) == 0) break;
          else if(hPiece(state, i,prex) == 0) continue;
          else if(enemy2(state, prey, prex, i, prex) == 1 && (state[i][prex]%10 == 5 || state[i][prex]%10 == 3)){
             attack[cntarr] = i; attack[cntarr+1] = prex;
             cntarr += 2;
          }
          else break;
       }
       
       for(i=prey-1 ; i>=0 ; i--) {
          if(!out2(i, prex)) break;
          else if(hPiece(state, i,prex) == 1 && enemy2(state, prey, prex, i, prex) == 0) break;
          else if(hPiece(state, i,prex) == 0) continue;
          else if(enemy2(state, prey, prex, i, prex) == 1 && (state[i][prex]%10 == 5 || state[i][prex]%10 == 3)){
             attack[cntarr] = i; attack[cntarr+1] = prex;
             cntarr += 2;
          }
          else break;
       }
       
       for(i=prex+1 ; i<14 ; i++) {
          if(!out2(i, prey)) break;
          else if(hPiece(state, prey, i) == 1 && enemy2(state, prey, prex, prey, i) == 0) break;
          else if(hPiece(state, prey, i) == 0) continue;
          else if(enemy2(state, prey, prex, prey, i) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 3)){
             attack[cntarr] = prey; attack[cntarr+1] = i;
             cntarr += 2;
          }
          else break;
       }
       
       for(i=prex-1 ; i>=0 ; i--) {
          if(!out2(i, prey)) break;
          else if(hPiece(state, prey, i) == 1 && enemy2(state, prey, prex, prey, i) == 0) break;
          else if(hPiece(state, prey, i) == 0) continue;
          else if(enemy2(state, prey, prex, prey, i) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 3)){
             attack[cntarr] = prey; attack[cntarr+1] = i;
             cntarr += 2;
             break;
          }
          else break;
       }
       
       //대각선-비숍, 퀸
      x = prex+1;
      y = prey-1;
      while(!out2(y, x)) {
         if(hPiece(state, y, x) == 1 && enemy2(state, prey, prex, y, x) == 0) break;
         else if(hPiece(state, y, x) == 0) continue;
         else if(enemy2(state, prey, prex, y, x) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 4)){
            attack[cntarr] = y; attack[cntarr+1] = x;
            cntarr += 2;
            break;
         }
         
         x++;
         y--;
      }
      
      x = prex+1;
      y = prey+1;
      while(!out2(y, x)) {
         if(hPiece(state, y, x) == 1 && enemy2(state, prey, prex, y, x) == 0) break;
         else if(hPiece(state, y, x) == 0) continue;
         else if(enemy2(state, prey, prex, y, x) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 4)){
            attack[cntarr] = y; attack[cntarr+1] = x;
            cntarr += 2;
            break;
         }
         
         x++;
         y++;
      }
      
      x = prex-1;
      y = prey-1;
      while(!out2(y, x)) {
         if(hPiece(state, y, x) == 1 && enemy2(state, prey, prex, y, x) == 0) break;
         else if(hPiece(state, y, x) == 0) continue;
         else if(enemy2(state, prey, prex, y, x) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 4)){
            attack[cntarr] = y; attack[cntarr+1] = x;
            cntarr += 2;
            break;
         }
         
         x--;
         y--;
      }
      
      x = prex-1;
      y = prey+1;
      while(!out2(y, x)) {
         if(hPiece(state, y, x) == 1 && enemy2(state, prey, prex, y, x) == 0) break;
         else if(hPiece(state, y, x) == 0) continue;
         else if(enemy2(state, prey, prex, y, x) == 1 && (state[prey][i]%10 == 5 || state[prey][i]%10 == 4)){
            attack[cntarr] = y; attack[cntarr+1] = x;
            cntarr += 2;
            break;
         }
         
         x--;
         y++;
      }
      
      //나이트
      int knightx[]={prex+1,prex+1,prex+2,prex+2,prex-1,prex-1,prex-2,prex-2};
      int knighty[]={prey-2,prey+2,prey-1,prey+1,prey-2,prey+2,prey-1,prey+1};
      
      for(i=0 ; i<8 ; i++) {
         if(enemy2(state, prey, prex, knighty[i], knightx[i]) == 1 && state[knighty[i]][knightx[i]]%10 == 2) {
            attack[cntarr] = knighty[i]; attack[cntarr+1] = knightx[i];
            cntarr += 2;
         }
      }
      
      //폰
      if(state[prey][prex]/10 == white) {
         y = prey+1;
         x = prex;
         if(enemy2(state, prey, prex, y, x+1) == 1 && state[y][x+1]%10 == 1) {
            attack[cntarr] = y; attack[cntarr+1] = x+1;
            cntarr += 2;
         }
         else if(enemy2(state, prey, prex, y, x-1) == 1 && state[y][x+1]%10 == 1) {
            attack[cntarr] = y; attack[cntarr+1] = x-1;
            cntarr += 2;
         }
      }
      
      else if(state[prey][prex]/10 == black) {
         y = prey-1;
         x = prex;
         if(enemy2(state, prey, prex, y, x+1) == 1 && state[y][x+1]%10 == 1) {
            attack[cntarr] = y; attack[cntarr+1] = x+1;
            cntarr += 2;
         }
         else if(enemy(state, prey, prex, y, x-1) == 1 && state[y][x+1]%10 == 1) {
            attack[cntarr] = y; attack[cntarr+1] = x-1;
            cntarr += 2;
         }
      }
      
      else if(state[prey][prex]/10 == red) {
         y = prey;
         x = prex+1;
         if(enemy2(state, prey, prex, y+1, x) == 1 && state[y+1][x]%10 == 1) {
            attack[cntarr] = y+1; attack[cntarr+1] = x;
            cntarr += 2;
         }
         else if(enemy2(state, prey, prex, y-1, x) == 1 && state[y-1][x]%10 == 1) {
            attack[cntarr] = y-1; attack[cntarr+1] = x;
            cntarr += 2;
         }
      }
      
      else if(state[prey][prex]/10 == green) {
         y = prey;
         x = prex-1;
         if(enemy2(state, prey, prex, y+1, x) == 1 && state[y+1][x]%10 == 1) {
            attack[cntarr] = y+1; attack[cntarr+1] = x;
            cntarr += 2;
         }
         else if(enemy2(state, prey, prex, y-1, x) == 1 && state[y-1][x]%10 == 1) {
            attack[cntarr] = y-1; attack[cntarr+1] = x;
            cntarr += 2;
         }
      }
      
      attack[0] = cntarr;
       
      return attack;
    }
    
}