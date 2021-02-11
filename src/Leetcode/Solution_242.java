package Leetcode;

import java.util.Arrays;

public class Solution_242 {
	public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar,tchar);
    }
}
