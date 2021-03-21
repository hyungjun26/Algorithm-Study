package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < data.length; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int max = Integer.MIN_VALUE;
		for (int start = 0; start <= data.length - K; start++) {
			int sum = 0;
			int end = start;
			while(end < start + K) {
				sum += data[end];
				end++;
			}
			if(sum > max)max = sum;
		}
		System.out.println(max);
	}
}
