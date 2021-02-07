package Baekjoon;

import java.util.*;
import java.io.*;

public class Main_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		int high = 0; //right
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < trees.length; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(high < trees[i])high = trees[i];
		}
		int maxHeight = 0;
		int mid = 0;
		int cutHeight = 0;// left
		
		while(high >= cutHeight) {
			mid = (high + cutHeight) / 2;
			long sum = 0;
			for (int i = 0; i < trees.length; i++) {
				if(mid < trees[i]) {
					sum += trees[i] - mid;
				}
			}
			if(sum >= M) {
				maxHeight = mid;
				cutHeight = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(maxHeight);
	}
}
