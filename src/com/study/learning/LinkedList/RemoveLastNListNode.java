package study.learning.LinkedList;
import com.zto.algorithm.ListNode;

public class RemoveLastNListNode {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        ListNode head=removeLastNListNode(node1,5);
        System.out.println("end");
    }

   public  static ListNode removeLastNListNode(ListNode head,int n){
        if(head.next==null&&n==1) return null;
        ListNode p1=head;
        ListNode p2=head;
        int count=0;
        while(count<n){
            p1=p1.next;
            count++;
        }
        if(p1==null){
            return head.next;
        }
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p2.next=p2.next.next;
        return head;
   }
}
