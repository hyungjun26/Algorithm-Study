package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17136 {
	static int[][] map = new int[10][10];	
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] copy;
	static int R, C, P;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//order(0, 5, new int[5], new boolean[5]);
		int[] temp = {5,4,3,2,1};
		orderTest(temp);
		System.out.println(MIN);
	}
	private static void orderTest(int[] order) {
		System.out.println(Arrays.toString(order));
		copy = new int[10][10];
		int[] paper = {5,5,5,5,5,5};
		for (int i = 0; i < copy.length; i++) {
			copy[i] = Arrays.copyOf(map[i], map[i].length);
		}		
		int cnt = 0;
		for (int k:order) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(copy[i][j]==1 && i+k-1 < 10 && j+k-1 < 10 && checkVaild(i, j, k) && paper[k]>0) {											
						markPaper(i, j, k);						
						cnt++;
						paper[k]--;
						System.out.println("----------------------------------");
						for(int[] a:copy) {
							System.out.println(Arrays.toString(a));
						}
					}
				}				
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(copy[i][j]==1)cnt=-1;
			}
		}
		System.out.println("위:"+cnt);
		copy = new int[10][10];
		Arrays.fill(paper, 5);
		for (int i = 0; i < copy.length; i++) {
			copy[i] = Arrays.copyOf(map[i], map[i].length);
		}		
		cnt = 0;
		for (int k:order) {
			for (int i = 9; i >= 0; i--) {
				for (int j = 0; j < 10; j++) {
					if(copy[i][j]==1 && i+k-1 < 10 && j+k-1 < 10 && checkVaild(i, j, k) && paper[k]>0) {											
						markPaper(i, j, k);						
						cnt++;
						paper[k]--;
						System.out.println("-----------------"+ k +"-----------------");
						for(int[] a:copy) {
							System.out.println(Arrays.toString(a));
						}
					}
				}				
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(copy[i][j]==1)cnt=-1;
			}
		}
		System.out.println("아래:"+cnt);
		if(MIN==Integer.MAX_VALUE)MIN=cnt;
		else if(MIN==-1 && cnt >= 0)MIN=cnt;
		else if(cnt < MIN && cnt >= 0)MIN=cnt;
	}
	private static void order(int idx, int end, int[] temp, boolean[] visit) {
		if(idx==end) {
			orderTest(temp);
			return;
		}
		for (int i = 5; i >= 1; i--) {
			if(!visit[i-1]) {
				temp[idx] = i;
				visit[i-1] = true;
				order(idx+1, end, temp, visit);
				visit[i-1] = false;
			}
		}		
	}
	private static void markPaper(int r, int c, int k) {
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < k; j++) {
				copy[r+i][c+j] = 0;
			}
		}
	}
	private static boolean checkVaild(int r, int c, int k) {		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < k; j++) {
				if(copy[r+i][c+j]!=1)return false;
			}
		}
		return true;
	}
}
