package Baekjoon;

import java.io.*;

public class Main_2748 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long[] fibo = new long[N+1];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int idx = 2; idx <= N; idx++) {
			fibo[idx] = fibo[idx-1] + fibo[idx-2];
		}
		System.out.println(fibo[N]);
	}
}
