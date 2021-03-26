package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_2776 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(bf.readLine());
			int[] note = new int[N];
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < note.length; i++) {
				note[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(note);
			int M = Integer.parseInt(bf.readLine());			
			st = new StringTokenizer(bf.readLine(), " ");
			for (int m = 0; m < M; m++) {
				int target = Integer.parseInt(st.nextToken());
				int left = 0;			
				int right = N-1;
				boolean check = false;
				while(left <= right) {
					int mid = (left+right)/2;
					if(note[mid]==target) {
						check = true;
						break;
					} else if(note[mid]>target) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				}
				if(check)bw.write("1\n");
				else bw.write("0\n");
			}			
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
