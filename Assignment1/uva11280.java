package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class uva11280 {
	int test;
	Scanner s= new Scanner(System.in);
	int index;
	int nodes;
	int edges;
	int matrix[][];
	int d[];
	edge E[];
	int valueAfterIt[];
	int level[];
	int color[];
	String output = "";
	HashMap<String, Integer> hm;
	public uva11280(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		test = s.nextInt();
		for(int i = 1 ; i <= test ; i++){
			if(i != 1) output += "\n";
			output += String.format("Scenario #%d\n",i);
			input();
			bellman(hm.get("Calgary"));
			int query;
			query = s.nextInt();
			while(query-- != 0){
				int input = s.nextInt();
				if(input >= nodes) input = nodes-1;
				if(valueAfterIt[input]!= 100000001)
				output += String.format("Total cost of flight(s) is $%d\n",valueAfterIt[input]);
				else output += ("No satisfactory flights\n");
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
		valueAfterIt = new int[nodes+10];
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
	public boolean bellman(int x){
		d[x] = 0;
		boolean returnValue = true;
		for(int i = 0 ; i < nodes; i++){
			for(int j = nodes - 1 ; j>=0 ; j--){
				for(int k = 0 ; k < nodes ; k++){
					if(matrix[j][k] != 100000001){
						if(d[k] > d[j] + matrix[j][k]){
							d[k] = d[j] + matrix[j][k];
						}
					}
				}
			}
			
			valueAfterIt[i] = d[nodes-1];
		}
		return returnValue;
	}
	public String returnOutput(){
		return output;
	}
}
