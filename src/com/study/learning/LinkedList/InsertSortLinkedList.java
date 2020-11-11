package study.learning.LinkedList;
import com.zto.common.LinkedList;

public class InsertSortLinkedList {
    public static void main(String[] args) {
        LinkedList n1= new LinkedList(2);
        LinkedList n2= new LinkedList(4);
        LinkedList n3= new LinkedList(1);
        LinkedList n4= new LinkedList(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        LinkedList head=getSortLinkedList(n1);
        System.out.println("end");
    }
    public static LinkedList getSortLinkedList(LinkedList list){
        if(list==null||list.next==null) return list;
        LinkedList cur=list.next;
        LinkedList head=list;//记录头结点
        LinkedList index=head;//遍历角标
        LinkedList next=cur;
        head.next=null;
        while(cur!=null)//从第二个元素开始遍历
        {
            index=head;//每次将遍历节点指向头结点
            next=cur.next;
            if(head.getValue()>cur.getValue()){//默认当前序列已经排序好
                cur.next=head;
                head=cur;
            }else{
                LinkedList pre=index;
                while(index!=null&&index.getValue()<cur.getValue()){
                    pre=index;
                    index=index.next;
                }
                pre.next=cur;
                cur.next=index;
            }
            cur=next;
            if(next!=null) {
                next = next.next;
            }
        }
        return head;
    }
}
