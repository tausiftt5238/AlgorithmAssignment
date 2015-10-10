package Assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class uva11280_2 {
	int test;
	Scanner s= new Scanner(System.in);
	int index;
	int nodes;
	int edges;
	int matrix[][];
	int d[];
	edge E[];
	int valueAfterIt[][];
	int level[];
	int color[];
	PriorityQueue<Integer> pq;
	HashMap<String, Integer> hm;
	public uva11280_2(){
		test = s.nextInt();
		for(int i = 1 ; i <= test ; i++){
			if(i != 1) System.out.println();
			System.out.printf("Scenario #%d\n",i);
			input();
			dijkstra(0);
			//bellman(hm.get("Calgary"));
			int query;
			query = s.nextInt();
			while(query-- != 0){
				int input = s.nextInt();
				//System.out.println(index + " " + input);
				if(input >= index) input = index-1;
				//System.out.println(index + " " + input);
				if(valueAfterIt[input][hm.get("Fredericton")]!= 100000001)
				System.out.printf("Total cost of flight(s) is $%d\n",valueAfterIt[input][hm.get("Fredericton")]);
				else System.out.printf("No satisfactory flights\n");
			}
		}
	}
	public void input(){
		index = 0;
		hm = new HashMap<String, Integer>();
		nodes = s.nextInt();
		matrix = new int[nodes+10][nodes+10];
		d = new int[1001];
		color = new int[nodes];
		level = new int[nodes];
		pq = new PriorityQueue(1001,new MyCompare());
		for(int i = 0 ; i < nodes ; i++){
			String city = s.next();
			hm.put(city, index++);
			
		}
		for(int i = 0 ; i < 1001 ; i++){
			d[i] = 100000001;
		}
		for(int i = 0 ; i < nodes ; i++){
			for(int j = 0 ; j < nodes ; j++){
				matrix[i][j] = 100000001;
			}
		}
		edges = s.nextInt();
		E = new edge[edges+10];
		valueAfterIt = new int[nodes+10][nodes+10];
		level[hm.get("Calgary")] = 0;
		for(int i = 0 ; i < edges; i ++){
			String x = s.next();
			String y = s.next();
			int weight = s.nextInt();
			level[hm.get(y)] = level[hm.get(x)] + 1;
			if(matrix[hm.get(x)][hm.get(y)] > weight)
				matrix[hm.get(x)][hm.get(y)] = weight;
			E[i] = new edge(hm.get(x), hm.get(y));
			
		}
	}
	private void relax(int u,int v,int w ){
		if(d[v] > d[u] + w){
			d[v] = d[u] + w;
			pq.add(new Integer(v));
		}
	}
	public void dijkstra(int src){
		index = 0;
		d[src] = 0;
		pq.add(new Integer(src));
		while(!pq.isEmpty()){
			int u = pq.remove();
			for(int i = 0 ; i < nodes; i++){
				if(matrix[u][i] != 100000001){
					int temp = matrix[u][i];
					relax(u,i,temp);
				}
				
			}
			valueAfterIt[index++] = d.clone();
		}
	}
	class MyCompare implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return d[o1] - d[o2];
		}
	}
	
}
