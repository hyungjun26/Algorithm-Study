package Codility;

import java.util.*;

// RESULT = https://app.codility.com/demo/results/trainingK5BFV4-MZW/
public class lesson7_Brackets {
	public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        char[] ch = S.toCharArray();
        for(int i = 0; i < ch.length; i++){
            switch(ch[i]){
                case ')':
                    if(stack.isEmpty()||stack.peek()!='(')return 0;
                    stack.pop();
                    break;
                case '}':
                    if(stack.isEmpty()||stack.peek()!='{')return 0;
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty()||stack.peek()!='[')return 0;
                    stack.pop();
                    break;
                default:
                    stack.push(ch[i]);
                    break;
            }
        }
        if(!stack.isEmpty())return 0;
        return 1;
    }
}
