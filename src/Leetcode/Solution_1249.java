package Leetcode;

import java.util.Stack;

public class Solution_1249 {
	public String minRemoveToMakeValid(String s) {
        String ans = "";
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i]=='(')stack.add(i);
            if(arr[i]==')'){
                if(!stack.isEmpty())stack.pop();
                else arr[i] = '0';
            }
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            arr[idx] = '0';
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i]!='0')ans+=Character.toString(arr[i]);
        }
        return ans;
    }
}
