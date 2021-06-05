package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_4485 {
	static int N;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static class Edge implements Comparable<Edge>{
		int r, c, w;
		public Edge(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(true) {
			N = Integer.parseInt(bf.readLine());
			if(N==0)break;
			sb.append("Problem ").append(cnt).append(": ");
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}				
			}
			//boolean[][] visit = new boolean[N][N];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(0, 0, map[0][0]));
			dist[0][0] = map[0][0];
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				if(edge.w > dist[edge.r][edge.c])continue;
				for(int k = 0; k < dir.length; k++) {
					int row = edge.r + dir[k][0];
					int col = edge.c + dir[k][1];
					if(isIn(row,col)) {
						if(dist[row][col] > dist[edge.r][edge.c] + map[row][col]) {
							dist[row][col] = dist[edge.r][edge.c] + map[row][col];
							pq.add(new Edge(row, col, dist[row][col]));
						}
					}
				}
			}
			sb.append(dist[N-1][N-1]).append("\n");
			cnt++;
		}
		System.out.println(sb);
	}
	private static boolean isIn(int row, int col) {		
		return row < N && row >= 0 && col < N && col >= 0;
	}
}
