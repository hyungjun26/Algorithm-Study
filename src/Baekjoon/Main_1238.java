package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1238 {
	private static int N, M, X;
	private static List<Edge>[] list , reverseList;
	static class Edge implements Comparable<Edge>{
		int target;
		int weight;
		
		public Edge(int t, int w) {
			this.target = t;
			this.weight = w;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.weight-e.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		reverseList = new List[N+1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}
		int[] dist = new int[N+1];
		int[] reverseDist = new int[N+1];
		Arrays.fill(dist, 10000000);
		Arrays.fill(reverseDist, 10000000);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new Edge(e,w));
			reverseList[e].add(new Edge(s,w));
		}
		
		dijkstra(list, dist, X);
		dijkstra(reverseList, reverseDist, X);
		
		int res = -1;
		for(int i = 1; i <= N; i++) {
			res = Math.max(res, dist[i]+reverseDist[i]);
		}
		
		System.out.println(res);
	}

	private static void dijkstra(List<Edge>[] list, int[] dist, int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int idx = pq.poll().target;
			if(visited[idx])continue;
			visited[idx] = true;
			
			for(Edge edge : list[idx]) {
				if(dist[edge.target] > dist[idx]+edge.weight) {
					dist[edge.target] = dist[idx]+edge.weight;
					pq.add(new Edge(edge.target, dist[edge.target]));
				}
			}
		}
	}
}
