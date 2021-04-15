package Programmers;

import java.util.*;

class Solution_49189 {
    static int[] distance;
	static List<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        distance = new int[n+1];
		graph = new List[n+1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < edge.length; i++) {
			int start = edge[i][0];
			int end = edge[i][1];
			graph[start].add(end);
			graph[end].add(start);
		}
		for (int i = 0; i < graph[1].size(); i++) {
			boolean[] visited = new boolean[n+1];
			visited[1] = true;
			visited[graph[1].get(i)] = true;
			dfs(1, graph[1].get(i), visited);
		}
		int MAX = 0;
		int answer = 0;
		for (int i = 0; i < distance.length; i++) {
			if(MAX < distance[i])MAX = distance[i];
		}
		for (int i = 0; i < distance.length; i++) {
			if(distance[i]==MAX)answer++;
		}        
        return answer;
    }
    
    private void dfs(int dist, Integer current, boolean[] visited){
        if(distance[current]==0)distance[current] = dist;
		else if(distance[current] > dist)distance[current] = dist;
        else if(distance[current] <= dist)return;
		for (int i = 0; i < graph[current].size(); i++) {
			if(!visited[graph[current].get(i)]) {
				visited[graph[current].get(i)] = true;
				dfs(dist+1, graph[current].get(i), visited);
				visited[graph[current].get(i)] = false;
			}
		}		
    }
}
