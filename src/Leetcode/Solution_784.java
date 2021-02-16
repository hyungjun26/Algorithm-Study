package Leetcode;

import java.util.*;

public class Solution_784 {
	List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        caseSearch(S, 0, "");
        return ans;
    }
    private void caseSearch(String S, int index, String str){
        if(index==S.length()){
            ans.add(str);
            return;
        }
        
        if(Character.isDigit(S.charAt(index))){
            caseSearch(S, index+1, str+Character.toString(S.charAt(index)));
        } else {
            char lower = Character.toLowerCase(S.charAt(index));
            char upper = Character.toUpperCase(S.charAt(index));
            caseSearch(S, index+1, str+Character.toString(lower));
            caseSearch(S, index+1, str+Character.toString(upper));
        }
    }
}
