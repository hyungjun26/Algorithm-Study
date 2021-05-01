package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_42579 {
    public static class Info implements Comparable<Info>{
		int idx;
		int play;
		public Info(int i, int p) {
			this.idx = i;
			this.play = p;
		}
		@Override
		public int compareTo(Info other) {
			if(this.play < other.play) {
				return 1;
			} else if(this.play==other.play) {
				if(this.idx > other.idx) {
					return 1;
				}
			}
			return -1;
		}
		
	}
	public static int[] solution(String[] genres, int[] plays) {        
        Map<String, Integer> count = new HashMap<>();
        HashMap<String, List<Info>> data = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
			if(count.containsKey(genres[i])) {
				count.put(genres[i], count.get(genres[i])+plays[i]);
			} else {
				count.put(genres[i], plays[i]);
			}
		}
        List<String> keySetList = new ArrayList<>(count.keySet());
        keySetList.sort((o1,o2)->count.get(o2).compareTo(count.get(o1)));
        for(String key : keySetList) {
        	List<Info> list = new ArrayList<>();
        	for (int i = 0; i < plays.length; i++) {
				if(genres[i].equals(key))list.add(new Info(i, plays[i]));
			}
        	Collections.sort(list);
        	data.put(key, list);
        }
        List<Integer> result = new ArrayList<>();
        for(String key : keySetList) {
        	List<Info> info = data.get(key);
        	if(info.size()>=2) {
        		result.add(info.get(0).idx);
        		result.add(info.get(1).idx);
        	} else {
        		result.add(info.get(0).idx);
        	}
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
        return answer;
    }
}
