package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class uva423 {
	int adjMatrix[][];
	int n;
	int d[];
	PriorityQueue<Integer> pq;
	String output = "";
	Scanner s = new Scanner(System.in);
	public uva423(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		input();
		//test();
		init();
		dijkstra(0);
		int weight = 0;
		for(int i = 0 ; i < n ; i++){
			if(i == 0) weight = d[i];
			else if(weight < d[i]) weight = d[i];
		}
		output += (weight) + "\n";
	}
	public void init (){
		for(int i = 0 ; i < n ; i++){
			d[i] = 1000000001;
		}
	}
	public void dijkstra(int src){
		d[src] = 0;
		pq.add(src);
		while(!pq.isEmpty()){
			int u = pq.remove();
			for(int i = 0 ; i < n ; i++){
				if(adjMatrix[u][i] != 0)
					relax(u,i,adjMatrix[u][i]);
			}
		}
	}
	public void input(){
		n = s.nextInt();
		d = new int[n];
		adjMatrix = new int[n][n];
		pq = new PriorityQueue<Integer>();
		for(int i = 1; i < n ; i++){
			for(int j = 0 ; j < i ; j++){
				String W = s.next();
				if(W.equals("x")) adjMatrix[i][j] = adjMatrix[j][i] = 1000000001;
				else
					adjMatrix[i][j] = adjMatrix[j][i] = Integer.parseInt(W);
			}
		}
	}
	private void relax(int u,int v,int w ){
		if(d[v] > d[u] + w){
			d[v] = d[u] + w;
			pq.add(new Integer(v));
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
