package Baekjoon;
import java.io.*;
import java.util.*;

public class Main_2178 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int result = Integer.MAX_VALUE;
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static class Point{
		int r,c,count;
		public Point(int row, int col, int init) {
			this.r = row;
			this.c = col;
			this.count = init;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j)=='1') {
					map[i][j] = 1;					
				}else {
					map[i][j] = 0;
				}				
			}
		}
		Queue<Point> que = new LinkedList<>();
		Point start = new Point(0,0,1);
		visit[0][0] = true;
		que.add(start);
		while(!que.isEmpty()) {
			Point pin = que.poll();			
			if(pin.r==N-1 && pin.c==M-1 && result > pin.count) {
				result = pin.count;
			}
			for (int i = 0; i < dir.length; i++) {
				int row = pin.r + dir[i][0];
				int col = pin.c + dir[i][1];
				if(isIn(row,col)&&map[row][col]==1&&!visit[row][col]) {
					que.add(new Point(row, col, pin.count+1));
					visit[row][col] = true;
				}
			}
		}
		System.out.println(result);
	}
	private static boolean isIn(int row, int col) {
		return N > row && row >= 0 && M > col && col >= 0;
	}
}