package Baekjoon;

import java.io.*;

public class Main_1003 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		long[][] fibo = new long[41][3];
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[0][2] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		fibo[1][2] = 1;
		for (int idx = 2; idx < fibo.length; idx++) {
			fibo[idx][0] = fibo[idx-1][0] + fibo[idx-2][0];
			fibo[idx][1] = fibo[idx-1][1] + fibo[idx-2][1];
			fibo[idx][2] = fibo[idx-1][2] + fibo[idx-2][2];
		}
		StringBuilder sb = new StringBuilder();
		for (int test = 0; test < T; test++) {
			int target = Integer.parseInt(bf.readLine());
			sb.append(fibo[target][0] + " " + fibo[target][1] + "\n");
		}
		System.out.println(sb);
	}
}