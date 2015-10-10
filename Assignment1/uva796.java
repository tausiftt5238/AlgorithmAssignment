package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class uva796 {
	boolean Matrix[][];
	boolean output[][];
	boolean bridge[][];
	boolean in[];
	int color[];
	int low[];
	int d[];
	int f[];
	int parent[];
	int n,m;
	int time;
	int testCase = 1;
	int count;
	boolean first = true;
	String outputString = "";
	Scanner s = new Scanner(System.in);
	public uva796(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNextInt()){
			n = s.nextInt();
			init();
			input();
			for(int i = 0 ; i < n ; i++){
				if(color[i] == 0){
					DFS(i);
				}
			}
			output();
		}
		
	}
	public void output(){
		outputString += String.format("%d critical links\n",count);
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n; j++){
				if(bridge[i][j]){
					outputString += String.format("%d - %d\n", i,j);
				}
			}
		}
		outputString += "\n";
	}
	public void init(){
		in = new boolean[n+1];
		Matrix = new boolean[n+1][n+1];
		output = new boolean[n+1][n+1];
		bridge = new boolean[n+1][n+1];
		color = new int[n+1];
		low = new int[n+1];
		d = new int[n+1];
		f = new int[n+1];
		parent = new int[n+1];
		time = 0;
		count = 0;
	}
	public void input(){
		for(int i = 0; i < n ;i++){
			int x,y;
			x = s.nextInt();
			String tempString = s.next();
			String temp = "";
			
			for(int j = 1; j < tempString.length() - 1 ; j++){
				temp += tempString.charAt(j);
			}
			int j = Integer.parseInt(temp);
			while(j-- != 0){
				y = s.nextInt();
				Matrix[x][y] = true;
			}
		}
	}
	public void DFS(int src){
        color[src] = 1;
        time++;
        d[src] = time;
        low[src] = d[src];
        for(int j = 0 ; j < n; j++){
            if(Matrix[src][j]){
                if(color[j] == 0){
                    parent[j] = src;
                    output[src][j] = true;
                    DFS(j);
                    if(low[j] > d[src]){
                    	count++; 
                    	
                    	if(src < j ){
                    		
                    		bridge[src][j] = true;
                    	}else{
                    		
                    		bridge[j][src] = true;
                    	}
                    }
                    if(low[j] < low[src]) low[src] = low[j];
                    
                }
                else if(j != parent[src]){
                	if(d[j] < low[src] ) low[src] = d[j];
                }
                if(!output[j][src]) output[src][j] = true;
                
            }
            
        }
        color[src] = 2;
        time++;
        f[src] = time;
    }
	public String returnOutput(){
		return outputString;
	}
}
