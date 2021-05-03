package Programmers;

class Solution_42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dir = {{1,0},{0,1}};
        int[][] map = new int[n+1][m+1];
        map[1][1] = 1;
        for(int i = 0; i < puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j]==0 || map[i][j] == -1)continue;
                for(int k = 0; k < 2; k++){
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];
                    if(isIn(r,c,n,m)&&map[r][c]!=-1){                        
                        map[r][c] = (map[i][j] + map[r][c]) % 1000000007;
                    }                    
                }
            }
        }
        return map[n][m]%1000000007;
    }
    private boolean isIn(int row, int col, int n, int m){
        return row <= n && row > 0 && col <= m && col > 0;
    }
}
