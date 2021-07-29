package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_3273 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] data = new int[N];
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());
		Arrays.sort(data);
		int left = 0;
		int right = N-1;
		int ans = 0;
		while(left<right) {
			int sum = data[left] + data[right];
			if(sum==X) {
				ans++;
				left++;
				right--;
			}else if(sum < X) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(ans);
	}
}
