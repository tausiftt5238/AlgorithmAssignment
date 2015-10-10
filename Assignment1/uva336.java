package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class uva336 {
	Scanner s = new Scanner(System.in);
	HashMap <String , ArrayList<String> > hm;
	HashMap <String , Integer> color;
	HashMap <String, Integer> level;
	int count;
	int numberOfInput;
	int caseNumber;
	String output = "";
	public uva336(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		hm = new HashMap <String , ArrayList<String> > ();
		color = new HashMap <String , Integer>();
		level = new HashMap <String , Integer>();
		caseNumber = 1;
		while(s.hasNextInt()){
			numberOfInput = s.nextInt();
			if(numberOfInput == 0) break;
			hm.clear();
			input();
			query();
		}
	}
	void resetColor(){
		color.clear();
		level.clear();
		for(String key : hm.keySet()){
			color.put(key,0);
			level.put(key, 1000);
		}
	}
	void query(){
		while(true){
			String q = s.next();
			int TTL = s.nextInt();
			if(q.equals("0") && TTL == 0) break;
			resetColor();
			BFS(q);
			count = 0;
			for(String key: level.keySet()){
				if(level.get(key).intValue() > TTL) count++;
			}
			output += String.format("Case %d: %d nodes not reachable from node %s with TTL = %d.\n",caseNumber++,count,q,TTL);
			//output += System.getProperty("line.separator");
			//System.out.printf("Case %d: %d nodes not reachable from node %s with TTL = %d.\n",caseNumber++,count,q,TTL);
		}
	}
	void BFS(String src){
		color.put(src,1);
		level.put(src, 0);
		Queue q = new LinkedList();
		q.add(src);
		while(!q.isEmpty()){
			String u = (String) q.remove();
			List <String> l = hm.get(u);
			for(String v : l){
				if(color.get(v).intValue() == 0){
					color.put(v, 2);
					level.put(v, level.get(u).intValue() + 1);
					q.add(v);
				}
			}
			color.put(u, 2);
		}
	}
	
	void input(){
		for(int i = 0 ; i < numberOfInput ; i++){
			String x = s.next();
			String y = s.next();
			if(!hm.containsKey(x))hm.put(x, new ArrayList<String> ());
			if(!hm.containsKey(y))hm.put(y, new ArrayList<String> ());
			List <String> l = hm.get(x);
			l.add(y);
			l = hm.get(y);
			l.add(x);
		}
	}
	void DFS(String src,int TTL){
		if(TTL == -1) return;
		color.put(src, 1);
		List <String> l = hm.get(src);
		for(String next : l){
			if(color.get(next).intValue() == 0){
				DFS(next,TTL-1);
			}
		}
		color.put(src, 2);
	}
	public String returnOutput(){
		return output;
	}
}