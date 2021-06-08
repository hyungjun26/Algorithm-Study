package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_11404 {
	static int N, M;
	static int[][] min;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		min = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());			
			if(min[start][end]==0) {
				min[start][end] = price;
			}
			else if(min[start][end]>price) {
				min[start][end] = price;
			}
		}
		floydWarshall();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(min[i][j] + " ");
			}
			System.out.println();
		}
	}	
	private static void floydWarshall() {
		for (int k = 1; k <= N; k++) {//경유
			for (int i = 1; i <= N; i++) {//출발
				for (int j = 1; j <= N; j++) {//도착
					if(i==j||min[k][j]==0||min[i][k]==0)continue;
					if(min[i][j] > min[i][k]+min[k][j]) {
						min[i][j] = min[i][k]+min[k][j];
					} else if(min[i][j]==0) {
						min[i][j] = min[i][k]+min[k][j];
					}					
				}
			}
		}
		
	}

}
