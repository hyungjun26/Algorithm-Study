package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2636 {
	static int N, M, cnt;
	static int[][] map;
	static boolean[][] air;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		air = new boolean[N][M];
		int cheeze = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)cheeze++;				
			}
		}
		air[0][0] = true;
		airCheck(0,0);
		int prev = 0;
		int time = 0;
		while(cheeze>0) {
			cnt = 0;
			List<Point> melt = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {					
					if(!air[i][j]&&map[i][j]==1&&meltCheeze(i, j)) {
						map[i][j] = 0;
						melt.add(new Point(i, j));
						cnt++;
					}
				}
			}
			for (int i = 0; i < melt.size(); i++) {
				Point p = melt.get(i);
				if(!air[p.r][p.c]) {
					air[p.r][p.c] = true;
					airCheck(p.r, p.c);					
				}
			}			
			cheeze-=cnt;
			prev = cnt;
			time++;			
		}
		System.out.println(time);
		System.out.println(prev);
	}
	private static boolean meltCheeze(int r, int c) {		
		for (int i = 0; i < dir.length; i++) {
			int row = r + dir[i][0];
			int col = c + dir[i][1];
			if(air[row][col]) {
				return true;
			}
		}
		return false;
	}
	private static void airCheck(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r,c));
		while(!q.isEmpty()) {
			Point n = q.poll();
			for (int i = 0; i < dir.length; i++) {
				int row = n.r + dir[i][0];
				int col = n.c + dir[i][1];
				if(isIn(row,col)&&!air[row][col]&&map[row][col]==0) {
					air[row][col] = true;
					q.offer(new Point(row,col));
				}
			}
		}
	}
	private static boolean isIn(int row, int col) {
		return row < N && row >= 0 && col < M && col >= 0;
	}
}
