package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_17281 {
	static int[][] inning;
	static int[] seq = new int[9];
	static int MAX = 0, N;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		inning = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < inning[i].length; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		boolean[] visit = new boolean[9];
		seq[3] = 0;
		visit[0] = true;
		dfs(0, 9, seq, visit);
		System.out.println(MAX);
	}
	private static void dfs(int idx, int end, int[] seq, boolean[] visit) {
		if(idx == end) {			
			playGame();
			return;
		}
		if(idx == 3) {
			dfs(idx+1, end, seq, visit);
		} else {
			for (int i = 1; i < visit.length; i++) {
				if(!visit[i]) {
					visit[i] = true;
					seq[idx] = i;
					dfs(idx+1, end, seq, visit);
					visit[i] = false;
				}
			}
		}		
	}
	private static void playGame() {		
		int score = 0;		
		int num = 0;
		for(int i = 0; i < N; i++) {
			int out = 0;
			int[] base = new int[3];
			while(out<3) {
				int play = inning[i][seq[num]];
				switch (play) {
				case 0:
					out++;
					break;
				case 1:
					score += base[2];
					for(int j = 2; j > 0; j--) {
						base[j] = base[j-1];
					}
					base[0] = 1;
					break;
				case 2:
					score += base[2];
					score += base[1];
					base[2] = base[0];
					base[1] = 1;
					base[0] = 0;
					break;
				case 3:
					for(int j = 0; j < 3; j++) {
						score += base[j];
						base[j] = 0;
					}
					base[2] = 1;
					break;
				case 4:
					for(int j = 0; j < 3; j++) {
						score += base[j];
						base[j] = 0;
					}
					score++;
					break;
				}
				num++;
				if(num == 9) num = 0;
			}
		}		
		if(score > MAX) MAX = score;
	}
}