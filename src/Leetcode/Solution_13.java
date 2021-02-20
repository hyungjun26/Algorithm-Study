package Leetcode;

import java.util.HashMap;

public class Solution_13 {
	public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
        int ans = 0;
        char prev = s.charAt(s.length()-1);
        for(int i = s.length()-1; i >= 0; i--){
            if(roman.get(s.charAt(i))>=roman.get(prev)){
                ans += roman.get(s.charAt(i));
                prev = s.charAt(i);
            } else {
                ans -= roman.get(s.charAt(i));
                prev = s.charAt(i);
            }
        }
        return ans;
    }
}
