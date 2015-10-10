package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class uva721 {
	int test;
	int P,Q;
	int adjMatrix[][];
	ArrayList adjList[];
	ArrayList transAdjList[];
	int d[];
	PriorityQueue<Integer> pq;
	int weight;
	String output = "";
	Scanner s = new Scanner(System.in);
	public uva721(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		test = s.nextInt();
		while(test-- != 0){
			input();
			weight = 0;
			pq = new PriorityQueue<Integer>(P+1,new MyCompare());
			init();
			dijkstra(1,adjList);
			for(int j = 2 ; j <= P ; j++){
				weight += d[j];
				
			}
			init();
			dijkstra(1,transAdjList);
			for(int j = 2 ; j <= P ; j++){
				weight += d[j];
				
			}
			output += weight + "\n";
		}
	}
	public void init(){
		for(int i = 1 ; i <= P ; i++){
			d[i] = 1000000001;
		}
	}
	public void input(){
		
		P = s.nextInt();
		Q = s.nextInt();
		
		adjList = new ArrayList[P+1];
		transAdjList = new ArrayList[P+1];
		
		d = new int[P+1];
		
		for(int i = 0 ; i < Q ; i ++){
			int u = s.nextInt();
			int v = s.nextInt();
			int w = s.nextInt();
			//adjMatrix[u][v] = w;
			if(adjList[u] == null){
				adjList[u] = new ArrayList();
			}
			if(transAdjList[v] == null){
				transAdjList[v] = new ArrayList();
				
			}
			adjList[u].add(new pair(v,w));
			transAdjList[v].add(new pair(u,w));
		}
	}
	private void relax(int u,int v,int w ){
		if(d[v] > d[u] + w){
			d[v] = d[u] + w;
			pq.add(new Integer(v));
		}
	}
	public void dijkstra(int src,ArrayList adjList[]){
		d[src] = 0;
		pq.add(new Integer(src));
		while(!pq.isEmpty()){
			int u = (int) pq.remove();
			for(int i = 0 ; i < adjList[u].size(); i++){
				pair temp = (pair) adjList[u].get(i);
				relax(u,temp.v,temp.w);
			}
		}
	}
	class MyCompare implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return d[o1] - d[o2];
		}
		
	}
	public String returnOutput(){
		return output;
	}
}

class pair{
	public int v,w;
	public pair(int v,int w){
		this.v = v;
		this.w = w;
	}
}
