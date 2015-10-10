package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class uva610 {
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
	String outputString = "";
	Scanner s = new Scanner(System.in);
	public uva610(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNextInt()){
			n = s.nextInt();
			m = s.nextInt();
			if( n == 0 && m == 0) break;
			init();
			input();
			for(int i = 1 ; i <= n ; i++){
				if(color[i] == 0){
					DFS(i);
				}
			}
			output();
		}
		
	}
	public void output(){
		outputString += testCase + "\n\n";
		testCase++;
		for(int i = 1; i <= n ; i++){
			for(int j = 1; j <= n; j++){
				
				if(output[i][j]){
					if(bridge[i][j]){
						outputString += (i + " " + j) + "\n";
						outputString += (j + " " + i) + "\n";
					}
					else{
						outputString += (i + " " + j) + "\n";
					}
				}
			}
		}
		outputString += ("#");
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
	}
	public void input(){
		for(int i = 0; i < m ;i++){
			int x = s.nextInt();
			int y = s.nextInt();
			Matrix[x][y] = true;
			Matrix[y][x] = true;
			//output[x][y] = true;
		}
	}
	public void DFS(int src){
        color[src] = 1;
        time++;
        d[src] = time;
        low[src] = d[src];
        for(int j = 1 ; j <= n; j++){
            if(Matrix[src][j]){
                if(color[j] == 0){
                    parent[j] = src;
                    output[src][j] = true;
                    DFS(j);
                    if(low[j] > d[src]){
                    	bridge[src][j] = bridge[j][src] = true;
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
