package Leetcode;

import java.util.*;

public class Solution_1091 {
	class Point{
        int r, c, len;
        Point(int r, int c, int len){
            this.r = r;
            this.c = c;
            this.len = len;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        int min = Integer.MAX_VALUE;        
        if(grid[0][0]==1)return -1;
        boolean[][] visited = new boolean[N][N];
        int[][] dir = {{0,1},{0,-1},{1,-1},{1,0},{1,1},{-1,1},{-1,0},{-1,-1}};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,1));
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.r==N-1&&p.c==N-1){
                if(min > p.len)min=p.len;
                break;
            }
            for(int[] d:dir){
                int r = p.r + d[0];
                int c = p.c + d[1];
                if(isIn(r,c,N)&&!visited[r][c]&&grid[r][c]==0){
                    visited[r][c] = true;                    
                    queue.add(new Point(r,c,p.len+1));
                }
            }
        }
        if(min == Integer.MAX_VALUE)return -1;
        return min;
    }
    private boolean isIn(int r, int c, int N){
        return r < N && r >= 0 && c < N && c >= 0;
    }
}
