package com.niuke.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFUCache {

    private   int capacity;
    private   int curIndex;

    private   int totalIndex;

    private  Map<Integer, ListNode> valueMaps = null;

    private  List<Integer> results = null;

    private static class ListNode {
        private int key;
        private int value;
        private int frequency;
        private int index;


        public ListNode(Integer key, Integer value, Integer frequency, Integer index) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            this.index = index;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getFrequency() {
            return frequency;
        }

        public void setFrequency(Integer frequency) {
            this.frequency = frequency;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }


        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {

        LFUCache lruCache = new LFUCache(1101);

        
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curIndex = 1;
        this.valueMaps = new HashMap<>(capacity);
        this.results = new ArrayList<>(capacity + 1);
        this.results.add(0,0);
        this.totalIndex = 0;
    }

    public  int get(int key) {
        if (valueMaps.containsKey(key)) {
            ListNode listNode = valueMaps.get(key);
            listNode.setFrequency(listNode.getFrequency() + 1);
            listNode.setIndex(++totalIndex);
            return listNode.getValue();
        }
        return -1;
    }

    public  void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if (valueMaps.containsKey(key)) {
            ListNode listNode = valueMaps.get(key);
            listNode.setValue(value);
            listNode.setIndex(++totalIndex);
            listNode.setFrequency(listNode.getFrequency() + 1);
            valueMaps.put(key,listNode);
        } else if (!valueMaps.containsKey(key)) {
            if (curIndex==capacity + 1) {
                ListNode smallestListNode = getSmallestListNode();
                valueMaps.remove(smallestListNode.getKey());
                results.set(capacity, key);
                valueMaps.put(key, new ListNode(key, value, 1, ++totalIndex));
            } else {
                ListNode listNode = new ListNode(key, value, 1, ++totalIndex);
                results.add(curIndex, key);
                curIndex++;
                valueMaps.put(key, listNode);
            }

        }
    }

    /**
     * 堆排序查询最小节点
     * @return
     */
    public   ListNode getSmallestListNode() {
        for (int i = capacity / 2; i >= 1; i--) {
            if (i == capacity / 2 && capacity % 2 == 0) {
                ListNode p = valueMaps.get(results.get(i * 2));
                ListNode cur =valueMaps.get(results.get(i));
                if (cur.frequency > p.frequency || cur.frequency==p.frequency && cur.index > p.index) {
                    results.set(i * 2, cur.key);
                    results.set(i, p.key);
                }
            } else {
                ListNode p =  valueMaps.get(results.get(i * 2));
                ListNode q =  valueMaps.get(results.get(i * 2 + 1));
                ListNode cur =  valueMaps.get(results.get(i));
                ListNode minNode = null;
                int j = 0;
                if (p.frequency < q.frequency || p.frequency==q.frequency && p.index <= q.index) {
                    minNode = p;
                    j = i * 2;
                } else if (p.frequency > q.frequency || p.frequency==q.frequency && p.index > q.index) {
                    minNode = q;
                    j = i * 2 + 1;
                }
                if (cur.frequency > minNode.frequency || cur.frequency==minNode.frequency&&cur.index > minNode.index) {
                    results.set(i, minNode.key);
                    results.set(j, cur.key);
                }

            }
        }
        ListNode node = valueMaps.get(results.get(1));
        ListNode result = new ListNode(node.getKey(), node.getValue(), node.frequency, node.index);
        results.set(1, results.get(results.size() - 1));
        results.set(results.size() - 1, null);
        return result;
    }
}
