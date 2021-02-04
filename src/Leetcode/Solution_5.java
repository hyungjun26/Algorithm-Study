package Leetcode;

public class Solution_5 {
	static boolean[][] dp;
    static int start;
    static int maxLen;
    public String longestPalindrome(String s){
        dp = new boolean[s.length()][s.length()];
        start = 0;
        maxLen = 1;
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;            
        }
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
                start = i;
            }
        }
        
        for(int len = 3; len <= s.length(); len++){
            for(int i = 0; i <= s.length()-len; i++){
                if(s.charAt(i)==s.charAt(i+len-1) && dp[i+1][i+len-2]){
                    dp[i][i+len-1]=true;
                    maxLen = len;
                    start = i;
                }
            }
        }
        
        return s.substring(start, start+maxLen);
    }
}
