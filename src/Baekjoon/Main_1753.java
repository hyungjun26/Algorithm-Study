package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1753 {
	static int V, E, S;
	static class Edge implements Comparable<Edge>{
		int v, w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(bf.readLine())-1;
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			adj[Integer.parseInt(st.nextToken())-1].add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] dist = new Edge[V];
				
		for (int i = 0; i < V; i++) {
			if(i==S) {
				dist[i] = new Edge(i, 0);
			}
			else {
				dist[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(dist[i]);
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(edge.w==Integer.MAX_VALUE)break;
			for(Edge e : adj[edge.v]) {
				if(!check[e.v] && dist[e.v].w > dist[edge.v].w + e.w) {
					dist[e.v].w = dist[edge.v].w + e.w;
					pq.remove(dist[e.v]);
					pq.add(dist[e.v]);
				}
			}
			check[edge.v] = true;
		}
		
		for (int i = 0; i < V; i++) {			
			if(dist[i].w == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i].w);
			}			
		}		
	}

}
