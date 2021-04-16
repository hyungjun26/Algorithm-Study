package Programmers;

import java.util.*;

class Solution_43164 {
    static String[] answer;
    public String[] solution(String[][] tickets) {
        answer = null;
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                String[] path = new String[tickets.length+1];
                boolean[] visited = new boolean[tickets.length];
                path[0] = "ICN";
                path[1] = tickets[i][1];
                visited[i] = true;
                dfs(2, tickets.length+1, tickets[i][1], tickets, visited, path);
            }
        }
        return answer;
    }
    private void dfs(int idx, int end, String current, String[][] tickets, boolean[] visited, String[] path){
        if(idx==end){    		
    		if(answer == null) {
    			answer = Arrays.copyOf(path, path.length);    			
    		} else if(answer != null) {
    			for(int j = 1; j < path.length; j++) {
    				if(answer[j].compareTo(path[j]) > 0&& answer[j-1].compareTo(path[j-1]) == 0) {
    					answer = Arrays.copyOf(path, path.length);    					
    				} else if(answer[j].compareTo(path[j]) < 0) break;
    			}
    		}    		
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i]&&tickets[i][0].equals(current)){
                path[idx] = tickets[i][1];
                visited[i] = true;
                dfs(idx+1, end, tickets[i][1], tickets, visited, path);
                visited[i] = false;
            }
        }
    }
}