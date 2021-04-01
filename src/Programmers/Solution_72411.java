package Programmers;

import java.util.*;

class Solution_72411 {
//	public static void main(String[] args) {
//		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//		int[] course = {2,3,4};
//		List<String> str = solution(orders, course);
//		System.out.println(str.toString());
//	}
    static List<Character> menu;
    static List<String> comb;
    static int max;
    public static List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for(String order:orders){
            char[] temp = order.toCharArray();
            for(int i = 0; i < temp.length; i++){
                set.add(temp[i]);
            }
        }
        menu = new ArrayList<>(set);
        for(int cnt : course){
            comb = new ArrayList<>();
            max = 0;
            combMenu(0, cnt, 0, new char[cnt], orders, new boolean[menu.size()]);
            for(String str:comb)answer.add(str);
        }
        Collections.sort(answer);
        return answer;
    }
    
    private static void combMenu(int idx, int end, int prev, char[] temp, String[] orders, boolean[] visited){
    	System.out.println(idx+" "+end);
        if(idx >= end){
            int cnt = 0;
            for(String str:orders){
                boolean check = true;
                for(char ch:temp){
                    if(!str.contains(Character.toString(ch))){
                        check = false;
                        break;
                    }
                }
                if(check)cnt++;
            }
            if(max<cnt){
                max = cnt;
                comb = new ArrayList<>();
                comb.add(String.valueOf(temp));
            } else if(max==cnt){
                comb.add(String.valueOf(temp));
            }
            return;
        }
        for(int i = prev; i < menu.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                
                temp[idx] = menu.get(i);
                combMenu(idx+1, end, i, temp, orders, visited);
                visited[i] = false;
            }
        }
    }
}