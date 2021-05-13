package Programmers;

import java.util.*;

class Solution_67260 {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        List<Integer>[] graph = new List[n];
        int[][] before = new int[n][1];
        int[] save = new int[n];
        for(int i = 0; i < n; i++)graph[i] = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];        
        for(int[] p:path){
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }
        for(int[] d:order){
            before[d[1]][0] = d[0];
        }
        if(before[0][0]!=0)return false;
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int r = q.poll();
            for(int next:graph[r]){
                if(!visited[next] && visited[before[next][0]]){
                    visited[next] = true;
                    q.add(next);
                }
                if(!visited[before[next][0]]) {
                    save[before[next][0]] = next;
                }
            }
            //System.out.println(r);
            if(!visited[save[r]]){
                //System.out.println("ADD: " + save[r]);
                q.add(save[r]);
                visited[save[r]] = true;
            }
        }
        for(boolean check:visited){
            if(!check)return false;
        }
        return answer;
    }
}