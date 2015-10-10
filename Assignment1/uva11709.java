package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class uva11709 {
	int P,T;
	HashMap <String , ArrayList<String> > list;
	HashMap <String, ArrayList <String>> transposeList;
	HashMap <String , Integer> color;
	HashMap <String, Integer> f;
	Stack <String> stack;
	int time;
	int count;
	String output = "";
	Scanner s = new Scanner(System.in);
	public uva11709(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNextInt()){
			P = s.nextInt();
			T = s.nextInt();
			s.nextLine();
			if(P == 0 && T == 0)break;
			list = new HashMap <String , ArrayList<String> > ();
			transposeList = new HashMap <String , ArrayList<String> > ();
			color = new HashMap <String , Integer>();
			f = new HashMap <String, Integer> ();
			stack = new Stack<String>();
			time = 0;
			count = 0;
			input();
			SCC();
		}
	}
	
	public void input(){
		for(int i = 0 ; i < P ; i++){
			
			String x = s.nextLine();
			if(!list.containsKey(x))list.put(x, new ArrayList<String> ());
			if(!transposeList.containsKey(x))transposeList.put(x, new ArrayList<String> ());
			color.put(x, 0);
			f.put(x, 0);
		}
		for(int i = 0 ; i < T ; i++){
			
			String x = s.nextLine();
			
			String y = s.nextLine();
			List <String> l = list.get(x);
			
			l.add(y);
			ArrayList <String> tl = transposeList.get(y);
			
			tl.add(x);
		}
	}
	public void SCC(){
		for(String key : list.keySet()){
			if(color.get(key) == 0){
				DFS(key,list);
			}
		}
		zero();
		while(!stack.isEmpty()){
			String x = stack.pop();
			if(color.get(x) == 0){
				DFS(x,transposeList);
				count++;
			}
		}
		output += (count) + "\n";
		
	}
	public void DFS(String src, HashMap <String , ArrayList<String> > List){
		color.put(src, 1);
        time++;
        
        List <String> l = List.get(src);
        for(String v: l){
            if(color.get(v) == 0){	
                DFS(v,List);
            }
        }
        color.put(src,2);
        time++;
        f.put(src,time);
        stack.push(src);
	}
	public void zero(){
		for(String key: color.keySet()){
			color.put(key, 0);
		}
	}
	public String returnOutput(){
		return output;
	}
}
