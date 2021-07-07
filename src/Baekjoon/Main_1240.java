package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1240 {
	static int N, M;
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[][] data = new int[N+1][N+1];
		for (int[] temp : data) {
			Arrays.fill(temp, Integer.MAX_VALUE);
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			data[a][b] = c;
			data[b][a] = c;
		}
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i==j||data[i][k]==MAX||data[k][j]==MAX)continue;
					if(data[i][j] > data[i][k]+data[k][j]) {
						data[i][j] = data[i][k]+data[k][j];
					}
				}
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(data[a][b]).append("\n");
		}
		System.out.println(sb);
	}
}
