package Programmers;

import java.util.*;

class Solution_67259 {
    class Point {
        int r;
        int c;
        int d;
        int cost;
        Point(int r, int c, int d, int cost){
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
        }
    }
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Point> queue = new LinkedList<>();
        if(board[0][1]!=1)queue.add(new Point(0,1,3,100));
        if(board[1][0]!=1)queue.add(new Point(1,0,1,100));
        board[0][1] = 100;
        board[1][0] = 100;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.r==N-1&&p.c==N-1&&answer>p.cost){
                answer = p.cost;
                continue;
            }
            for(int i = 0; i < dir.length; i++){
                if(p.r*-1 == dir[i][0] && p.c*-1 == dir[i][1])continue;
                int row = p.r + dir[i][0];
                int col = p.c + dir[i][1];
                if(isIn(row,col, N) && board[row][col]!=1){
                    int cost = p.cost;
                    if(p.d == i)cost += 100;
                    else cost += 600;
                    if(board[row][col]==0||board[row][col] >= cost-500){
                        board[row][col] = cost;
                        queue.add(new Point(row, col, i, cost));
                    }
                }
            }
        }
        return answer;
    }
    private boolean isIn(int row, int col, int N){
        return row < N && row >= 0 && col < N && col >= 0;
    }
}
