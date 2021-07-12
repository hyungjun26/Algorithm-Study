package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17143 {
	static int R, C, M;
	static Shark[] sharks;
	static Shark[][] map;
	static int ans = 0;
	static List<Shark> list = new ArrayList<>();
	static class Shark{
		int r, c, s, d, z, idx;
		public Shark(int r, int c, int s, int d, int z, int idx) {			
			this.r = r;//행
			this.c = c;//열
			this.s = s;//속력
			this.d = d;//방향
			this.z = z;//크기
			this.idx = idx;
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharks = new Shark[M];
		
		for (int i = 0; i < sharks.length; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(r, c, s, d, z, i);
		}
		for(int i = 1; i <= C; i++) {
			map = new Shark[R+1][C+1];
			for (int j = 0; j < sharks.length; j++) {
				if(sharks[j] != null) {
					map[sharks[j].r][sharks[j].c] = sharks[j];
				}				
			}
			for (int j = 1; j <= R; j++) {
				if(map[j][i]!=null) {
					ans += map[j][i].z;
					sharks[map[j][i].idx] = null;
					break;
				}
			}
			map = new Shark[R+1][C+1];
			// 이동
			for (int j = 0; j < sharks.length; j++) {
				if(sharks[j]!=null) {
					int dist = sharks[j].s;
					int dir = sharks[j].d;
					int row = sharks[j].r;
					int col = sharks[j].c;
					while(dist!=0) {
						switch (dir) {
						case 1://위
							if(row==1) {
								dir=2;
							}
							else {
								row--;
								dist--;
							}							
							break;
						case 2://아래
							if(row==R) {
								dir=1;
							}
							else {
								row++;
								dist--;
							}			
							break;
						case 3://오른
							if(col==C) {
								dir=4;
							}
							else {
								col++;
								dist--;
							}			
							break;
						case 4://왼
							if(col==1) {
								dir=3;
							}
							else {
								col--;
								dist--;
							}
							break;
						}
					}
					sharks[j].d = dir;
					sharks[j].r = row;
					sharks[j].c = col;
					if(map[row][col] != null) {
						if(map[row][col].z > sharks[j].z) {
							sharks[j]=null;
						}
						else {
							sharks[map[row][col].idx] = null;
							map[row][col] = sharks[j];
						}
					}
					else map[row][col] = sharks[j];
				}
			}
			
			
		}
		System.out.println(ans);
	}
}
