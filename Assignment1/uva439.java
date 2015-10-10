package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class uva439 {
	int fx[] = {-1,1,2,2,1,-1,-2,-2};
	int fy[] = {-2,-2,-1,1,2,2,1,-1};
	int m ,n;
	int count;
	int visited[][] = new int[8][8];
	int level[][] = new int[8][8];
	int x,y;
	String output = "";
	c start = new c();
	c end = new c();
	Queue Q = new LinkedList();
	Scanner s = new Scanner(System.in);
	public uva439(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		m = n = 8;
		while(s.hasNext()){
			input();
			run();
			output += String.format("%d knight moves.\n",level[end.x][end.y]);
			//System.out.println(count);
		}
	}
	void run(){
		bfs(start.x,start.y);
	}
	void input(){
		zero();
		String x = s.next();
		String y = s.next();
		output += String.format("To get from %s to %s takes ",x,y);
		start.x = (x.charAt(0) - 'a');
		start.y = (x.charAt(1) - '0' - 1);
		end.x = (y.charAt(0) - 'a');
		end.y = (y.charAt(1) - '0' - 1);
		
	}
	void zero()
	{
		count = 0;
		int i,j;
		for(i=0;i<8;i++)
				for(j=0;j<8;j++)
					visited[i][j] = level[i][j] = 0;
	}
	void bfs(int x,int y)
	{
		if(visited[x][y] == 1)
			return;
		count++;
		c source = new c(x,y);
		Queue q = new LinkedList();
		visited[x][y] = 1;
		level[x][y] = 0;
		q.add(source);
		while(!q.isEmpty())
		{
			c top= (c)q.remove();
			for(int k=0;k<8;k++)
			{
				int tx = top.x+fx[k];
				int ty = top.y+fy[k];
				if(tx>=0&&tx<m&&ty>=0&&ty<n&&visited[tx][ty]==0)
				{
					level[tx][ty] = level[top.x][top.y] + 1;
					visited[tx][ty]=1;
					c temp = new c(tx,ty);
					q.add(temp);
				}
			}
		}
	}
	public String returnOutput(){
		return output;
	}
}
