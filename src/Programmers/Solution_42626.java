package Programmers;

import java.util.*;

class Solution_42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }        
        int answer = 0;        
		while(true) {
			if(pq.peek() < K && pq.size() > 1) {
				int first = pq.poll();
				int second = pq.poll();
				pq.add(first+second*2);
				answer++;
			} else if(pq.peek() < K && pq.size()==1) {
                answer=-1;
				break;
			} else{
                break;
            }
		}
        return answer;
    }
}
