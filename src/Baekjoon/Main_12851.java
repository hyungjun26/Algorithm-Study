package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_12851 {
	static int[] map = new int[100001];
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
		int count = 0;
		Queue<Position> que = new LinkedList<>();
		que.add(new Position(N, 0));
		Arrays.fill(map, Integer.MAX_VALUE);
		while (!que.isEmpty()) {
			Position current = que.poll();
			if (current.p == K && result > current.t) {
				result = current.t;
				count = 1;
			} else if (current.p == K && result == current.t) {
				count++;
			}			
			if ((0 <= current.p - 1 && 100001 > current.p - 1) && map[current.p] >= current.t+1) {
				que.add(new Position(current.p - 1, current.t + 1));
				map[current.p] = current.t+1;
			}
			if ((0 <= current.p + 1 && 100001 > current.p + 1) && map[current.p] >= current.t+1) {
				que.add(new Position(current.p + 1, current.t + 1));
				map[current.p] = current.t+1;
			}
			if ((0 <= current.p * 2 && 100001 > current.p * 2) && map[current.p] >= current.t+1) {
				que.add(new Position(current.p * 2, current.t + 1));
				map[current.p] = current.t+1;
			}
		}
		System.out.println(result);
		System.out.println(count);
	}

}