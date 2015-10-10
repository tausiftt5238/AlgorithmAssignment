package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class uva532 {
	Scanner s = new Scanner(System.in);
	int L,R,C;
	String[][] field;
	coordinate start,end;
	int level[][][];
	int visited[][][];
	int fx[] = {1,-1,0,0,2,3};
	int fy[] = {0,0,1,-1,2,3};
	String output = "";
	public uva532(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNext()){
			L = s.nextInt();
			R = s.nextInt();
			C = s.nextInt();
			if(L == 0 && R == 0 && C == 0) break;
			
			s.nextLine();
			input();
			init();
			bfs(start.floor,start.x,start.y);
			if(visited[end.floor][end.x][end.y] == 1)
				output += String.format("Escaped in %d minute(s).\n",level[end.floor][end.x][end.y]);
			else 
				output += String.format("Trapped!\n");
		}
	}
	public void init(){
		
	}
	public void input(){
		visited = new int[L][R][C];
		level = new int[L][R][C];
		field = new String[L][R];
		start = end = null;
		for(int i = 0 ; i < L ; i++){
			for(int j = 0 ; j < R; j++){
				field[i][j] = s.next();
				for(int k = 0 ; k < field[i][j].length(); k++){
					if(field[i][j].charAt(k) == 'S') start = new coordinate(j,k,i);
					else if(field[i][j].charAt(k) == 'E') end = new coordinate(j,k,i);
				}
			}
		}
	}
	void bfs(int floor,int x,int y)
	{
		if(visited[floor][x][y] == 1)
			return;
		coordinate source = new coordinate(x,y,floor);
		Queue<coordinate> q = new LinkedList<coordinate>();
		visited[floor][x][y] = 1;
		level[floor][x][y] = 0;
		q.add(source);
		while(!q.isEmpty())
		{
			coordinate top= q.remove();
			for(int k=0;k<6;k++)
			{
				int tx,ty,tfloor;
				if(fx[k] == 2 && fy[k] == 2){
					tx = top.x ; ty = top.y;
					tfloor = top.floor - 1;
				}
				else if(fx[k] == 3 && fy[k] == 3){
					tx = top.x ; ty = top.y;
					tfloor = top.floor + 1;
				}
				else{
					tx = top.x+fx[k];
					ty = top.y+fy[k];
					tfloor = top.floor;
				}
				
				if(tx>=0 && tx <R && ty>=0 && ty<C && tfloor >= 0 && tfloor < L
						&& field[tfloor][tx].charAt(ty) !='#' 
						&& visited[tfloor][tx][ty]==0){
					visited[tfloor][tx][ty] = 1;
					level[tfloor][tx][ty] = level[top.floor][top.x][top.y] + 1;
					coordinate temp = new coordinate(tx,ty,tfloor);
					q.add(temp);
				}
			}
		}
	}
	class coordinate{
		public int x,y;
		public int floor;
		public coordinate(){
			x = y = floor = -1;
		}
		public coordinate(int x,int y,int floor){
			this.x = x;
			this.y = y;
			this.floor = floor;
		}
	}
	public String returnOutput(){
		return output;
	}
}
