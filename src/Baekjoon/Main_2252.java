package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2252 {
	static int N, M;
	static List<Integer>[] tall;
	static boolean check = false;
	static int[] seq;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tall = new List[N+1];
		seq = new int[N+1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			tall[i] = new ArrayList<>();
			
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tall[a].add(b);
			seq[b]++;
		}
		for (int i = 1; i < seq.length; i++) {
			if(seq[i]==0)queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int front = queue.poll();
			if(seq[front]==0) {
				sb.append(front + " ");
				for(int i = 0; i < tall[front].size(); i++) {
					int big = tall[front].get(i);
					seq[big]--;
					if(seq[big]==0)queue.offer(big);
				}
			}else {
				queue.offer(front);
			}
		}
		sb.append("\n");
		System.out.println(sb);
	}
}
