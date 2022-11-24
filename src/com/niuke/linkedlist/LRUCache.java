package com.niuke.linkedlist;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    private static class LinkedNode{

        private int key;
        private int value;
        private LinkedNode pre;
        private LinkedNode next;

        public LinkedNode(int key,int value, LinkedNode pre, LinkedNode next) {
            this.value = value;
            this.key = key;
            this.pre = pre;
            this.next = next;
        }
    }
    //头结点
    private static LinkedNode head=null;
    //尾结点
    private static LinkedNode tail=null;
    //总容量
    private static int totalCapacity=0;
    //当前角标
    private static int curIndex=0;

    private static Map<Integer,LinkedNode> maps=new HashMap<>();


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        put(2,1);
        put(1,1);
        put(2,3);
        put(4,1);
        System.out.println(get(1));
        System.out.println(get(2));
    }


    public LRUCache(int capacity) {
        curIndex=0;
        totalCapacity=capacity;
        maps=new HashMap<>(capacity);
        head=null;
        tail=null;
    }

    public static int get(int key) {
        if(maps.containsKey(key)){
            LinkedNode linkedNode = maps.get(key);
            if(tail.key==head.key|| linkedNode.key==tail.key) {
                //只存在一个节点
            }else if(linkedNode.key==head.key){
                //为头结点
                LinkedNode next = linkedNode.next;
                next.pre=null;
                head=next;
                tail.next=linkedNode;
                linkedNode.next=null;
                linkedNode.pre=tail;
                tail=linkedNode;
            }else{
                LinkedNode pre = linkedNode.pre;
                LinkedNode next = linkedNode.next;
                pre.next=next;
                next.pre=pre;
                tail.next=linkedNode;
                linkedNode.pre=tail;
                tail=linkedNode;
            }
            return linkedNode.value;
        }
        return -1;
    }

    public static void put(int key, int value) {
          if(maps.isEmpty()){
              //容量为空
              LinkedNode node=new LinkedNode(key,value,null,null);
              head=node;
              tail=node;
              maps.put(key,node);
              curIndex++;
          }else if(maps.containsKey(key)){
              //容量不变
              LinkedNode linkedNode = maps.get(key);
              linkedNode.value=value;
              if(head.key==tail.key || linkedNode.key==tail.key){
                  //只有一个元素
              }else if(linkedNode.key==head.key){
                  LinkedNode next = linkedNode.next;
                  next.pre=null;
                  head=next;
                  tail.next=linkedNode;
                  linkedNode.next=null;
                  linkedNode.pre=tail;
                  tail=linkedNode;
              }else{
                  LinkedNode pre = linkedNode.pre;
                  LinkedNode next = linkedNode.next;
                  pre.next=next;
                  next.pre=pre;
                  tail.next=linkedNode;
                  linkedNode.next=null;
                  linkedNode.pre=tail;
                  tail=linkedNode;
              }

          }else if(!maps.containsKey(key)){
              //判断容量是否达到限制
              if(curIndex==totalCapacity){
                  Integer headKey = head.key;
                  maps.remove(headKey);
                  LinkedNode node=new LinkedNode(key,value,null,null);
                  LinkedNode next = head.next;
                  if(next!=null) {
                      //容量大于1
                      head.next = null;
                      next.pre = null;
                      head = next;
                      tail.next = node;
                      node.pre = tail;
                      node.next = null;
                      tail = node;
                  }else{
                      head=node;
                      tail=node;
                  }
                  maps.put(key,node);
              }else{
                  curIndex++;
                  LinkedNode node=new LinkedNode(key,value,null,null);
                  tail.next=node;
                  node.pre=tail;
                  node.next=null;
                  tail=node;
                  maps.put(key,node);
              }
          }

    }


}
