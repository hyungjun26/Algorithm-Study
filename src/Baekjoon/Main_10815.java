package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_10815 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(bf.readLine());
		int[] find = new int[M];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int res = binarySearch(find[i], data);
			sb.append(res + " ");
		}
		System.out.println(sb);
	}

	private static int binarySearch(int target, int[] data) {
		int answer = 0;
		int mid;
		int left = 0;
		int right = data.length-1;
		while(true) {
			if(left > right)break;
			mid = (left+right)/2;			
			if(data[mid]==target) {
				answer = 1;
				break;
			}
			if(data[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

}
