package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < data.length; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		int e = 0;
		int sum = 0;
		for (int s = 0; s < N; s++) {
			while(sum < M && e < N) {
				sum += data[e];
				e++;				
			}
			if(sum==M)cnt++;
			sum -= data[s];
		}
		System.out.println(cnt);
	}

}
