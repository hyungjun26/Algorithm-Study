package Programmers;

import java.util.*;
class Solution_67258 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> gem = new HashMap<>();
        for(String g:gems){
            gem.put(g,0);
        }        
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        boolean check = false;
        Set<String> isIn = new HashSet<>();
        for(; start < gems.length; start++){       
            while(end < gems.length && !check){                
                int cnt = gem.get(gems[end]) + 1;
                gem.put(gems[end],cnt);
                isIn.add(gems[end]);
                end++;
                //check = true;
                // for(String key:gem.keySet()){
                //     if(gem.get(key)==0)check = false;
                // }
                if(gem.size()==isIn.size())check=true;
            }            
            if(check && end-start < min){                        
                min = end-start;
                answer[0] = start+1;
                answer[1] = end;
            }
            int cnt = gem.get(gems[start]) - 1;
            gem.put(gems[start],cnt);
            if(cnt==0){
                isIn.remove(gems[start]);
                check = false;
            }
        }
        
        return answer;
    }
}
