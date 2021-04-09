package Programmers;

class Solution_43163 {
    static int answer;
    public static int solution(String begin, String target, String[] words) {
        answer = 99;
        dfs(begin, target, words, 0, new boolean[words.length]);
        if(answer==99)answer=0;
        return answer;
    }
    private static void dfs(String begin, String target, String[] words, int count, boolean[] visited){
        if(begin.equals(target) && answer > count){
            answer = count;
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(!visited[i]){
                int cnt = 0;
                for(int j = 0; j < words[i].length(); j++){
                    if(begin.charAt(j) != words[i].charAt(j))cnt++;
                }
                if(cnt == 1){
                    visited[i] = true;
                    dfs(words[i], target, words, count+1, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
