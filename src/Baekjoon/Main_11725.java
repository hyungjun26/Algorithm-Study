package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11725 {	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(bf.readLine());
		int[] result = new int[N+1];
		List<Integer>[] list = new List[N+1];
		for(int n = 1; n <= N; n++) {
			list[n] = new ArrayList<>();
		}
		for(int i = 2; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());	
			list[A].add(B);
			list[B].add(A);
		}
		dfs(list, result, N, 1, 0);
		StringBuilder sb = new StringBuilder();
		for(int idx = 2; idx <= N; idx++) {
			sb.append(result[idx]+"\n");
		}
		System.out.println(sb);
		
	}

	private static void dfs(List<Integer>[] list, int[] result, int N, int idx, int parent) {
		result[idx] = parent;
		for(int node : list[idx]) {
			if(node!=parent)dfs(list, result, N, node, idx);
		}
		
	}

}
