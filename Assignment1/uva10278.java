package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class uva10278 {
	int test;
	int fireStation,intersection;
	int Matrix[][];
	int d[];
	boolean isFireStation[];
	boolean first = true;
	String output = "";
	PriorityQueue<Integer> pq;
	
	ArrayList <Integer> fireStations;
	Scanner s = new Scanner(System.in);
	public uva10278(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		test = s.nextInt();
		while(test != 0){
			test--;
			input();
			solve();
		}
	}
	public void solve(){
		pair mainMax = new pair();
		init();
		for(Integer x : fireStations){
			dijkstra(x);
		}
		int temp[] = new int[intersection+1];
		copyArray(temp,d);
		for(int i = 1; i <= intersection; i++){
			if(!isFireStation[i]){
				copyArray(d,temp);
				dijkstra(i);
				int dist = 0;
				for(int j = 1 ; j<= intersection ; j++){
					dist = Math.max(d[j],dist);
				}
				if(i == 1) mainMax = new pair(dist,i);
				else if(mainMax.value > dist){
					mainMax = new pair(dist,i);
				}
				
				
			}
		}
		if(!first){
			System.out.println();
		}
		if(mainMax.index != 10000000)
			output += (mainMax.index) + "\n";
		else
			output += ("1") + "\n";
		first = false;
	}
	public void copyArray(int to[],int from[]){
		for(int i = 0 ; i <= intersection ; i++){
			to[i] = from[i];
		}
	}
	public void init (){
		for(int i = 0 ; i <= intersection ; i++){
			d[i] = 1000000001;
		}
	}
	public void input(){
		pq = new PriorityQueue<Integer>();
		fireStations = new ArrayList<Integer> ();
		fireStation = s.nextInt();
		intersection = s.nextInt();
		d = new int[intersection+1];
		Matrix = new int[intersection+1][intersection+1];
		isFireStation = new boolean[intersection+1];
		for(int i = 0 ; i < fireStation ; i++){
			int x = s.nextInt();
			fireStations.add(x);
			isFireStation[x] = true;
		}
		s.nextLine();
		while(true && s.hasNextLine()){
			String temp = s.nextLine();
			String input[] = temp.split(" ");
			if(input.length != 3) break;
			Matrix[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 
					Integer.parseInt(input[2]);
			Matrix[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 
					Integer.parseInt(input[2]);
		}
	}
	public void dijkstra(int src){
		d[src] = 0;
		pq.add(src);
		while(!pq.isEmpty()){
			int u = pq.remove();
			for(int i = 1 ; i <= intersection ; i++){
				if(Matrix[u][i] != 0)
					relax(u,i,Matrix[u][i]);
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
	class pair{
		public int value,index;
		pair(){
			value = 10000000;
			index = 10000000;
		}
		pair(int x,int y){
			this.value = x;
			this.index = y;
		}
	}
	public String returnOutput(){
		return output;
	}
}
