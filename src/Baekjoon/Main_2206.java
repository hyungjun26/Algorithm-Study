package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2206 {
	static int N, M;
	static int[][] map;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int MIN = Integer.MAX_VALUE;
	static Point[][] isVisit;
	static class Point{
		int r, c, cnt, crash = 1;
		public Point(int r, int c, int cnt) {			
			this.r = r;
			this.c = c;			
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", crash=" + crash + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-48;
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
		Point[][] vp = new Point[N][M];
		boolean[][] visit = new boolean[N][M];
		q.add(new Point(0, 0, 1));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();			
			if(p.r == N - 1 && p.c == M - 1) {
				MIN = p.cnt;
				break;
			}
			for (int i = 0; i < dir.length; i++) {
				int r = p.r + dir[i][0];
				int c = p.c + dir[i][1];
				if(isIn(r, c) && map[r][c] == 0 && !visit[r][c]) {
					Point t = new Point(r, c, p.cnt+1);
					t.crash = p.crash;
					visit[r][c] = true;
					q.offer(t);
					vp[r][c] = t;
				}
				else if(isIn(r, c) && map[r][c] == 0 && visit[r][c] && vp[r][c] != null) {
					if(vp[r][c].crash < p.crash) {
						Point t = new Point(r, c, p.cnt+1);
						t.crash = p.crash;
						visit[r][c] = true;
						q.offer(t);
						vp[r][c] = t;
					}
				}
				else if(isIn(r, c) && map[r][c] == 1 && p.crash == 1 && !visit[r][c]) {
					Point t = new Point(r, c, p.cnt+1);
					t.crash--;
					visit[r][c] = true;
					q.offer(t);
					vp[r][c] = t;
				}
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r < N && r >= 0 && c < M && c >= 0;
	}
}
