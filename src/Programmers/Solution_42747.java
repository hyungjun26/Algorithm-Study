package Programmers;

import java.util.*;

public class Solution_42747 {
	public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int cnt = 0;
        for(int i = citations.length-1; i >= 0; i--){            
            int n = citations[i];
            cnt++;
            if(cnt>n){
                answer = cnt-1;                
                break;
            }
            answer = cnt;
        }
        
        return answer;
    }
}
