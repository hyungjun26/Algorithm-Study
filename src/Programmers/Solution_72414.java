package Programmers;

class Solution_72414 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToSec(play_time);
        int advTime = timeToSec(adv_time);
        int[] start = new int[logs.length];
        int[] end = new int[logs.length];
        long[] totalTime = new long[100*60*60];
        for(int i = 0; i < logs.length; i++){
            String[] temp = logs[i].split("-");
            start[i] = timeToSec(temp[0]);
            end[i] = timeToSec(temp[1]);
            totalTime[start[i]] = totalTime[start[i]]+1;
            totalTime[end[i]] = totalTime[end[i]]-1;
        }
        for(int s = 1; s < playTime; s++){
            totalTime[s] = totalTime[s] + totalTime[s-1];
        }
        for(int s = 1; s < playTime; s++){
            totalTime[s] = totalTime[s] + totalTime[s-1];
        }
        long maxTime = 0L;
        int logIdx = 0;
        for(int s = advTime-1; s < playTime; s++){
            if(s>=advTime){
                if(maxTime < totalTime[s]-totalTime[s-advTime]){
                    maxTime = totalTime[s]-totalTime[s-advTime];
                    logIdx = s-advTime+1;
                }
                
            } else {
                if(maxTime < totalTime[s]){
                    maxTime = totalTime[s];
                    logIdx = s-advTime+1;
                }
            }
        }
                
        return secToTime(logIdx);
    }
    
    private int timeToSec(String time){
        String[] table = time.split(":");
        return Integer.parseInt(table[0])*3600+Integer.parseInt(table[1])*60+Integer.parseInt(table[2]);
    }
    
    private String secToTime(long sec){
        long hour = 0;
        long min = 0;
        String[] time = new String[3];
        if(sec/3600>0){
            hour = sec / 3600;
            sec = sec % 3600;
        }
        if(sec/60>0){
            min = sec / 60;
            sec = sec % 60;
        }
        if(hour<10){
            time[0] = "0"+Long.toString(hour);
        } else {
            time[0] = Long.toString(hour);
        }
        if(min<10){
            time[1] = "0"+Long.toString(min);
        } else {
            time[1] = Long.toString(min);
        }
        if(sec<10){
            time[2] = "0"+Long.toString(sec);
        } else {
            time[2] = Long.toString(sec);
        }
        return time[0]+":"+time[1]+":"+time[2];
    }
}
