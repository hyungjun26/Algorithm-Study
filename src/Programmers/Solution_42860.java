package Programmers;

class Solution_42860 {
    public int solution(String name) {
        // A : 65, Z : 90
        int answer = 0;
        char[] temp = new char[name.length()];
        boolean[] completed = new boolean[name.length()];
        for(int i = 0; i < name.length(); i++){
            temp[i] = name.charAt(i);
            if(temp[i]=='A')completed[i]=true;
        }
        int idx = 0;
        int dir = 0;
        while(true){
            if(!completed[idx]){
                //up
                int up = 0, down = 0;
                char target = 'A';
                while(temp[idx]!=target){
                    if(target=='Z'){
                        up++;
                        target='A';
                    } else {
                        up++;
                        target++;
                    }
                }
                target = 'A';
                while(temp[idx]!=target){
                    if(target=='A'){
                        down++;
                        target='Z';
                    } else {
                        down++;
                        target--;
                    }
                }
                completed[idx] = true;
                answer += up > down ? down : up;
            }
            boolean check = true;
            for(int i = 0; i < name.length(); i++){                
                if(!completed[i])check=false;
            }
            if(check)break;
            // 방향 선택
            int left = idx, right = idx, cnt = 0;
            while(true){
                if(left==0){
                    left = name.length()-1;                    
                }else if(left > 0){
                    left--;
                }
                if(dir != 1 && right < name.length()){
                    right++;
                }
                cnt++;
                
                if(!completed[right]){
                    answer+=cnt;
                    idx = right;
                    dir = 2;
                    break;
                }
                if(!completed[left]){
                    answer+=cnt;
                    idx = left;
                    dir = 1;
                    break;
                }
            }
                
        }
        return answer;
    }
}
