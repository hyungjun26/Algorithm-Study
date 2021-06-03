package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_15683 {
	static int N, M;
	static char[][] map;
	static int[][] a = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] b = {{-1,0,1,0},{0,1,0,-1}};
	static int[][] c = {{-1,0,0,1},{-1,0,0,-1},{1,0,0,-1},{1,0,0,1}};
	static int[][] d = {{-1,0,1,0,0,1},{-1,0,1,0,0,-1},{0,1,0,-1,1,0},{0,1,0,-1,-1,0}};
	static int[][] e = {{-1,0,0,1,1,0,0,-1}};
	static Camera[] cameras = new Camera[8];
	static int MIN = Integer.MAX_VALUE;
	static class Camera{
		int r, c; char t;
		public Camera(int r, int c, char t) {			
			this.r = r;
			this.c = c;
			this.t = t;
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] != '0' && map[i][j] != '6') {
					Camera t = new Camera(i, j, map[i][j]);
					cameras[cnt] = t;
					cnt++;
				}
			}			
		}
		dfs(0, cnt, new int[cnt], new boolean[cnt]);
		System.out.println(MIN);
	}
	private static void dfs(int idx, int end, int[] temp, boolean[] visit) {
		if(idx==end) {			
			checkType(temp);
			return;
		}
		for (int i = 0; i < end; i++) {
			if(!visit[i]) {
				visit[i] = true;
				temp[idx] = i;
				dfs(idx+1, end, temp, visit);
				visit[i] = false;
			}
		}
	}
	private static void checkType(int[] temp) {
		char[][] copy = new char[N][M];		
		for (int i = 0; i < copy.length; i++) {
			copy[i] = Arrays.copyOf(map[i], map[i].length);
		}		
		for (int i = 0; i < temp.length; i++) {
			Camera cctv = cameras[temp[i]];
			switch (cctv.t) {
			case '1':
				checkView(cctv, copy, a);				
				break;
			case '2':
				checkView(cctv, copy, b);
				break;
			case '3':
				checkView(cctv, copy, c);
				break;
			case '4':
				checkView(cctv, copy, d);
				break;
			case '5':
				checkView(cctv, copy, e);
				break;
			}
			
		}
		int nv = 0;
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				if(copy[i][j]=='0')nv++;
			}
		}
		if(MIN > nv) {
			MIN = nv;			
		}
	}
	private static void checkView(Camera cctv, char[][] copy, int[][] dir) {
		int[] max = new int[2];
		for (int i = 0; i < dir.length; i++) {
			int cnt = 0;
			for (int j = 0; j < dir[i].length; j+=2) {
				int row = cctv.r + dir[i][j];
				int col = cctv.c + dir[i][j+1];				
				while(true) {
					if(!isIn(row,col)||copy[row][col]=='6')break;
					if(copy[row][col]=='0')cnt++;
					row += dir[i][j];
					col += dir[i][j+1];
				}				
			}
			if(max[0] < cnt) {
				max[0] = cnt;
				max[1] = i;
			}
		}
		for (int j = 0; j < dir[max[1]].length; j+=2) {
			int row = cctv.r + dir[max[1]][j];
			int col = cctv.c + dir[max[1]][j+1];			
			while(true) {
				if(!isIn(row,col)||copy[row][col]=='6')break;
				if(copy[row][col]=='0')copy[row][col] = '#';
				row += dir[max[1]][j];
				col += dir[max[1]][j+1];
			}			
		}
	}
	private static boolean isIn(int row, int col) {
		return row < N && row >= 0 && col < M && col >= 0;
	}
}

