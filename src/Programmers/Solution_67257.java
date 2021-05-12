package Programmers;

import java.util.*;
class Solution_67257 {
    static long MAX;
    public long solution(String expression) {
        MAX = 0;
        Set<String> set = new HashSet<>();
        List<String> exp = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < expression.length(); i++){
            char ex = expression.charAt(i);            
            if(ex=='-'||ex=='*'||ex=='+'){
                exp.add(temp);
                exp.add(String.valueOf(ex));
                set.add(String.valueOf(ex));
                temp = "";
            } else {
                temp += ex;
            }
            if(i==expression.length()-1)exp.add(temp);
        }
        
        //for(String st : exp)System.out.println(st);
        List<String> list = new ArrayList(set);
        comb(0, list.size(), list, new String[list.size()], new boolean[list.size()], exp);
        return MAX;
    }
    
    private void comb(int idx, int end, List<String> list, String[] temp, boolean[] visit, List<String> exp){
        if(idx==end){
            List<String> result = new ArrayList<>(exp);
            List<String> exam = new ArrayList<>();
            for(int k = 0; k < temp.length; k++){
                for(int j = 0; j < result.size(); j++){
                    if(temp[k].equals(result.get(j))){
                        Long first = Long.parseLong(exam.get(exam.size()-1));
                        exam.remove(exam.size()-1);
                        Long second = Long.parseLong(result.get(j+1));
                        Long res = 0L;
                        switch(temp[k]){
                            case "+":
                                res = first + second;
                                break;
                            case "*":
                                res = first * second;
                                break;
                            case "-":
                                res = first - second;
                                break;
                        }
                        exam.add(Long.toString(res));
                        j++;
                    } else {
                        exam.add(result.get(j));
                    }
                }
                //for(String st : exam)System.out.println(st);
                result = exam;
                exam = new ArrayList<>();
            }
            Long compare = Long.parseLong(result.get(0));
            compare = Math.abs(compare);
            if(MAX < compare)MAX = compare;
            return;
        }
        for(int i = 0; i < list.size(); i++){
            if(!visit[i]){
                visit[i] = true;
                temp[idx] = list.get(i);
                comb(idx+1, end, list, temp, visit, exp);
                visit[i] = false;
            }
        }
    }
}
