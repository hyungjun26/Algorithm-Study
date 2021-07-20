package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_10159 {
	static int N, M;
	static boolean[][] data;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		data = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			data[a][b] = true;
			//data[b][a] = true;
		}				
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i==j || !data[i][k] || !data[k][j])continue;
					if(!data[i][j] && data[k][j]) {
						data[i][j] = true;						
					} 
				}				
			}			
		}
		StringBuilder sb = new StringBuilder();		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if((!data[j][i]&&!data[i][j])&&i!=j)cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}
