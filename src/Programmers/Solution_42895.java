package Programmers;

import java.util.*;

class Solution_42895 {
    public int solution(int N, int number) {
        int answer = -1;
        List<Integer>[] list = new List[9];
        for(int i = 1; i < 9; i++){
            list[i] = new ArrayList<>();            
        }
        list[0] = null;
        list[1].add(N);
        for(int i = 1; i < 9; i++){
            if(i > 1){
                String temp = "";
                for(int k = 0; k < i; k++)temp+=N;
                list[i].add(Integer.parseInt(temp));
                for(int j = 1; j < i; j++){
                    for(Integer n : list[j]){
                        for(Integer m : list[i-j]){
                            list[i].add(n+m);
                            list[i].add(n-m);                    
                            if(m!=0){
                                list[i].add(n*m);
                                list[i].add(n/m);
                            }
                        }
                    }
                }
                
            }
            
            //System.out.println(Arrays.toString(list[i].toArray()));
            if(list[i].contains(number))return i;
        }
        return answer;
    }
}
