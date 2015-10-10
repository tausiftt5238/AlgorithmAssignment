package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class uva11770 {
	int test;
	int n,m;
	ArrayList adjList[];
	ArrayList transposeList[];
	int color[];
	int d[];
	int f[];
	int count;
	int time;
	Stack<Integer> stack;
	String output = "";
	Scanner s = new Scanner(System.in);
	public uva11770(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		test = s.nextInt();
		for(int i = 1; i <= test ; i++){
			input();
			output += String.format("Case %d: ",i);
			SCC();
		}
		
	}
	public void init(){
		n = s.nextInt();
		m = s.nextInt();
		adjList = new ArrayList[n+1];
		transposeList = new ArrayList[n+1];
		color = new int[n+1];
		d = new int[n+1];
		f = new int[n+1];
		stack = new Stack<Integer>();
		count = time = 0;
	}
	public void input(){
		init();
		for(int i = 0 ; i <= n ; i++){
			adjList[i] = new ArrayList();
			transposeList[i] = new ArrayList();
		}
		for(int i = 0 ; i < m ; i++){
			int x = s.nextInt();
			int y = s.nextInt();
			adjList[x].add(y);
			transposeList[y].add(x);
		}
	}
	public void SCC(){
		for(int i = 1 ; i <= n ; i++){
			if(color[i] == 0){
				DFS(i,adjList);
				//count++;
			}
		}
		zero();
		while(!stack.isEmpty()){
			int x = stack.pop();
			if(color[x] == 0){
				DFS(x,adjList);
				count++;
			}
		}
		output += (count) + "\n";
		
	}
	public void DFS(int src, ArrayList list[]){
		color[src] = 1;
        time++;
        for(int i = 0 ; i < list[src].size() ; i++){
        	int v = (int) list[src].get(i);
        	if(color[v] == 0){	
                DFS(v,list);
            }
        }
        color[src] = 2;
        time++;
        f[src] = time;
        stack.push(src);
	}
	public void zero(){
		for(int i = 0 ; i <= n ; i++){
			color[i] = 0;
		}
	}
	public String returnOutput(){
		return output;
	}
}
