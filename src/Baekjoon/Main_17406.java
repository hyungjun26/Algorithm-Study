package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17406 {
	static int N, M, K, MIN = Integer.MAX_VALUE;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] data;
	static int[][] oper;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		N = Integer.parseInt(st.nextToken());		
		M = Integer.parseInt(st.nextToken());		
		K = Integer.parseInt(st.nextToken());
		data = new int[N][M];
		oper = new int[K][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			for(int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			oper[i][0] = Integer.parseInt(st.nextToken())-1;
			oper[i][1] = Integer.parseInt(st.nextToken())-1;
			oper[i][2] = Integer.parseInt(st.nextToken());			
		}		
		dfs(0, K, new int[K], new boolean[K]);
		System.out.println(MIN);
	}
	private static void dfs(int idx, int end, int[] order, boolean[] visit) {
		if(idx==end) {
			orderTest(order);
			return;
		}
		for (int i = 0; i < end; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order[idx] = i;
				dfs(idx+1, end, order, visit);
				visit[i] = false;				
			}
		}
		
	}
	private static void orderTest(int[] order) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = Arrays.copyOf(data[i], data[i].length);
		}
		for(int k = 0; k < K; k++) {
			int r = oper[order[k]][0];
			int c = oper[order[k]][1];
			int s = oper[order[k]][2];
			for(int j = 1; j <= s; j++) {
				int row = r - j;
				int col = c - j + 1;
				int prev = temp[row][c-j];
				int type = 0;
				while(true) {
					if(row==r-j&&col==c-j) {
						temp[row][col] = prev;
						break;	
					}
					int t = temp[row][col];
					temp[row][col] = prev;
					prev = t;
					if(type==0&&col==c+j) {
						type = 1;
					} else if(type==1&&row==r+j) {
						type = 2;
					} else if(type==2&&col==c-j) {
						type = 3;
					}
					row += dir[type][0];
					col += dir[type][1];
				}
			}			
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < temp.length; i++) {
			int sum = 0;
			for (int j = 0; j < temp[i].length; j++) {
				sum += temp[i][j];
			}
			if(min>sum)min=sum;
		}
		if(MIN>min)MIN=min;
	}	
}
