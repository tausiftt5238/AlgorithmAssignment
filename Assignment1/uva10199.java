package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class uva10199 {
	Scanner s = new Scanner(System.in);
	HashMap <String , ArrayList<String> > hm;
	HashMap <String , Integer> color;
	HashMap <String, Integer> low;
	HashMap <String, Integer> numberOfChild;
	HashMap <String, Boolean> ranAsRoot;
	HashMap <String, Integer> d;
	HashMap <String, Integer> f;
	HashMap<String, String> parent;
	HashMap<String , Boolean> alreadyAnArticulationPoint;
	PriorityQueue <String> pq;
	String output = "";
	int count;
	int numberOfNodes;
	int numberOfEdges;
	int N,R;
	int caseNumber = 1;
	boolean first = true;
	int time;
	public uva10199(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		hm = new HashMap <String , ArrayList<String> > ();
		color = new HashMap <String , Integer>();
		low = new HashMap <String , Integer>();
		numberOfChild = new HashMap <String , Integer> ();
		ranAsRoot = new HashMap <String, Boolean> ();
		d = new HashMap <String, Integer> ();
		f = new HashMap <String, Integer> ();
		pq = new PriorityQueue <String> ();
		alreadyAnArticulationPoint = new HashMap<String,Boolean>();
		parent = new HashMap <String ,String> ();
		while(s.hasNextInt()){
			numberOfNodes = s.nextInt();
			if(numberOfNodes == 0) break;
			input();
			count = 0;
			pq.clear();
			for(String key: hm.keySet()){
				if(color.get(key) == 0){
					ranAsRoot.put(key, true);
					DFS(key);
				}
			}
			for(String key: hm.keySet()){
				if(ranAsRoot.get(key) == true){
					if(numberOfChild.get(key) > 1){
						count++;
						pq.add(key);
					}
				}
			}
			output();
		}
	}
	public void input(){
		hm.clear();
		color.clear();
		low.clear();
		d.clear();
		f.clear();
		ranAsRoot.clear();
		alreadyAnArticulationPoint.clear();
		parent.clear();
		numberOfChild.clear();
		for(int i = 0 ; i < numberOfNodes; i++){
			String x = s.next();
			if(!hm.containsKey(x))hm.put(x, new ArrayList<String> ());
			color.put(x, 0);
			numberOfChild.put(x, 0);
			ranAsRoot.put(x, false);
			alreadyAnArticulationPoint.put(x, false);
		}
		numberOfEdges = s.nextInt();
		for(int i = 0 ; i < numberOfEdges ; i++){
			String x = s.next();
			String y = s.next();
			List <String> l = hm.get(x);
			l.add(y);
			l = hm.get(y);
			l.add(x);
		}
	}
	public void DFS(String src){
		color.put(src, 1);
        time++;
        d.put(src,time);
        low.put(src, d.get(src));
        List <String> l = hm.get(src);
        for(String v: l){
            if(color.get(v) == 0){
            	parent.put(v, src);
            	numberOfChild.put(src, numberOfChild.get(src) + 1);	
                DFS(v);
                if(low.get(v) >= d.get(src)){
                	//points[numberOfArticulationPoint++] = src;
                	//System.out.printf("%d %d\n",src,count);
                	if(!alreadyAnArticulationPoint.get(src)){
                		if(!ranAsRoot.get(src)){
                			count++;
                			pq.add(src);
                		}
                			
                	}
                	alreadyAnArticulationPoint.put(src,true);
                }
                if(low.get(v) < low.get(src)) low.put(src,low.get(v));
            }
            else if(!v.equals(parent.get(src)))
            	if(d.get(v) < low.get(src) ) low.put(src,d.get(v));
            
        }
        color.put(src,2);
        time++;
        f.put(src, time);
	}
	public void output(){
		if(!first)output += "\n";
		first = false;
		output += String.format("City map #%d: %d camera(s) found\n",caseNumber,count);
		caseNumber++;
		while(!pq.isEmpty()){
			output += (pq.remove()) + "\n";
		}
	}
	public String returnOutput(){
		return output;
	}
}
