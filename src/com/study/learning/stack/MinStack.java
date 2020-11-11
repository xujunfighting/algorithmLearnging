package com.study.learning.stack;

import java.util.Stack;

/**
 * Author xujun
 * Create date 2020-01-05.
 * desc:
 */
public class MinStack {
    public static Stack<Integer> minStack= new Stack<>();
    public static Stack<Integer> currentStack = new Stack<>();
    public static void main(String[] args) {
        int[] num = new int[]{3, 8, 5, 6, 9, 1, 0, 2};
        push(3);
        push(8);
        push(5);
        push(6);
        push(9);
        push(1);
        System.out.println(getMin());
        System.out.println(getMin());
    }
    public static void push(int num){
        if(minStack.isEmpty()){
            minStack.push(num);
        }else{
            int cur=minStack.peek();
            if(cur<num){
                minStack.push(cur);
            }else{
                minStack.push(num);
            }
        }
        currentStack.push(num);
    }
    public static int pop(){
        minStack.pop();
        return currentStack.pop();
    }
    public static int getMin(){
        return minStack.pop();
    }
}
