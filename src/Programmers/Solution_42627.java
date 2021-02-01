package Programmers;

import java.util.*;

public class Solution_42627 {	
	class Task implements Comparable<Task>{
        int come;
        int len;
        public Task(int come, int len){
            this.come = come;
            this.len = len;
        }
        @Override
        public int compareTo(Task other){            
            return this.len <= other.len ? -1 : 1;
        }
    }
    public int solution(int[][] jobs) {        
        int jobCnt = jobs.length;
        PriorityQueue<Task>[] timeStamp = new PriorityQueue[1001];
        for(int i = 0; i < timeStamp.length; i++){
            timeStamp[i] = new PriorityQueue<>();
        }
        for(int i = 0; i < jobs.length; i++){
            timeStamp[jobs[i][0]].add(new Task(jobs[i][0], jobs[i][1]));
        }
        PriorityQueue<Task> schedule = new PriorityQueue<>(); 
        int time = 0;
        int remain = 0;
        int sum = 0;
        Task t = null;
        while(jobCnt > 0){
            if(time < 1001){
                while(!timeStamp[time].isEmpty()){
                    if(t==null && schedule.isEmpty()){
                        t = timeStamp[time].poll();
                        remain = t.len;
                        sum += time + t.len - t.come;
                        jobCnt--;
                    } else {
                        schedule.add(timeStamp[time].poll());
                    }
                }
            }
                        
            time++;
            remain--;
            if(remain==0 && !schedule.isEmpty()){
                t = schedule.poll();
                remain = t.len;
                sum += time + t.len - t.come;
                jobCnt--;
            } else if(remain==0 && schedule.isEmpty()){
                t = null;
            }
        }
        return sum/jobs.length;
    }
}
