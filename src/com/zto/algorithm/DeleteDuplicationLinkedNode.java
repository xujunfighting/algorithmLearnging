package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-22.
 */
public class DeleteDuplicationLinkedNode {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(2);
        ListNode m = new ListNode(2);
        ListNode n = new ListNode(2);
        ListNode o= new ListNode(3);
        ListNode p = new ListNode(3);
        ListNode q=new ListNode(4);
        ListNode v=new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        //b.next=g;
        g.next=m;
        m.next=n;
        n.next=o;
        o.next=p;
        p.next=q;
        q.next=v;
        v.next=null;
        DeleteDuplicationLinkedNode A = new DeleteDuplicationLinkedNode();
        ListNode head = A.deleteDuplication(a);
        while(head!=null) {
            System.out.print(head.getValue());
            head=head.next;
        }
    }
    public ListNode  deleteDuplication(ListNode head){
        if(head==null||head.next==null){//当只有0个或1个元素时直接返回
            return head;
        }
        if(head.getValue()==head.next.getValue()){//如果存在相等的元素就一直遍历下去
          ListNode node=head.next;
          while(node!=null&&node.getValue()==head.getValue()){
              node=node.next;
          }
          //直到找到第一个不相同的元素进行返回
          deleteDuplication(node);
        }else{
            head.next=deleteDuplication(head.next);

        }
        return head;
    }
    public ListNode deleteDuplcation2(ListNode head){
        ListNode frist=null;
        ListNode middle=null;
        ListNode last=null;
        if(head==null||head.next==null){
            return head;
        }else{
               boolean isChanged=false;
              frist=head;
              middle=frist;
              last=middle.next;
               while(last!=null){
                   isChanged=false;
                   if(middle.getValue()==last.getValue()){
                       while(last.getValue()==middle.getValue()) {
                           last = last.next;
                           if(last==null) break;
                       }//一直去查询后继的元素是否等于第一个相同的元素,如果相同就一直往后面遍历
                       isChanged=true;
                   }else{//三个指针依次向后遍历
                       frist=middle;
                       middle=last;
                       last=last.next;
                   }
                   if(isChanged==true){//当检测到元素相等的情况下 将前继first指针后继指向第一个不重复的元素
                       frist.next=last;
                       if(last==null){
                           break;
                       }
                       middle=last;
                       if(last.next!=null) {
                           last = last.next;
                       }else{
                           break;
                       }
                   }
               }

        }
        if(head.getValue()==middle.getValue()){//用于判断全部的元素是否相等
            return null;
        }
        return head;
    }
    public ListNode deleteDuplication3(ListNode pHead)
    {

        if (pHead!=null || pHead.next == null) return pHead;
        ListNode newHead = new ListNode(pHead.getValue() + 1);//新建一个节点
        newHead.next = pHead;//将新建节点指向第一个节点
        ListNode pre = newHead;
        ListNode p = pHead;
        ListNode next = null;
        while (p!=null && p.next!=null)
        {
            next = p.next;
            if (p.getValue() == next.getValue())
            {
                while (next!=null && next.getValue() == p.getValue())
                {
                    next = next.next;
                }
                pre.next = next;
                p = next;
            }
            else
            {
                pre = p;
                p = p.next;
            }
        }
        return newHead.next;
    }
}

