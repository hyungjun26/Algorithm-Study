package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long[] wires = new long[K];
		long maxWire = 0;
		for (int i = 0; i < wires.length; i++) {
			wires[i] = Integer.parseInt(bf.readLine());
			if(maxWire < wires[i])maxWire = wires[i];
		}
		long cutLength = 0;
		long mid = 0;
		long maxLength = 0;
		while(maxWire >= cutLength) {
			mid = (maxWire + cutLength) / 2;
			if(mid==0) {
				maxLength=1;
				break;
			}
			int cnt = 0;
			for (int i = 0; i < wires.length; i++) {
				if(mid <= wires[i]) {
					cnt += (wires[i] / mid);
				}
			}
			if(cnt >= N) {
				maxLength = mid;
				cutLength = mid + 1;
			} else {
				maxWire = mid - 1;
			}
		}
		System.out.println(maxLength);
	}

}
