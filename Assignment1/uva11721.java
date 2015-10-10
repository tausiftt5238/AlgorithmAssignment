package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class uva11721 {
	int test;
	int n,m;
	int matrix[][];
	edge edges[];
	int d[];
	int parent[];
	int color[];
	ArrayList transposeMatrix[];
	Queue <Integer>runFrom;
	String output = "";
	Scanner s = new Scanner(System.in);
	public uva11721(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		test = s.nextInt();
		for(int cases = 1 ; cases <= test ; cases ++){
			input();
			output += String.format("Case %d:",cases);
			if(bellman()) output += String.format(" impossible");
			else {
				for(int i = 0 ; i < n ; i++){
					if(color[i] == 2) output += String.format(" %d",i);
				}
			}
			output += "\n";
		}
	}
	public void init(){
		for(int i = 0 ; i <= n ; i++){
			transposeMatrix[i] = new ArrayList<Integer>();
		}
	}
	public void input(){
		n = s.nextInt();
		m = s.nextInt();
		matrix = new int[n+1][n+1];
		d = new int[n+1];
		parent = new int[n+1];
		color = new int[n+1];
		transposeMatrix = new ArrayList[n+1];
		runFrom = new LinkedList<Integer>();
		init();
		edges = new edge[m];
		for(int i = 0 ; i < m ;i++){
			int x = s.nextInt();
			int y = s.nextInt();
			int w = s.nextInt();
			matrix[x][y] = w;
			edges[i] = new edge(x,y);
			transposeMatrix[y].add(x);
		}
	}
	public boolean bellman(){
		boolean returnValue = true;
		for(int i = 1 ; i <= n; i++){
			boolean updated = false;
			for(int j = 0 ; j < m ; j++){
				int u = edges[j].y;
				int v = edges[j].x;
				int w = matrix[edges[j].x][edges[j].y];
				if(d[u] + w < d[v]){
					updated = true;
					if(i == n){
						returnValue = false;
						if(color[u] == 0) DFS(u);
					}
					d[v] = w + d[u];
				}
			}
			if(updated == false) break;
		}
		return returnValue;
	}
	private boolean relax(int u,int v,int w ){
		if(d[v] > d[u] + w){
			d[v] = d[u] + w;
			return true;
		}
		return false;
	}
	public void DFS(int src){
		color[src] = 1;
		for(int i = 0 ; i < transposeMatrix[src].size() ; i++){
			if(color[(int) transposeMatrix[src].get(i)] == 0){
				DFS((int) transposeMatrix[src].get(i));
			}
		}
		color[src] = 2;
	}
	public String returnOutput(){
		return output;
	}
	
}
class edge{
	public int x,y;
	edge(){
		x = y = -1;
	}
	edge(int x,int y){ 
		this.x = x; this.y = y;	
	}
}
