package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_3190 {
	static int N, K, L;
	static int[][] map;
	static int[][] way;
	static int[][] dir = {{0,1},{-1,0},{1,0},{0,-1}};
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		K = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 1;
		}
		L = Integer.parseInt(bf.readLine());
		way = new int[L][2];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			way[i][0] = Integer.parseInt(st.nextToken());
			char temp = st.nextToken().charAt(0);
			if(temp=='L')way[i][1] = 1;
			else way[i][1] = 2;
		}
		int time = 0;
		int hr = 0, hc = 0, idx = 0, tidx = 0;		
		Queue<Point> q = new LinkedList<>();
		while(true) {
			time++;
			map[hr][hc] = 2;
			q.add(new Point(hr, hc));
			hr += dir[idx][0];
			hc += dir[idx][1];
			if(!isIn(hr,hc)||map[hr][hc]==2)break;
			if(map[hr][hc]!=1) {				
				Point tail = q.poll();
				map[tail.r][tail.c] = 0;
			}
			
			if(time==way[tidx][0]) {
				switch (idx) {
				case 0:
					if(way[tidx][1]==1)idx=1;
					else idx = 2;
					break;
				case 1:
					if(way[tidx][1]==1)idx=3;
					else idx = 0;
					break;
				case 2:
					if(way[tidx][1]==1)idx=0;
					else idx = 3;
					break;
				case 3:
					if(way[tidx][1]==1)idx=2;
					else idx = 1;
					break;
				}
				tidx++;
				if(tidx==L)tidx=0;
			}
		}
		System.out.println(time);
	}
	private static boolean isIn(int row, int col) {
		return row < N && row >= 0 && col < N && col >= 0;
	}
}
