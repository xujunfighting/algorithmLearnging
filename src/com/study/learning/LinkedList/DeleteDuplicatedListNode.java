package study.learning.LinkedList;
import com.zto.common.LinkedList;

public class DeleteDuplicatedListNode {
    public static void main(String[] args) {
        LinkedList node1 = new LinkedList(1);
        LinkedList node2 = new LinkedList(2);
        LinkedList node3 = new LinkedList(2);
        LinkedList node4 = new LinkedList(4);
        LinkedList node5 = new LinkedList(5);
        LinkedList node6 = new LinkedList(5);
        LinkedList node7 = new LinkedList(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node1=deleteDuplicatedListNode(node1);
        System.out.println(node1);
    }

    public static LinkedList deleteDuplicatedListNode(LinkedList node){
        //元素为空
        if(node==null) return null;
        //只有一个元素
        if(node.next==null) return node;
        LinkedList pre=node;
        LinkedList cur=node.next;
        if(pre.getValue()==cur.getValue()){
            while(cur!=null&&pre.getValue()==cur.getValue()){
                pre=cur;
                cur=cur.next;
            }
            //查找到第一个不相同的元素 继续下一次查找
             return deleteDuplicatedListNode(cur);
        }else{
            pre.next=deleteDuplicatedListNode(cur);
        }
        return pre;
    }
    public static LinkedList deleteDuplicatedListNode1(LinkedList node){
        //当只有一个节点或者为空直接返回
       if(node==null||node.next==null) return node;
       LinkedList head=node;
       LinkedList next=node.next;
       LinkedList index=node;
       boolean isStart=true;
       while(next!=null){
           //元素相等
           if(node.getValue()==next.getValue()){
               if(head.getValue()==node.getValue()&&isStart==true){
                   head=null;
               }
               //判断当前两个节点相等 或者 后面两个节点相等
               while(next!=null&&node.getValue()==next.getValue()||next!=null&&next.next!=null&&next.getValue()==next.next.getValue()){
                   node=next;
                   next=next.next;
               }
               if(head==null&&isStart==true){//查找到第一个不相等的头节点
                   head=next;
                   index=head;
                   isStart=false;
               }else{
                   index.next=next;//拼接后续节点
               }
               if(next!=null) {
                   node = next.next;
                   if(next.next!=null) {
                       next = node.next;
                   }else{
                       next=null;
                   }
               }
           }else{//元素不相等直接遍历后续节点
               node=next;
               next=next.next;
           }
       }
       return head;
    }
}
