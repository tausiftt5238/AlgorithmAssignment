package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class uva572 {
	String output = "";
	int fx[] = {1,-1,0,0,-1,1,1,-1};
	int fy[] = {0,0,1,-1,-1,1,-1,1};
	int m,n;
	int count;
	int visited[][] = new int[101][101];
	char pos[][] = new char[101][101];
	int x,y;
	
	Queue Q = new LinkedList();
	Scanner s = new Scanner(System.in);
	public uva572(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNext()){
			m = s.nextInt();
			n = s.nextInt();
			if( m == 0) break;
			s.nextLine();
			input();
			run();
			output += count + "\n";
		}
	}
	void run(){
		while(!Q.isEmpty()){
			c temp = (c)Q.remove();
			bfs(temp.x,temp.y);
		}
	}
	void input(){
		zero();
		int i,j;
		for(i = 0 ; i < m ; i++){
			String str = s.nextLine();
			for(j = 0; j < n; j++){
				pos[i][j] = str.charAt(j);
				if(pos[i][j] == '@'){
					c check = new c();
					check.x = i;
					check.y = j;
					Q.add(check);
				}
			}
			pos[i][j] = 0;
		}
	}
	void zero()
	{
		count = 0;
		int i,j;
		for(i=0;i<101;i++)
				for(j=0;j<101;j++)
					visited[i][j] = pos[i][j] = 0;
	}
	void bfs(int x,int y)
	{
		if(visited[x][y] == 1)
			return;
		count++;
		c source = new c(x,y);
		Queue q = new LinkedList();
		visited[x][y] = 1;
		q.add(source);
		while(!q.isEmpty())
		{
			c top= (c)q.remove();
			for(int k=0;k<8;k++)
			{
				int tx = top.x+fx[k];
				int ty = top.y+fy[k];
				if(tx>=0&&tx<m&&ty>=0&&ty<n&&pos[tx][ty]=='@'&&visited[tx][ty]==0)
				{
					visited[tx][ty]=1;
					c temp = new c(tx,ty);
					q.add(temp);
				}
			}
		}
	}
	public String returnOutput() {
		return output;
	}
}
class c{
	public int x;
	public int y;
	public c(){
		x = y = 0;
	}
	public c(int x,int y){
		this.x = x ;
		this.y = y;
	}
}