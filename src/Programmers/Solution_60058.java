package Programmers;

import java.util.Stack;

class Solution_60058 {
    public static String solution(String p) {
        if(check(p))return p;
		String answer = "";
		if(p.length()==0)return "";
		for (int i = 2; i <= p.length(); i += 2) {
			String u = p.substring(0, i);
			String v = p.substring(i);
			if (pair(u) && pair(v)) {
				System.out.println(u + " " + v);
				boolean first = check(u);
				boolean second = check(v);
				if(first && second) {
					return u + v;
				} else if(first && !second) {
					return u+solution(v);
				}  else {
					String fix = "(" + solution(v) + ")";
					u = u.substring(1, u.length()-1);
					String temp = "";
					for (int j = 0; j < u.length(); j++) {
						if(u.charAt(j)=='(')temp+=")";
						else temp+="(";
					}
					return fix + temp;
				}
			}
		}
		return answer;
	}

	private static boolean check(String str) {
		if(str.length()==0)return true;
		if(str.charAt(0)==')')return false;
		Stack<Character> open = new Stack<>();
		boolean correct = true;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='(')open.push(str.charAt(i));
			else if(str.charAt(i)==')' && !open.empty()) {
				open.pop();
			} else {
				correct = false;
				break;
			}
		}		
		return correct;
	}

	private static boolean pair(String str) {
		if(str.length()==0)return true;
		int open = 0;
		int close = 0;
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '(':
				open++;
				break;
			case ')':
				open--;
				break;
			}
			
		}
		if(open==close)return true;
		else return false;
	}
}