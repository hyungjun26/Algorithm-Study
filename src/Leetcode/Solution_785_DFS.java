package Leetcode;

public class Solution_785_DFS {
	int[] colorSet;
    boolean[] visited;
    boolean ans;
    public boolean isBipartite(int[][] graph) {
        colorSet = new int[graph.length];
        visited = new boolean[graph.length];
        ans = true;
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                visited[i] = true;
                bipartite(i , 1, graph);
            }
        }
        return ans;
    }
    
    private void bipartite(int node, int color, int[][] graph){
        if(!ans)return;
        for(int i = 0; i < graph[node].length; i++){
            int to = graph[node][i];
            if(visited[to]){
                if(colorSet[to]==colorSet[node]){
                    ans = false;
                    return;
                }
            } else {
                colorSet[to] = color;
                visited[to] = true;
                bipartite(to, color==0?1:0, graph);
            }
        }
    }
}
