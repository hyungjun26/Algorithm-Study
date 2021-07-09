package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17135 {
	static int N, M, D;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		archerLoc(0, 3, new int[3], 0, new boolean[M]);
		System.out.println(max);
	}
	private static void archerLoc(int idx, int end, int[] temp, int prev, boolean[] visit) {
		if(idx==end) {
			playGame(temp);
			return;
		}
		for (int i = prev; i < M; i++) {
			if(!visit[i]) {
				visit[i] = true;
				temp[idx] = i;
				archerLoc(idx+1, end, temp, i, visit);
				visit[i] = false;
			}
		}
	}
	private static void playGame(int[] loc) {
		int[][] temp = new int[N+1][M];	
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = Arrays.copyOf(map[i], map[i].length);
		}
		
		boolean keep = true;
		int cnt = 0;
		while(keep) {
			int[][] attack = new int[3][3];
			// 공격대상 찾기
			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < M; i++) {//열
					for (int j = N-1; j >= 0; j--) {//행
						int dist = Math.abs(N-j)+Math.abs(loc[k]-i);
						if(temp[j][i]==1 && dist <= D) {							
							if(attack[k][2]>dist) {
								attack[k][0] = j;
								attack[k][1] = i;
								attack[k][2] = dist;								
							} else if(attack[k][2]==0) {
								attack[k][0] = j;
								attack[k][1] = i;
								attack[k][2] = dist;
							}							
						}
					}
				}
			}			
			// 적 제거
			for (int i = 0; i < attack.length; i++) {				
				if(attack[i][2]!=0&&temp[attack[i][0]][attack[i][1]]==1) {
					temp[attack[i][0]][attack[i][1]] = 0;
					cnt++;
				}
			}			
			// 적 이동
			for (int i = N-1; i > 0; i--) {
				temp[i] = Arrays.copyOf(temp[i-1], temp[i-1].length);
			}
			temp[0] = Arrays.copyOf(new int[M], M);
			// 남아있는 적 확인
			keep = false;			
			outer:for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(temp[i][j]==1) {
						keep=true;
						break outer;
					}
				}
			}
		}
		if(cnt>max)	max=cnt;
	}
}
