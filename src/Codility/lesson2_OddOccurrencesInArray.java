package Codility;

import java.util.*;

public class lesson2_OddOccurrencesInArray {
	public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer n : A){
            if(set.contains(n)){
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        ArrayList<Integer> res = new ArrayList<>(set);
        return res.get(0);
    }
}
