package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class uva10305 {
	int n,m;
	boolean adjMatrix[][];
	int color[];
	Stack stack;
	String output = "";
	Scanner s = new Scanner(System.in);
	public uva10305(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNextInt()){
			n = s.nextInt();
			m = s.nextInt();
			if(n == 0 && m == 0) break;
			adjMatrix = new boolean[n+1][n+1];
			color = new int[n+1];
			stack = new Stack();
			input();
			for(int i = 1 ; i <= n ; i++){
				if(color[i] == 0) DFS(i);
			}
			output();
		}
	}
	public void output(){
		output += stack.pop();
		while(!stack.isEmpty()){
			output += " " + stack.pop();
		}
		output += String.format("\n");
	}
	public void input(){
		for(int i = 0 ; i < m ; i ++){
			int x = s.nextInt();
			int y = s.nextInt();
			adjMatrix[x][y] = true;
		}
	}
	
	public void DFS(int src){
		color[src] = 1;
		for(int i = 1 ; i <= n ; i++){
			if(adjMatrix[src][i]){
				if(color[i] == 0){
					DFS(i);
					
				}
			}
		}
		color[src] = 2;
		stack.push(src);
	}
	public String returnOutput() {
		return output;
	}
}

