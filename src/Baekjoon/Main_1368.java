package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1368 {
	static int N;
	static int[] W;
	static int[][] P;
	static class Edge implements Comparable<Edge>{
		int[] node = new int[2];
		int distance;
		public Edge(int a, int b, int distance) {
			this.node[0] = a;
			this.node[1] = b;
			this.distance = distance;
		}
		@Override
		public int compareTo(Edge other) {			
			return this.distance - other.distance;
		}		
	}
	private static int getParent(int[] parent, int x) {
		if(parent[x]==x)return x;
		else return parent[x] = getParent(parent, parent[x]);
	}
	private static void unionParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	private static boolean findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a==b)return true;
		else return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		W = new int[N];
		P = new int[N][N];
		int MIN = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			W[i] = Integer.parseInt(bf.readLine());
			if(MIN > W[i]) MIN = W[i];
		}		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				P[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<Edge> v = new ArrayList<>();
		for (int i = 0; i < N; i++) {			
			for (int j = i+1; j < N; j++) {				
				v.add(new Edge(i, j, P[i][j]));
			}
		}
		v.sort(null);
		int[] parent = new int[N];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			if(!findParent(parent, v.get(i).node[0], v.get(i).node[1])) {
				sum+=v.get(i).distance;
				unionParent(parent, v.get(i).node[0], v.get(i).node[1]);
			}
		}
		for(Edge e : v) {
			System.out.println(e.node[0] + " " + e.node[1] + " " + e.distance);
		}
		System.out.println(sum+MIN);
	}
}
