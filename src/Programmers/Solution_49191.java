package Programmers;

public class Solution_49191 {
	public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] rank = new int[n+1][n+1];
        for(int[] a : results){
            int w = a[0];
            int d = a[1];
            rank[w][d] = 1;
            rank[d][w] = -1;
        }
        for(int p = 1; p <= n; p++){
            for(int s = 1; s <= n; s++){
                for(int e = 1; e <=n; e++){
                    if(s!=p && s!=e && rank[s][p] != 0 && rank[s][p] == rank[p][e]){
                        rank[s][e] = rank[s][p] == 1 ? 1 : -1;
                        rank[e][s] = rank[s][p] == 1 ? -1 : 1;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            boolean check = true;
            for(int j = 1; j <= n; j++){
                if(i!=j && rank[i][j]==0){
                    check = false;
                    break;
                }
            }
            if(check)answer++;
        }
        return answer;
    }
}
