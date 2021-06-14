package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingMU3DUT-FPM/
public class lesson7_Nesting {
	public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        char[] ch = S.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(ch[i]=='(')stack.push('(');
            else{
                if(stack.isEmpty())return 0;
                stack.pop();
            }
        }
        if(!stack.isEmpty())return 0;
        return 1;
    }
}
