package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_14499 {
	static int N, M, R, C, K;
	static int[][] MAP;
	static int[] dice = new int[6];
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		MAP = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		StringBuilder sb = new StringBuilder();		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int oper = Integer.parseInt(st.nextToken());
			int row = R + dir[oper-1][0];
			int col = C + dir[oper-1][1];
			if(isIn(row,col)) {
				int temp;
				switch (oper) {
				case 1:
					temp = dice[2];
					dice[2] = dice[0];
					dice[0] = dice[3];
					dice[3] = dice[5];
					dice[5] = temp;					
					break;
				case 2:
					temp = dice[3];
					dice[3] = dice[0];
					dice[0] = dice[2];
					dice[2] = dice[5];
					dice[5] = temp;					
					break;
				case 3:
					temp = dice[1];
					dice[1] = dice[0];
					dice[0] = dice[4];
					dice[4] = dice[5];
					dice[5] = temp;					
					break;
				case 4:
					temp = dice[4];
					dice[4] = dice[0];
					dice[0] = dice[1];
					dice[1] = dice[5];
					dice[5] = temp;					
					break;
				}
				if(MAP[row][col]>0) {
					dice[5] = MAP[row][col];
					MAP[row][col] = 0;
				} else {
					MAP[row][col] = dice[5];
				}
				sb.append(dice[0]).append("\n");
				R = row;
				C = col;
			}
		}
		System.out.println(sb);
	}
	private static boolean isIn(int r, int c) {
		return r < N && r >= 0 && c < M && c >= 0;
	}
}
