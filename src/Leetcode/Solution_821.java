package Leetcode;

public class Solution_821 {
	public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)==c){
                ans[i] = 0;
            } else {
                boolean left = false;
                boolean right = false;
                int idx = i;
                int cnt = 0;
                int max = Integer.MAX_VALUE;
                while(idx >= 0){
                    if(s.charAt(idx)==c){
                        left = true;
                        break;
                    }
                    idx--;
                    cnt++;
                }
                if(left)max = max < cnt ? max : cnt;
                idx = i;
                cnt = 0;
                while(idx < s.length()){
                    if(s.charAt(idx)==c){
                        right = true;
                        break;
                    }
                    idx++;
                    cnt++;
                }
                if(right)max = max < cnt ? max : cnt;
                ans[i] = max;
            }
        }
        return ans;
    }
}
