package Assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class uva11518 {
	int n;
	int d[];
	int visited[];
	int m;
	int l;
	int count = 0;
	String output = "";
    ArrayList G[];
	Scanner S = new Scanner(System.in);
    public uva11518(File file) {
        int ce;
        try {
			S = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        ce = S.nextInt();
        for (int i = 0; i < ce; i++) {
            n = S.nextInt();
            init();
            input();
            if (n == 0) {
                output += 0;
                continue;
            }
            DFS();

        }
    }
    public void init(){
    	count = 0;
        visited = new int[10000 + 10];
        d = new int[10000 + 10];
        G = new ArrayList[10000 + 10];
        for (int i = 0; i <= n; i++) {
            G[i] = new ArrayList();
        }
    }
    public void input(){
    	m = S.nextInt();
        l = S.nextInt();
        for (int j = 0; j < m; j++) {
            int x = S.nextInt();
            int y = S.nextInt();
            G[x].add(y);
        }
        for (int i = 0; i < l; i++) {
            d[i] = S.nextInt();
        }
    }
    void DFS() {
        if (l == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < l; i++) {
            if (visited[d[i]] == 0) {
                DFS_visit(d[i]);
            }
        }
        output += count + "\n";
    }

    void DFS_visit(int x) {
        count++;
        visited[x] = 1;
        for (int i = 0; i < G[x].size(); i++) {
            int temp = (int) G[x].get(i);
            if (visited[temp] != 1) {
                DFS_visit(temp);
            }
        }
    }
    public String returnOutput(){
    	return output;
    }
}