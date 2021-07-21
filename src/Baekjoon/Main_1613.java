package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1613 {
	static int N,K,S;
	static List<Integer>[] graph;
	static boolean[][] path;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new List[N+1];
		path = new boolean[N+1][N+1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		for (int i = 1; i <= N; i++) {
			path[i][i] = true;
			makeGraph(i, path[i]);
		}		
		S = Integer.parseInt(bf.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(path[a][b]) {
				sb.append(-1).append("\n");
			}
			else if(path[b][a]) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
	private static void makeGraph(int start, boolean[] visit) {
		for (int i = 0; i < graph[start].size(); i++) {
			if(!visit[graph[start].get(i)]) {
				visit[graph[start].get(i)] = true;
				makeGraph(graph[start].get(i), visit);
			}
		}
	}
}
