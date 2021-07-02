package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1717 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] group = new int[N+1];
		for(int i = 0; i < group.length; i++)group[i] = i;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(t==0) {
				unionParents(group, a, b);
			}else {
				boolean check = findParents(group, a, b);
				if(check) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	public static int getParents(int[] parents, int x) {
		if(parents[x]==x)return x;
		return parents[x] = getParents(parents, parents[x]);
	}
	
	public static void unionParents(int[] parents, int a, int b) {
		a = getParents(parents, a);
		b = getParents(parents, b);
		if(a < b)parents[b] = a;
		else parents[a] = b;
	}
	
	public static boolean findParents(int[] parents, int a, int b) {
		a = getParents(parents, a);
		b = getParents(parents, b);
		if(a==b)return true;
		return false;
	}
}
