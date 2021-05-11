package Programmers;

import java.util.*;

class Solution_64064 {
    Set<String> comb;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        List<String>[] list = new List[banned_id.length];
        
        //for(int i = 0; i < list.size(); i++)list[i] = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList<>();
            char[] ban = banned_id[i].toCharArray();
            for(String user:user_id){
                if(ban.length!=user.length())continue;
                char[] id = user.toCharArray();                
                boolean check = true;
                for(int k = 0; k < id.length; k++){
                    if(ban[k]!='*'&&ban[k]!=id[k]){
                        check = false;
                        break;
                    }
                }
                if(check) list[i].add(user);
            }
        }
        //for(List<String> str:list)System.out.println(str.toString());
        //System.out.println(users.size());
        comb = new HashSet<>();
        List<String> temp = new ArrayList<>();
        dfs(0, list.length, temp, list);
        return comb.size();
    }
    private void dfs(int idx, int end, List<String> temp, List<String>[] list){
        if(idx==end){
            Collections.sort(temp);
            String res = "";
            for(String str:temp)res+=str;
            comb.add(res);
            return;
        }
        //System.out.println(list[idx].toString());
        for(int i = 0; i < list[idx].size(); i++){
            if(!temp.contains(list[idx].get(i))){
                temp.add(list[idx].get(i));
                dfs(idx+1,end,temp,list);
                temp.remove(list[idx].get(i));
            }
        }
    }
}
