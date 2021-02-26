package Leetcode;

import java.util.Stack;

public class Solution_946 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0)return true;
        int push = 0, pop = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[push]);
        push++;
        while(true){
            if(push==pushed.length&&pop==popped.length)return true;
            if(push==pushed.length&&stack.peek()!=popped[pop])return false;
            if(stack.isEmpty()){
                stack.push(pushed[push]);
                push++;
            }
            if(stack.peek()==popped[pop]){
                stack.pop();
                pop++;
            } else {
                stack.push(pushed[push]);
                push++;
            }
        }
    }
}
