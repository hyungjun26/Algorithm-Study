package Programmers;

class Solution_72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        for(int[] info : fares){
            graph[info[0]][info[1]] = info[2];
            graph[info[1]][info[0]] = info[2];
        }
        for(int k = 1; k < graph.length; k++){
            for(int i = 1; i < graph.length; i++){
                if(k==i||graph[i][k]==0)continue;
                for(int j = 1; j < graph.length; j++){
                    if(i==j||graph[k][j]==0)continue;
                    if(graph[i][j]==0||graph[i][j] > graph[i][k]+graph[k][j]){
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        // for(int[] dir : graph){
        //     System.out.println(Arrays.toString(dir));
        // }
        answer = Integer.MAX_VALUE;
        for(int idx = 1; idx < graph.length; idx++){
            if(s==idx && answer > graph[idx][a]+graph[idx][b]){
                answer = graph[idx][a]+graph[idx][b];
            } else if(a==idx && answer > graph[s][idx]+graph[idx][b]){
                answer = graph[s][idx]+graph[idx][b];
            } else if(b==idx && answer > graph[s][idx]+graph[idx][a]){
                answer = graph[s][idx]+graph[idx][a];
            }
            if(graph[s][idx]==0||graph[idx][a]==0||graph[idx][b]==0)continue;
            if(answer > graph[s][idx]+graph[idx][a]+graph[idx][b]){
                answer = graph[s][idx]+graph[idx][a]+graph[idx][b];
            }
        }
        
        return answer;
    }
}
