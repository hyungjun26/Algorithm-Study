package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_13460 {
	static int N, M;
	static char[][] map;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static class Point{
		int rr, rc, br, bc, m;
		public Point(int rr, int rc, int br, int bc, int m) {			
			this.rr = rr;
			this.rc = rc;
			this.br = br;
			this.bc = bc;
			this.m = m;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int rr = 0, rc = 0, br = 0, bc = 0;
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='R') {
					rr = i; rc = j;					
				} else if(map[i][j]=='B') {
					br = i; bc = j;					
				}
			}
		}
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(rr, rc, br, bc, 0));
		int ans = 0;
		int cnt = 0;
		boolean red = false, blue = false;
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int row = cur.rr + dir[i][0];
				int col = cur.rc + dir[i][1];
			}
			
		}
		System.out.println(ans);
	}
}
