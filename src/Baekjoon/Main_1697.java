package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1697 {
	static int[] map = new int[100001];
	static boolean[] visit = new boolean[100001];

	static class Position {
		int p, t;

		public Position(int p, int t) {
			this.p = p;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = Integer.MAX_VALUE;
		Queue<Position> que = new LinkedList<>();
		que.add(new Position(N, 0));
		visit[N] = true;
		while (!que.isEmpty()) {
			Position current = que.poll();
			if (current.p == K && result > current.t) {
				result = current.t;
				break;
			}
			if ((0 <= current.p - 1 && 100001 > current.p - 1) && !visit[current.p - 1]) {
				que.add(new Position(current.p - 1, current.t + 1));
				visit[current.p - 1] = true;
			}
			if ((0 <= current.p + 1 && 100001 > current.p + 1) && !visit[current.p + 1]) {
				que.add(new Position(current.p + 1, current.t + 1));
				visit[current.p + 1] = true;
			}
			if ((0 <= current.p * 2 && 100001 > current.p * 2) && !visit[current.p * 2]) {
				que.add(new Position(current.p * 2, current.t + 1));
				visit[current.p * 2] = true;
			}
		}
		System.out.println(result);
	}
}
