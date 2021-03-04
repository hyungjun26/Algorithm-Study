package Leetcode;

public class Solution_160 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//      ListNode temp = null;        
//      List<ListNode> list = new ArrayList<>();        
//      while(headA!=null){
//          list.add(headA);
//          headA = headA.next;
//      }
     
//      while(headB!=null){
//          if(list.contains(headB)){
//              temp = headB;
//              break;
//          }
//          headB = headB.next;
//      }
     int lenA = 0, lenB = 0;
     ListNode nodeA = headA, nodeB = headB;
     while(nodeA!=null){
         lenA++;
         nodeA = nodeA.next;
     }
     while(nodeB!=null){
         lenB++;
         nodeB = nodeB.next;
     }
     if(lenA > lenB){
         for(int i = 0; i < lenA-lenB; i++)headA = headA.next;
     } else if(lenB > lenA){
         for(int i = 0; i < lenB-lenA; i++)headB = headB.next;
     }
     while(headA!=headB){
         headA = headA.next;
         headB = headB.next;
     }
     return headA;
 }
}
