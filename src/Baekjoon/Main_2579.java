package Baekjoon;

import java.io.*;

public class Main_2579 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());		
		int[] data = new int[N+1];
		int[][] step = new int[N+1][2];
		for(int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(bf.readLine());
		}
		if(N==1) {
			System.out.println(data[1]);
			return;
		}
		step[1][0] = data[1];
		step[1][1] = 0;		
		step[2][0] = data[2];
		step[2][1] = data[1] + data[2];
		
		for(int i = 3; i <= N; i++) {
			step[i][0] = Math.max(step[i-2][0], step[i-2][1]) + data[i];
			step[i][1] = step[i-1][0]+data[i];//연속으로 계단을 오를수 없기때문에
		}
		System.out.println(Math.max(step[N][0], step[N][1]));
	}
}
