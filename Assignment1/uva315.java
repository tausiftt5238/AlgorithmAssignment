package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class uva315 {
	int n;
	int count;
	int time;
	boolean adjMatrix[][];
	int color[];
	int parent[];
	int d[];
	int f[];
	int low[];
	int numberOfChild[];
	boolean alreadyAnArticulationPoint[];
	boolean ranAsRoot[];
	String output = "";
	Scanner s = new Scanner(System.in);
	public uva315(File file){
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(s.hasNextInt()){
			n = s.nextInt();
			if(n == 0) break;
			adjMatrix = new boolean[n+1][n+1];
			color = new int[n+1];
			parent = new int[n+1];
			d = new int[n+1];
			f = new int[n+1];
			low = new int[n+1];
			ranAsRoot = new boolean[n+1];
			numberOfChild = new int[n+1];
			alreadyAnArticulationPoint = new boolean[n+1];
			input();
			count = 0;
			time = 0;
			for(int i = 1 ; i <= n; i++){
				if(color[i] == 0){
					ranAsRoot[i] = true;
					DFS(i);
				}
			}
			for(int i = 1 ; i <= n ; i++){
				//System.out.printf("%d %b %d\n",i,ranAsRoot[i],numberOfChild[i]);
				if(ranAsRoot[i]){
					if(numberOfChild[i] > 1) count++;
				}
			}
			output += count + "\n";
		}
	}
	public void DFS(int src){
        color[src] = 1;
        time++;
        d[src] = time;
        low[src] = d[src];
        for(int j = 1 ; j <= n; j++){
            if(adjMatrix[src][j]){
                if(color[j] == 0){
                    parent[j] = src;
                    numberOfChild[src]++;	
                    DFS(j);
                    if(low[j] >= d[src]){
                    	if(!alreadyAnArticulationPoint[src]){
                    		if(!ranAsRoot[src])
                    			count++;
                    	}
                    	alreadyAnArticulationPoint[src] = true;
                    }
                    if(low[j] < low[src]) low[src] = low[j];
                }
                else if(j != parent[src])
                	if(d[j] < low[src] ) low[src] = d[j];
            }
            
        }
        color[src] = 2;
        time++;
        f[src] = time;
    }
	public void input(){
		while(s.hasNextLine()){
			String str = s.nextLine();
			if(str.equals("0")) break;
			String[] list = str.split(" ");
			for(int i = 1; i < list.length; i++){
				adjMatrix[Integer.parseInt(list[0])][Integer.parseInt(list[i])] = true;
				adjMatrix[Integer.parseInt(list[i])][Integer.parseInt(list[0])] = true;
			}
		}
	}
	public String returnOutput(){
		return output;
	}
}
