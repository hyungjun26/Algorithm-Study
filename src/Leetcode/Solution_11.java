package Leetcode;

public class Solution_11 {
	public int maxArea(int[] height) {
        int MAX = 0;        
        int left = 0;
        int right = height.length-1;
        while(left!=right){
            int dist = right-left;
            int min = height[left] > height[right] ? height[right] : height[left];
            if(min*dist>MAX)MAX = min*dist;
            if(height[left]>height[right]){
                right--;
            } else {
                left++;
            }
        }
        return MAX;
    }
}
