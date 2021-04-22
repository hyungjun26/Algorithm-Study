package Programmers;

class Solution_43238 {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long MAX = 0;
        for(int t : times){
            if(MAX < t)MAX=t;
        }
        long left = 0;
        long mid;
        long right = MAX*n;
        while(left <= right){
            mid = (left+right)/2;
            //System.out.println(mid);
            long cnt = 0;
            for(int t : times){
                cnt +=mid/t;
            }
            //System.out.println(cnt + " " + mid);
            if(cnt >= n){
                answer = answer > mid ? mid : answer;
                right = mid - 1;
            } else if(cnt < n){
                left = mid + 1;
            }
        }
        //System.out.println(answer);
        return answer;
    }
}
