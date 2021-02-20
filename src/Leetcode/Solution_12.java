package Leetcode;

public class Solution_12 {
	public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        for(int i = 0; i < roman.length; i++){
            while(num>=number[i]){
                num -= number[i];
                ans.append(roman[i]);
            }
        }
        
        return ans.toString();
    }
}
