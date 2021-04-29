package Programmers;

import java.util.*;

class Solution_72412 {
    static HashMap<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(int idx = 0; idx < info.length; idx++){
            String[] str = info[idx].split(" ");
            keyMake(0, 4, str, "", Integer.parseInt(str[4]));
        }        
        for(String key:map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list);
        }
        int[] ans = new int[query.length];
        for(int idx = 0; idx < query.length; idx++){
            StringTokenizer st = new StringTokenizer(query[idx], " ");
            int n = 0;
            int target = 0;
            String key = "";
            while(st.hasMoreTokens()){
                String temp = st.nextToken(); 
                if(!temp.equals("and")&&n!=4){
                    key += temp;
                    n++;
                } else if(n==4){
                    target = Integer.parseInt(temp);
                }
            }
            List<Integer> list = null;
            if(map.containsKey(key)){
                list = map.get(key);
            } else {
                continue;
            }
            int low = binarySearch(list, target);            
            ans[idx] = list.size()-low;
        }
        return ans;
    }
    
    private int binarySearch(List<Integer> list, int target){
        int low = 0;
        int high = list.size();
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (list.get(mid)>=target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private void keyMake(int idx, int end, String[] str, String key, int score){
        if(idx==end){
            
            if(map.containsKey(key)){
                List<Integer> list = map.get(key);
                list.add(score);                
                map.put(key, list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(score);
                map.put(key, list);
            }
            return;
        }
        keyMake(idx+1, end, str, key+str[idx], score);
        keyMake(idx+1, end, str, key+"-", score);
    }
}
