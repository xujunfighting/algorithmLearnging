package com.zto.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xujun on 2018-12-05.
 */
public class MaxSequenceValue {
    public static void main(String[] args){
        int[] seq=new int[]{2,3,4,2,6,2,5,1};
      List<Integer> result=method(seq,3);
      System.out.print(result);
    }
    public static List<Integer> method(int[] num, int size){
        ArrayList<Integer> result = new ArrayList<>();
        if(num == null || num.length == 0 || size == 0 || size > num.length) {
            return result;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < num.length; i++) {
            if(!queue.isEmpty()){
                // 如果队列头元素不在滑动窗口中了，就删除头元素
                if(i >= queue.peek() + size) {
                    queue.pop();
                }

                // 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                while(!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                    queue.removeLast();
                }
            }
            queue.add(i); // 入队列

            // 滑动窗口经过三个元素，获取当前的最大值，也就是队列的头元素
            if(i + 1 >= size) {
                result.add(num[queue.peek()]);
            }
        }
        return result;
    }

}
