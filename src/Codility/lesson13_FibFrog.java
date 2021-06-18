package Codility;

import java.util.*;

public class lesson13_FibFrog {
    class Point{
        int idx;
        int jump;
        public Point(int idx, int jump){
            this.idx = idx;
            this.jump = jump;
        }
    }
    public int solution(int[] A) {
        int N = A.length;
        int[] fibo = new int[30];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2; i < fibo.length; i++){
            fibo[i] = fibo[i-1]+fibo[i-2];                
        }
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.add(new Point(-1, 0));
        int cnt = -1;
        while(!queue.isEmpty()){
            Point p = queue.poll();            
            for(int i = 2; i < fibo.length; i++){
                int next = p.idx+fibo[i];
                if(next < N && A[next]==1 && !visited[next]){
                    visited[next] = true;
                    queue.add(new Point(next, p.jump+1));
                } else if(next==N){
                    return p.jump+1;                    
                }
            }  
        }
        return cnt;
    }
}