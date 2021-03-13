package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1806 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < data.length; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int minLen = Integer.MAX_VALUE;
		int right = 0;
		int sum = 0;
		for (int left = 0; left < data.length; left++) {
			while(sum<S && right<N) {
				sum+=data[right];
				right++;
			}
			if(sum>=S && right-left < minLen) {
				minLen = right-left;
			}
			sum-=data[left];
		}
		if(minLen==Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(minLen);
		}
	}
}
