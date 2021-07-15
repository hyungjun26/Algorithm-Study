package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2610 {
	static int N, M;
	static List<Integer>[] graph;
	static List<List> group = new ArrayList<>();
	static int[][] adj;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		graph = new List[N+1];
		visit = new boolean[N+1];
		adj = new int[N+1][N+1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		int gCnt = 0;
		for (int i = 1; i < visit.length; i++) {
			if(!visit[i]) {
				List<Integer> temp = new ArrayList<>();
				visit[i] = true;
				temp.add(i);
				groupFind(i, temp);
				group.add(temp);
				gCnt++;
			}
		}		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j || adj[i][k] == 0 || adj[k][j] == 0)continue;
					if(adj[i][j] == 0) adj[i][j] = adj[i][k]+adj[k][j];
					else if(adj[i][j] > adj[i][k]+adj[k][j]) adj[i][j] = adj[i][k]+adj[k][j];
				}
			}
		}		
		int[] ans = new int[gCnt];
		int idx = 0;
		for(List<Integer> a:group) {
			int min = Integer.MAX_VALUE;
			int boss = 0;
			for (int i = 0; i < a.size(); i++) {				
				int max = Integer.MIN_VALUE;
				int candi = a.get(i);
				for(int j = 0; j < a.size(); j++) {
                    if(a.get(j)==candi)continue;
					if(max < adj[a.get(j)][candi])max = adj[a.get(j)][candi];
				}				
				if(min>max) {
					min=max;
					boss = a.get(i);
				}
			}
			ans[idx] = boss;
			idx++;
		}
		Arrays.sort(ans);		
		StringBuilder sb = new StringBuilder();
		sb.append(gCnt).append("\n");
		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.print(sb);
	}
	private static void groupFind(int idx, List<Integer> temp) {
		for(int i = 0; i < graph[idx].size(); i++) {
			if(!visit[graph[idx].get(i)]) {
				visit[graph[idx].get(i)] = true;
				temp.add(graph[idx].get(i));
				groupFind(graph[idx].get(i), temp);
			}
		}
	}
}
