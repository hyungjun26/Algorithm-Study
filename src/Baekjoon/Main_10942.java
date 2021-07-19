package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_10942 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		int[] data = new int[N];
		boolean[][] dp = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < data.length; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(bf.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int S = Integer.parseInt(st.nextToken()) - 1;
			int E = Integer.parseInt(st.nextToken()) - 1;
			int mid = (S + E) / 2;			
			if(!dp[S][E] && !dp[E][S]) {
				boolean check = true;
				for(int s = S , e = E;s <= mid; s++, e--) {
					if(data[e]!=data[s]) {
						check = false;
						break;
					}				
				}
				dp[S][E] = true;
				dp[E][S] = check;
			}
			if(dp[E][S]) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}			
		}
		System.out.println(sb);
	}
}
