package Leetcode;

public class Solution_785_BFS {
	public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        boolean[] visited = new boolean[graph.length];        
                
        Queue<Integer> node = new LinkedList<>();
        int max = 0;
        int start = 0;
        for(int n = 0; n < graph.length; n++){
            if(max<graph[n].length){
                max = graph[n].length;
                start = n;
            }
        }
        node.add(start);
        while(!node.isEmpty()){
            int idx = node.poll();
            visited[idx] = true;
            for(int i = 0; i < graph[idx].length; i++){
                int to = graph[idx][i];
                if(visited[to]){
                    if(color[idx]==color[to])return false;
                } else {
                    color[to] = color[idx] == 0 ? 1 : 0;
                    node.add(to);
                }
            }
        }
        
        
        return true;
    }
}
