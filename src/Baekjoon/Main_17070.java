package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17070 {
	static int[][] w = {{0,1,1},{1,1,3}}; // 가로 type 1
	static int[][] h = {{1,0,2},{1,1,3}}; // 세로 type 2
	static int[][] d = {{0,1,1},{1,1,3},{1,0,2}}; // 대각선 type 3	
	static int N, cnt=0;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)visit[i][j] = true;
			}
		}
		visit[0][1] = true;
		movePipeline(0, 1, 1);
		System.out.println(cnt);
	}
	private static void movePipeline(int r, int c, int type) {
		if(r==N-1&&c==N-1) {
			cnt++;
			return;
		}
		switch (type) {
		case 1:
			for (int i = 0; i < w.length; i++) {
				int row = r + w[i][0];
				int col = c + w[i][1];
				boolean check = true;
				if(isIn(row,col) && !visit[row][col] && w[i][2]==3) {					
					for (int j = 0; j < d.length; j++) {
						if(!isIn(r+d[j][0],c+d[j][1])||visit[r+d[j][0]][c+d[j][1]])check=false;
					}
				}
				if(isIn(row,col) && !visit[row][col] && check) {
					visit[row][col] = true;
					movePipeline(row, col, w[i][2]);
					visit[row][col] = false;
				}
			}
			break;
		case 2:
			for (int i = 0; i < h.length; i++) {
				int row = r + h[i][0];
				int col = c + h[i][1];
				boolean check = true;
				if(isIn(row,col) && !visit[row][col] && h[i][2]==3) {					
					for (int j = 0; j < d.length; j++) {
						if(!isIn(r+d[j][0],c+d[j][1])||visit[r+d[j][0]][c+d[j][1]])check=false;
					}
				}
				if(isIn(row,col) && map[row][col]!=1 && !visit[row][col] && check) {
					visit[row][col] = true;
					movePipeline(row, col, h[i][2]);
					visit[row][col] = false;
				}
			}
			break;
		case 3:
			for (int i = 0; i < d.length; i++) {
				int row = r + d[i][0];
				int col = c + d[i][1];
				boolean check = true;
				if(isIn(row,col) && !visit[row][col] && d[i][2]==3) {					
					for (int j = 0; j < d.length; j++) {
						if(!isIn(r+d[j][0],c+d[j][1])||visit[r+d[j][0]][c+d[j][1]])check=false;
					}
				}
				if(isIn(row,col) && map[row][col]!=1 && !visit[row][col] && check) {
					visit[row][col] = true;
					movePipeline(row, col, d[i][2]);
					visit[row][col] = false;
				}
            }
			break;
		}		
	}
	private static boolean isIn(int row, int col) {
		return row < N && row >= 0 && col < N && col >= 0;
	}
}
