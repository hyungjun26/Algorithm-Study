package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17471 {
	static List<Integer>[] graph;
	static int[] data;
	static int N;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		graph = new List[N+1];
		data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();			
		}
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= N/2; i++) {
			perm(0, i, 1, new boolean[N+1], new int[i]);
		}
		if(min==Integer.MAX_VALUE)min = -1;
		System.out.println(min);		
	}
	private static void perm(int idx, int end, int prev, boolean[] visit, int[] temp) {
		if(idx == end) {			
			int[] another = new int[N-end];
			int index = 0;
			for(int i = 1; i <= N; i++) {
				boolean check = true;
				for (int j = 0; j < temp.length; j++) {
					if(i==temp[j])check=false;
				}
				if(check) {
					another[index] = i;
					index++;
				}
			}			
			groupCheck(temp, another);
			
		}else {
			for(int i = prev; i <= N; i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[idx] = i;
					perm(idx+1, end, i, visit, temp);
					visit[i] = false;
				}
			}
		}		
	}
	private static void groupCheck(int[] A, int[] B) {
		visited = new boolean[N+1];
		for (int i = 0; i < B.length; i++) {
			visited[B[i]] = true;
		}
		visited[A[0]] = true;
		makeGroup(A[0]);		
		for (int i = 0; i < A.length; i++) {
			if(!visited[A[i]])return;		
		}
		for (int i = 0; i < B.length; i++) {
			visited[B[i]] = false;
		}
		visited[B[0]] = true;
		makeGroup(B[0]);		
		for (int i = 0; i < B.length; i++) {
			if(!visited[B[i]]) return;
		}
		int sizeA = 0, sizeB = 0;
		for (int i = 0; i < A.length; i++) {
			sizeA += data[A[i]];
		}
		for (int i = 0; i < B.length; i++) {
			sizeB += data[B[i]];
		}
		int sub = Math.abs(sizeA - sizeB);
		if(min>sub)min=sub;
	}
	private static void makeGroup(int start) {
		for (int i = 0; i < graph[start].size(); i++) {
			if(!visited[graph[start].get(i)]) {
				visited[graph[start].get(i)] = true;
				makeGroup(graph[start].get(i));
			}
		}		
	}	
}