package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_4179 {
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static class Point {
		int row, col, time;
		char type;

		public Point(int row, int col, int time, char type) {
			this.row = row;
			this.col = col;
			this.time = time;
			this.type = type;
		}
	}

	static int R, C;
	static char MAP[][];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken()) + 2;
		C = Integer.parseInt(st.nextToken()) + 2;
		MAP = new char[R][C];
		boolean[][] visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(MAP[i], 'e');
		}
		Queue<Point> q = new LinkedList<>();
		Point start = null, fire = null;
		for (int i = 1; i < R - 1; i++) {
			String src = bf.readLine();
			for (int j = 0; j < src.length(); j++) {
				switch (src.charAt(j)) {
				case '#':
					MAP[i][j+1] = '#';
					break;
				case 'J':
					visit[i][j+1] = true;
					MAP[i][j+1] = '.';
					start = new Point(i, j+1, 0, 'J');
					break;
				case 'F':
					MAP[i][j+1] = 'F';
					q.add(new Point(i, j+1, 0, 'F'));
					break;
				default:
					MAP[i][j+1] = '.';
					break;
				}
			}
		}		
		q.add(start);
		int result = Integer.MAX_VALUE;
		outer:while (!q.isEmpty()) {
			Point p = q.poll();
			switch (p.type) {
			case 'F':
				for (int i = 0; i < dir.length; i++) {
					int r = p.row + dir[i][0];
					int c = p.col + dir[i][1];
					if (isIn(r, c) && (MAP[r][c] == '.' || MAP[r][c] == 'J')) {
						MAP[r][c] = 'F';
						q.add(new Point(r, c, p.time + 1, p.type));
					}
				}
				break;
			case 'J':
				if (p.row == 0 || p.row == R - 1 || p.col == 0 || p.col == C - 1) {
					result = (result > p.time) ? p.time : result;
					break outer;
				}
				for (int i = 0; i < dir.length; i++) {
					int r = p.row + dir[i][0];
					int c = p.col + dir[i][1];
					if (isIn(r, c) && (MAP[r][c] == '.' || MAP[r][c] == 'e') && !visit[r][c]) {
						visit[r][c] = true;
						MAP[r][c] = 'J';
						q.add(new Point(r, c, p.time + 1, p.type));
					}
				}	
				break;
			}
		}
		if(result==Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}
	}

	private static boolean isIn(int r, int c) {
		return R > r && r >= 0 && C > c && c >= 0;
	}

}
