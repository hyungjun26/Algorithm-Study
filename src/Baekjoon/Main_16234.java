package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_16234 {
	static int N, R, L;
	static boolean[][] adj;
	static int[][] data;
	static List<List<Point>> group;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
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
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		data = new int[N][N];
		for (int i = 0; i < data.length; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < data.length; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while(true) {
			adj = new boolean[N][N];
			group = new ArrayList<>(); 
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data.length; j++) {
					if(!adj[i][j]) {
						adj[i][j] = true;
						List<Point> temp = new ArrayList<>();
						Point p = new Point(i, j);
						temp.add(p);
						findGroup(p, temp);						
						if(temp.size()>1)group.add(temp);
						else adj[i][j] = false;
					}
				}
			}
			if(group.size()>=1) {
				cnt++;
				for (int i = 0; i < group.size(); i++) {
					int sum = 0;
					for (int j = 0; j < group.get(i).size(); j++) {
						Point p = group.get(i).get(j);
						sum += data[p.r][p.c];
					}
					sum = sum / group.get(i).size();
					for (int j = 0; j < group.get(i).size(); j++) {
						Point p = group.get(i).get(j);
						data[p.r][p.c] = sum;
					}
				}
			}else break;			
		}
		System.out.println(cnt);
	}
	private static void findGroup(Point point, List<Point> temp) {
		for (int i = 0; i < dir.length; i++) {
			int r = point.r + dir[i][0];
			int c = point.c + dir[i][1];
			if(isIn(r,c) && !adj[r][c]){
				int sub = Math.abs(data[point.r][point.c]-data[r][c]);				
				if(sub >= L && sub <= R) {					
					adj[r][c] = true;
					Point next = new Point(r, c);
					temp.add(next);
					findGroup(next, temp);
				}				
			}
		}		
	}
	private static boolean isIn(int row, int col) {
		return row < N && row >= 0 && col < N && col >= 0;
	}
}

