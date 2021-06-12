package Codility;

//RESULT = https://app.codility.com/demo/results/trainingGFRSK6-S8U/
public class lesson90_LongestPassword {
	public int solution(String S) {
        String[] pwd = S.split(" ");
        int MAX = -1;
        for(int i = 0; i < pwd.length; i++){
            if(pwd[i].length() < MAX)continue;
            String p = pwd[i];
            boolean isChar = true;
            int charCnt = 0;            
            int numCnt = 0;
            for(int j = 0; j < p.length(); j++){
                char ch = p.charAt(j);
                if(Character.isDigit(ch)){
                    numCnt++;
                } else if(Character.isLetter(ch)){
                    charCnt++;
                } else {
                    isChar = false;
                    break;
                }
            }
            if(isChar && charCnt%2==0 && numCnt%2==1){
                MAX = Math.max(MAX, p.length());
            }
        }
        return MAX;    
    }
}
