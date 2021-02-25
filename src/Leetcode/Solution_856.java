package Leetcode;

import java.util.Stack;

public class Solution_856 {
	public int scoreOfParentheses(String S) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i)=='('){
                stack.push(ans);
                ans = 0;
            } else {
                ans = stack.pop() + Math.max(ans*2,1);
            }
        }
        return ans;
    }   
}
