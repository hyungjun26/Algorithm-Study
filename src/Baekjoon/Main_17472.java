package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17472 {
	static int N, M;
	static int[][] map, dist;
	static boolean[][] mark;
	static int MIN = Integer.MAX_VALUE;
	static List<Integer>[] graph;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mark = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				if (map[i][j]==1 && !mark[i][j]) {
					map[i][j] = cnt;
					mark[i][j] = true;
					markIsland(i, j, cnt);
					cnt++;
				}
			}
		}
		dist = new int[cnt][cnt];
		for(int[] temp:dist) {
			Arrays.fill(temp, 99);
		}
		graph = new List[cnt];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				if (map[i][j]!=0) {
					for (int k = 0; k < dir.length; k++) {
						int row = i+dir[k][0];
						int col = j+dir[k][1];
						if(isIn(row, col) && map[row][col]==0) {
							int d = 1;
							while(true) {
								if(!isIn(row+dir[k][0], col+dir[k][1]))break;
								if(map[row+dir[k][0]][col+dir[k][1]]!=0) {
									int start = map[i][j];
									int dest = map[row+dir[k][0]][col+dir[k][1]];
									if(d > 1 && dist[start][dest] > d) {
										dist[start][dest]=d;
										graph[start].add(dest);
									}
									break;
								}
								row = row+dir[k][0];
								col = col+dir[k][1];
								d++;
							}
						}
					}
				}
			}
		}
		for(int[] a:dist) {
			System.out.println(Arrays.toString(a));
		}
		for(List<Integer> list:graph) {
			System.out.println(list);
		}
		for(int i = 1; i < cnt; i++) {
			int[] temp = new int[cnt-1];
			temp[0] = i;
			boolean[] visit = new boolean[cnt];
			visit[i] = true;
			dfs(i, 1, cnt-1, temp, visit);
		}
		if(MIN==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(MIN);
	}
	private static void dfs(int start, int idx, int end, int[] temp, boolean[] visit) {
		if(idx==end) {
			System.out.println(Arrays.toString(temp));
			int sum = 0;
			for (int i = 0; i < temp.length-1; i++) {
				System.out.print(dist[temp[i]][temp[i+1]] + " ");
				sum += dist[temp[i]][temp[i+1]];
			}
			System.out.println();
			if(MIN>sum)MIN=sum;
			return;
		}
		for (int i = 0; i < graph[start].size(); i++) {
			int cur = graph[start].get(i);
			if(!visit[cur] && dist[start][cur] < 99) {
				visit[cur] = true;
				temp[idx] = cur;
				dfs(cur, idx+1, end, temp, visit);
				visit[cur] = false;
			}
		}
	}
	private static void markIsland(int i, int j, int cnt) {
		for (int k = 0; k < dir.length; k++) {
			int r = i + dir[k][0];
			int c = j + dir[k][1];
			if(isIn(r,c) && !mark[r][c] && map[r][c] == 1) {
				mark[r][c] = true;
				map[r][c] = cnt;
				markIsland(r, c, cnt);
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r < N && r >= 0 && c < M && c >= 0;
	}
}
