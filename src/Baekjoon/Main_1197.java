package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1197 {
	static int V, E;
	static int[][] edges;
	static int[] parents, rank;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());		
		}
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		parents = new int[V+1];
		rank = new int[V+1];
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}
		int cnt = 0, result = 0;
		for (int i = 0; i < E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if(a==b)continue;			
			result += edges[i][2];
			union(a,b);
			cnt++;
			if(cnt > V-1)break;			
		}
		System.out.println(result);
	}
	
	private static void union(int a, int b) {
		int x = findSet(a);
		int y = findSet(b);
		if(rank[x] > rank[y]) {
			parents[y] = x;
		}
		else {
			parents[x] = y;
			if(rank[x]==rank[y])rank[y]++;
		}
	}

	private static void makeSet(int i) {
		parents[i] = i;
	}
	
	private static int findSet(int i) {
		if(parents[i] == i) {
			return i;
		}
		else {
			parents[i] = findSet(parents[i]);
			return parents[i];
		}		
	}
}
