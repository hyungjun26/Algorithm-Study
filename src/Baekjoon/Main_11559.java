package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_11559 {
	static char[][] field = new char[12][6];
	static char[] RGB = {'R', 'G', 'B', 'P', 'Y'};
	static int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};
	static boolean[][] visit;
	static class Point{
		int r,c;

		public Point(int r, int c) {			
			this.r = r;
			this.c = c;
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < field.length; i++) {
			String src = bf.readLine();
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = src.charAt(j);
			}
		}
		int result = 0;		
		while(true) {			
			visit = new boolean[12][6];
			int cnt = 0;
			for (int i = 0; i < field.length; i++) {			
				for (int j = 0; j < field[i].length; j++) {				
					for (int k = 0; k < RGB.length; k++) {
						List<Point> list = new ArrayList<>();
						if(field[i][j]==RGB[k] && !visit[i][j]) {						
							visit[i][j] = true;
							checkGroup(i, j, list, RGB[k]);
						}
						if(list.size() >= 4) {
							cnt++;
							deleteGroup(list);
						}
					}				
				}
			}			
			if(cnt>0)result++;
			relocateField();			
			if(cnt==0)break;
		}
		System.out.println(result);
	}
	private static void relocateField() {		
		for (int i = 0; i < field[0].length; i++) {
			int cnt = 0;
			for (int j = field.length-1; j >= 0; j--) {
				if(field[j][i] == '.') {cnt++;}
				else {
					for (int k = 0; k < cnt; k++) {
						for (int k2 = j+1; k2 > 0; k2--) {
							field[k2][i] = field[k2-1][i]; 
						}
						field[0][i] = '.';
						j+=1;
					}
					cnt = 0;
				}
			}			
		}
		
	}
	private static void deleteGroup(List<Point> list) {
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			field[p.r][p.c] = '.';
		}
		
	}
	private static void checkGroup(int row, int col, List<Point> list, char comp) {
		list.add(new Point(row, col));
		for (int i = 0; i < dir.length; i++) {
			int r = row + dir[i][0];
			int c = col + dir[i][1];
			if(isIn(r, c) && field[r][c]==comp && !visit[r][c]) {
				visit[r][c] = true;
				checkGroup(r, c, list, comp);
			}
		}		
	}
	private static boolean isIn(int r, int c) {
		return r < 12 && r >= 0 && c < 6 && c >= 0;
	}

}