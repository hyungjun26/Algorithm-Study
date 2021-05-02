package Programmers;

import java.util.*;

class Solution_42888 {
    public String[] solution(String[] record) {
        String[] answer;
		String[][] table = new String[100000][2];
		int count = 0;
		HashMap<String, String> nickname = new HashMap<>();
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			String oper = st.nextToken();
			String uid, name;
			switch (oper) {
			case "Enter":
				uid = st.nextToken();
				name = st.nextToken();
				nickname.put(uid, name);
				table[count][0] = uid;
				table[count][1] = "님이 들어왔습니다.";
				count++;
				break;
			case "Leave":
				uid = st.nextToken();
				table[count][0] = uid;
				table[count][1] = "님이 나갔습니다.";
				count++;
				break;
			case "Change":
				uid = st.nextToken();
				name = st.nextToken();
				nickname.put(uid, name);
				break;
			}
		}
		answer = new String[count];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = nickname.get(table[i][0])+table[i][1];
		}
		return answer;
    }
}
