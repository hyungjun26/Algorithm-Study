package Programmers;

class Solution_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        boolean[] visited = new boolean[reserve.length];
        boolean[] rented = new boolean[lost.length];
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    rented[i] = true;
                    visited[j] = true;
                }
            }
        }
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(!rented[i] && !visited[j] && (lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j])){
                    answer++;
                    visited[j] = true;
                    break;
                }
            }
        }        
        return answer;
    }
}