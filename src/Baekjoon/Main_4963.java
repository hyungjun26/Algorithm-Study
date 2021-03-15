package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_4963 {
	static int[] x = {-1,-1,0,1,1,1,0,-1};
	static int[] y = {0,1,1,1,0,-1,-1,-1};
	static int w,h;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0)break;
			int[][] map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			boolean[][] visit = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						visit[i][j] = true;
						cnt++;
						dfs(i, j, map, visit);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int row, int col, int[][] map, boolean[][] visit) {
		for (int i = 0; i < x.length; i++) {
			int r = row + x[i];
			int c = col + y[i];
			if(isIn(r,c)&&map[r][c]==1&&!visit[r][c]) {
				visit[r][c] = true;
				dfs(r, c, map, visit);
			}
		}		
	}

	private static boolean isIn(int r, int c) {		
		return r < h && r >= 0 && c < w && c >= 0;
	}

}
