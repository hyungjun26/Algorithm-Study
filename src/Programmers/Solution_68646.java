package Programmers;

import java.util.*;

public class Solution_68646 {
	public int solution(int[] a) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int min = a[0];
        for(int i = 0; i < a.length; i++){
            if(min>=a[i]){
                left.add(a[i]);
                min = a[i];
            }
        }
        min = a[a.length-1];
        for(int i = a.length-1; i >= 0; i--){
            if(min>=a[i]){
                right.add(a[i]);
                min = a[i];
            }
        }
        //System.out.println(left.toString());
        //System.out.println(right.toString());
        HashSet<Integer> set = new HashSet<>();
        for(int n:left)set.add(n);
        for(int n:right)set.add(n);
        return set.size();
    }
}
