package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17472_kruskal {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static class Edge implements Comparable<Edge>{
		int[] node = new int[2];
		int distance;
		public Edge(int a, int b, int d) {
			this.node[0] = a;
			this.node[1] = b;
			this.distance = d;
		}
		@Override
		public int compareTo(Edge other) {			
			return this.distance-other.distance;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[N][M];
		int cnt = 1;
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					visit[i][j] = true;
					map[i][j] = cnt;
					markIsland(i, j, cnt);
					cnt++;
				}
			}
		}		
		int res = findPath(cnt);
		System.out.println(res);
	}
	private static int getParent(int[] parent, int x) {
		if(parent[x]==x)return x;
		else return parent[x] = getParent(parent, parent[x]);
	}
	private static void unionFind(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	private static boolean findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a==b) return true;
		else return false;
	}
	private static int findPath(int cnt) {
		int ans = 0;
		// 섬 간의 경로 길이 구하기
		int[][] distance = new int[cnt][cnt];
		for(int[] d:distance) {
			Arrays.fill(d, -1);
		}
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					for (int k = 0; k < dir.length; k++) {
						int r = i + dir[k][0];
						int c = j + dir[k][1];
						if(isIn(r, c) && map[r][c]==0) {
							int dx = dir[k][0];
							int dy = dir[k][1];
							int dist = 1;
							while(true) {
								if(!isIn(r+dx, c+dy))break;
								if(map[r+dx][c+dy]>0) {
									int a = map[i][j];
									int b = map[r+dx][c+dy];
									if(dist==1)break;
									if(distance[a][b]==-1||distance[a][b]>dist) {
										distance[a][b] = dist;
										distance[b][a] = dist;										
									}
									break;
								}
								r += dx;
								c += dy;
								dist++;
							}
						}
					}
				}
			}
		}		
		List<Edge> v = new ArrayList<>();
		for (int i = 1; i < distance.length; i++) {
			for (int j = i+1; j < distance.length; j++) {
				if(distance[i][j]!=-1) {
					v.add(new Edge(i, j, distance[i][j]));
				}
			}
		}
		v.sort(null);
		int[] parent = new int[cnt];
		for(int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < v.size(); i++) {
			if(!findParent(parent, v.get(i).node[0], v.get(i).node[1])) {
				ans += v.get(i).distance;
				unionFind(parent, v.get(i).node[0], v.get(i).node[1]);
			}
		}		
		for (int i = 1; i < parent.length; i++) {
			getParent(parent, i);
			if(parent[i]!=1)ans=-1;
		}		
		return ans;
	}
	private static void markIsland(int r, int c, int cnt) {
		for (int i = 0; i < dir.length; i++) {
			int row = r + dir[i][0];
			int col = c + dir[i][1];
			if(isIn(row, col) && !visit[row][col] && map[row][col] == 1) {
				visit[row][col] = true;
				map[row][col] = cnt;
				markIsland(row, col, cnt);
			}
		}		
	}
	private static boolean isIn(int row, int col) {
		return row < N && row >= 0 && col < M && col >= 0;
	}
}
