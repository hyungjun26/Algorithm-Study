package Baekjoon;

import java.util.*;
import java.io.*;

public class Main_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] loc = new int[N];
		for (int i = 0; i < loc.length; i++) {
			loc[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(loc);
		int left = 0;
		int mid;
		int right = loc[N-1]-loc[0];
		int max = 0;
		while(left <= right) {
			int cnt = 1;
			mid = (left+right)/2;
			int idx = 0;
			int gap = mid;
			for (int i = 1; i < loc.length; i++) {
				if(loc[i]-loc[idx]>=gap) {
					idx = i;
					cnt++;
				}
			}
			if(cnt >= C) {
				left = mid+1;
				max = mid;
			} else {
				right = mid-1;
			}
		}
		System.out.println(max);
	}
}
