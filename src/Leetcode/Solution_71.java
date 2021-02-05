package Leetcode;

import java.util.*;
class Solution_71 {
    public String simplifyPath(String path) {
        for(int i = 0; i < path.length()-1; i++){
            if(path.substring(i,i+2).equals("//")){
                String temp = path.substring(i+2);
                path = path.substring(0,i+1) + temp;
            }
        }
        StringTokenizer st = new StringTokenizer(path, "/");
        
        Stack<String> stack = new Stack<>();
        while(st.hasMoreTokens()){
            String word = st.nextToken();
            switch(word){
                case "..":
                    if(!stack.isEmpty())stack.pop();
                    break;
                case ".":
                    break;
                default:
                    stack.push(word);
                    break;
            }
        }
        String newPath = "";
        if(stack.isEmpty())newPath="/";
        while(!stack.isEmpty()){
            newPath = "/"+stack.pop()+newPath;
        }
        return newPath;
    }
}
