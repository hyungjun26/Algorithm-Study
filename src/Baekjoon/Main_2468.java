package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2468 {
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N;
	static int ans = 0;
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[][] data = new int[N][N];
		for (int i = 0; i < data.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < data.length; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if(data[i][j]<min)min=data[i][j];
				if(data[i][j]>max)max=data[i][j];
			}			
		}
		
		for(int h = 1; h <= max; h++) {
			int cnt = 0;
			Queue<Point> q = new LinkedList<>();
			boolean[][] visit = new boolean[N][N];
			for (int i = 0; i < data.length; i++) {				
				for (int j = 0; j < data.length; j++) {
					if(data[i][j]>h && !visit[i][j]) {
						q.offer(new Point(i,j));
						cnt++;
						visit[i][j] = true;
						while(!q.isEmpty()) {
							Point p = q.poll();
							for(int k = 0; k < dir.length; k++) {
								int row = p.r + dir[k][0];
								int col = p.c + dir[k][1];
								if(isIn(row,col)) {
									if(data[row][col] > h && !visit[row][col]) {
										q.offer(new Point(row, col));
										visit[row][col] = true;
									}
								}
							}
						}
						if(cnt>ans)ans=cnt;						
					}					
				}			
			}			
		}
		if(ans==0) {
			System.out.println(1);
		}
		else {
			System.out.println(ans);
		}
		
	}
	private static boolean isIn(int i, int j) {
		return i < N && i >= 0 && j < N && j >= 0;
	}
}
