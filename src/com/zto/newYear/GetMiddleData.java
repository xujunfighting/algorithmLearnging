package com.zto.newYear;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xujun on 2019-01-28.
 */
public class GetMiddleData {
    private static int count = 0;
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();//存放大的元素
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });//存放小的元素

    //读入字符，放到合适位置
    public static void Insert(Integer num) {
        if (count %2 == 0) {
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    //求中位数
    public static Double GetMedian() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
    public static void  main(String[] args){
        Insert(1);
        Insert(2);
        Insert(1);
        Insert(4);
        Insert(3);
        double result=GetMedian();
        System.out.println(result);
    }
}
