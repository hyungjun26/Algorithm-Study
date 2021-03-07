package Leetcode;

public class Solution_706 {
	class MyHashMap {
	    int[] keys;
	    boolean[] checks;
	    /** Initialize your data structure here. */
	    public MyHashMap() {
	        keys = new int[1000001];
	        checks = new boolean[1000001];
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        keys[key] = value;
	        checks[key] = true;
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        if(!checks[key])return -1;
	        return keys[key];
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        keys[key] = 0;
	        checks[key] = false;
	    }
	}
}
