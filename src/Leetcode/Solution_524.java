package Leetcode;

import java.util.List;

public class Solution_524 {
	public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for(String w : d){
            int idx = 0;
            int wi = 0;
            while(idx < s.length() && wi < w.length()){                
                if(s.charAt(idx)==w.charAt(wi)){
                    idx++;
                    wi++;
                } else {
                    idx++;
                }
            }
            if(wi>=w.length()){
                if(ans.length()<w.length()){
                    ans = w;
                } else if(ans.length()==w.length()&&w.compareTo(ans)<0){
                    ans = w;
                }
            }
        }
        return ans;
    }
}
