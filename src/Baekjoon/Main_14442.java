package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_14442 {
	static int N, M, K;
	static char[][] map;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int MIN = Integer.MAX_VALUE;
	static boolean[][][] visit;
	static class Point{
		int r, c, cnt, crash;
		public Point(int r, int c, int cnt, int crash) {			
			this.r = r;
			this.c = c;			
			this.cnt = cnt;
			this.crash = crash;
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M][K+1];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {				
				map[i][j] = str.charAt(j);
			}
		}		
		bfs();
		if(MIN==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(MIN);
		}
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();		
		q.add(new Point(0, 0, 1, K));			
		while(!q.isEmpty()) {
			Point p = q.poll();			
			if(p.r == N - 1 && p.c == M - 1) {
				if(MIN > p.cnt)MIN = p.cnt;			
			}
			for (int i = 0; i < dir.length; i++) {
				int r = p.r + dir[i][0];
				int c = p.c + dir[i][1];
				if(isIn(r, c) && map[r][c] == '0' && !visit[r][c][p.crash]) {
					Point t = new Point(r, c, p.cnt+1, p.crash);					
					if(r == N - 1 && c == M - 1)visit[r][c][p.crash] = false;
					else visit[r][c][p.crash] = true;
					q.offer(t);					
				}				
				else if(isIn(r, c) && map[r][c] == '1' && p.crash > 0 && !visit[r][c][p.crash-1]) {					
					Point t = new Point(r, c, p.cnt+1, p.crash-1);					
					if(r == N - 1 && c == M - 1)visit[r][c][t.crash] = false;
					else visit[r][c][t.crash] = true;
					q.offer(t);					
				}
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r < N && r >= 0 && c < M && c >= 0;
	}
}
