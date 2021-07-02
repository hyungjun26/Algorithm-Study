package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1976 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		int[] point = new int[N];
		for(int i = 0; i < point.length; i++)point[i] = i;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int n = 0;
			while(st.hasMoreTokens()) {
				int type = Integer.parseInt(st.nextToken());
				if(type==1) {
					unionParents(point, i, n);
				}
				n++;
			}
		}
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		start = point[start];
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken())-1;
			if(start!=point[num]) {
				System.out.println("NO");
				return;
			}			
		}
		System.out.println("YES");
	}
	
	public static int getParents(int[] point, int x) {
		if(point[x]==x)return x;
		return point[x] = getParents(point, point[x]);
	}
	
	public static void unionParents(int[] point, int a, int b) {
		a = getParents(point, a);
		b = getParents(point, b);
		if(a < b)point[b] = a;
		else point[a] = b;
	}
	
	public boolean findParents(int[] point, int a, int b) {
		a = getParents(point, a);
		b = getParents(point, b);
		if(a==b)return true;
		return false;				
	}

}
