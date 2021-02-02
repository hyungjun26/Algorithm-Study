package Leetcode;

public class Solution_3 {
	public int lengthOfLongestSubstring(String s) {        
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            int cnt = 1;
            String str = Character.toString(s.charAt(i)); 
            while(true){
                if(i+cnt >= s.length())break;
                String right = Character.toString(s.charAt(i+cnt)); 
                if(str.contains(right)){
                    break;
                } else {
                    cnt++;
                    str = str + right;
                }
            }
            if(cnt > max)max = cnt;
        }
        
        return max;
    }
}
