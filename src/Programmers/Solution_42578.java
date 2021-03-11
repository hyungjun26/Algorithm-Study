package Programmers;

import java.util.*;

public class Solution_42578 {	
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> wardrobe = new HashMap<>();
        for(String[] s : clothes){
            List<String> temp;
            if(wardrobe.containsKey(s[1])){
                temp = wardrobe.get(s[1]);
                temp.add(s[0]);
                wardrobe.put(s[1], temp);
            } else {
                temp = new ArrayList<>();
                temp.add(s[0]);
                wardrobe.put(s[1], temp);
            }
        }        
        for(String key : wardrobe.keySet()){
            answer *= wardrobe.get(key).size()+1;
        }
        return answer-1;
    }
}
