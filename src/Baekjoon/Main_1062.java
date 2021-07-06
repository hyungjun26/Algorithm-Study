package Baekjoon;

import java.io.*;
import java.util.*;

public class Main_1062 {
	static int N, K;	
	static char[] alphabet = {'a','n','t','i','c'};
	static boolean[] visit = new boolean[26];
	static String[] words;
	static int MAX = 0;
	static List<Character> dict = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());		
		words = new String[N];		
		for (int i = 0; i < N; i++) {
			words[i] = bf.readLine();			
		}
		if(K<5) {
			System.out.println(0);
			return;
		} else if(K==26) {
			System.out.println(N);
			return;
		}
		for (int i = 0; i < alphabet.length; i++) {
			visit[alphabet[i]-97] = true;
		}
		for (int i = 0; i < N; i++) {
			String str = words[i];
			str = str.substring(0,str.length()-4);
			str = str.substring(4);
			for (int j = 0; j < str.length(); j++) {
				if(!dict.contains(str.charAt(j))&&!visit[str.charAt(j)-97]) {
					dict.add(str.charAt(j));
				}
			}
		}
		if(dict.size()+alphabet.length<=K) {
			for(char a:dict) {
				visit[a-97] = true;
			}
			checkWord();
		}
		else {
			dfs(5, K, 0);
		}				
		System.out.println(MAX);
	}
	private static void dfs(int idx, int end, int prev) {
		if(idx==end) {
			checkWord();			
			return;
		}
		for (int i = prev; i < dict.size(); i++) {
			if(!visit[dict.get(i)-97]) {				
				visit[dict.get(i)-97] = true;				
				dfs(idx+1, end, i+1);
				visit[dict.get(i)-97] = false;
			}
		}
	}
	private static void checkWord() {
		int cnt = 0;		
		for (int i = 0; i < words.length; i++) {
			boolean check = validateCheck(words[i]);
			if(check)cnt++;
		}		
		if(cnt>MAX) {
			MAX = cnt;			
		}
	}
	private static boolean validateCheck(String word) {
		for (int i = 0; i < word.length(); i++) {			
			if(!visit[word.charAt(i)-97])return false;
		}
		return true;
	}
}
