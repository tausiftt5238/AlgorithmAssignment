package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class uva12047 {
	int test;
	Scanner s = new Scanner(System.in);
	int N;
	int M;
	int source;
	int destination;
	int limit;
	int matrix[][];
	int transposeMatrix[][];
	int d[];
	int r_d[];
	int inf = 10000001;
	ArrayList <edge> edgeList;
	PriorityQueue <Integer> pq;
	String output = "";
	public uva12047(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		test = s.nextInt();
		while(test -- != 0){
			input();
			dijkstra(source,matrix,true,d);
			dijkstra(destination,transposeMatrix,false,r_d);
			int max = -1;
			int answer = -1;
			for(int i = 0 ; i < edgeList.size(); i++){
				edge tempEdge = edgeList.get(i);
				int x = tempEdge.x;
				int y = tempEdge.y;
				int weight = matrix[x][y];
				if(x != source) weight += d[x];
				if(y != destination) weight += r_d[y];
				if(weight <= limit){
					if(max < weight){
						answer = matrix[x][y];
						max = weight;
					}
				}
			}
			output += (answer) + "\n";
		}
	}
	public void init(){
		for(int i = 0 ; i <= N; i++){
			for(int j = 0 ; j <= N ; j++){
				matrix[i][j] = transposeMatrix[i][j] = -1;
			}
			d[i] = r_d [i] = 10000001;
		}
	}
	public void input(){
		N = s.nextInt();
		M = s.nextInt();
		matrix = new int[N+1][N+1];
		transposeMatrix = new int[N+1][N+1];
		source = s.nextInt();
		destination = s.nextInt();
		limit = s.nextInt();
		edgeList = new ArrayList <edge>();
		d = new int[N+1];
		r_d = new int[N+1];
		init();
		for(int i = 0 ; i < M ; i++){
			int x = s.nextInt();
			int y = s.nextInt();
			int w = s.nextInt();
			matrix[x][y] = w;
			transposeMatrix[y][x] = w;
			edgeList.add(new edge(x,y));
		}
		edgeList.sort(new CompareSort());
	}
	public void dijkstra(int src,int matrix[][],boolean normal,int d[]){
		d[src] = 0;
		if(normal) pq = new PriorityQueue<Integer> (10000,new CompareDijkstra());
		else pq = new PriorityQueue <Integer> (10000, new CompareDijkstraTrans());
		pq.add(src);
		while(!pq.isEmpty()){
			int u = (int) pq.remove();
			for(int i = 1 ; i <= N; i++){
				if(matrix[u][i] != -1){
					relax(u,i,matrix[u][i],d);
				}
				
			}
		}
	}
	private void relax(int u,int v,int w,int d[]){
		if(d[v] > d[u] + w){
			d[v] = d[u] + w;
			pq.add(new Integer(v));
		}
	}
	class CompareSort implements Comparator<edge>{

		@Override
		public int compare(edge x, edge y) {
			return matrix[y.x][y.y] - matrix[x.x][x.y];
		}
		
	}
	class CompareDijkstra implements Comparator <Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return d[o1] - d[o2];
		}
		
	}
	class CompareDijkstraTrans implements Comparator <Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return r_d[o1] - r_d[o2];
		}
		
	}
	public String returnOutput(){
		return output;
	}
}
