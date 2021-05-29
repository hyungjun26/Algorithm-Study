package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_6987 {
	static boolean check;
	static int[][] record;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			record = new int[6][3];
			check = false;
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int sum = 0;
			for (int j = 0; j < 6; j++) {
				record[j][0] = Integer.parseInt(st.nextToken());//win
				record[j][1] = Integer.parseInt(st.nextToken());//draw
				record[j][2] = Integer.parseInt(st.nextToken());//lose
				sum += (record[j][0]+record[j][1]+record[j][2]);
			}
			if(sum!=30) {
				sb.append("0 ");
				continue;
			} else {
				playGame(0,1);
				if(check)sb.append("1 ");
				else sb.append("0 ");
			}
		}
		System.out.println(sb);
	}
	private static void playGame(int A, int B) {
		if(A==6) {
			check = true;
			return;
		}else if(B==6) {
			playGame(A+1, A+2);
		}
		//이기는 경우
		if(record[A][0] > 0 && record[B][2] > 0) {
			record[A][0]--;record[B][2]--;
			playGame(A, B+1);
			record[A][0]++;record[B][2]++;
		}
		//무승부일 경우
		if(record[A][1] > 0 && record[B][1] > 0) {
			record[A][1]--;record[B][1]--;
			playGame(A, B+1);
			record[A][1]++;record[B][1]++;
		}
		//패배일 경우
		if(record[A][2] > 0 && record[B][0] > 0) {
			record[A][2]--;record[B][0]--;
			playGame(A, B+1);
			record[A][2]++;record[B][0]++;
		}
	}
}