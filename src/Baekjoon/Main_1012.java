package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1012 {
	static int M, N, K;
	static boolean[][] land;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < TC; tc++) {
			int res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			land = new boolean[M][N];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				land[x][y] = true;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(land[i][j]) {
						land[i][j]=false;
						res++;
						dfs(i, j);
					}
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int i, int j) {
		for (int k = 0; k < dir.length; k++) {
			int x = i + dir[k][0];
			int y = j + dir[k][1];
			if(isIn(x, y) && land[x][y]) {
				land[x][y] = false;
				dfs(x, y);
			}
		}
		
	}
	private static boolean isIn(int x, int y) {
		// TODO Auto-generated method stub
		return x < M && x >= 0 && y < N && y >= 0;
	}
	
}