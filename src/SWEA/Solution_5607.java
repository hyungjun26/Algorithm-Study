package SWEA;

import java.io.*;
import java.util.*;

public class Solution_5607 {
	static int TC, N, R, MOD = 1234567891;
	static long[] nf, rf;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			nf = new long[R];
			rf = new long[R+1];
			nf[0] = N; rf[0]=1;
			for (int i = 1; i < R; i++) {
				nf[i] = nf[i-1] * (N - i) % MOD;					
			}
			for (int i = 1; i <= R; i++) {
				rf[i] = rf[i-1] * i % MOD;
			}
			int g = getGCD((int)MOD-1, (int)rf[R]);
			sb.append(nf[R-1]/g).append("\n");			
		}
		System.out.println(sb);
	}
	public static int getGCD(int big, int small) {
        int tmp = 0;
        while (big != 0) {
            if (big < small) {
                tmp = big;
                big = small;
                small = tmp;
            }
            big = big % small;
        }
        return small;
    }
}
