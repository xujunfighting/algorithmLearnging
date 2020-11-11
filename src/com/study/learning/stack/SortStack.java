package com.study.learning.stack;

import java.util.Stack;

/**
 * Author xujun
 * Create date 2020-01-05.
 * desc:
 */
public class SortStack {
    private static Stack<Integer> stack = new Stack<>();
    public static int max=0;
    public static void main(String[] args) {
        stack.add(1);
        stack.add(4);
        stack.add(2);
        stack.add(3);
        stack.add(10);
        stack.add(8);
        stack.add(5);
        stack.add(9);
        sortStack(stack);
        System.out.println(max);
    }
    public static void sortStack(Stack<Integer> stack){
         if(stack.isEmpty()) return;
         int res=getMax(stack);
         max=0;
         sortStack(stack);
         stack.push(res);
    }
    public static int getMax(Stack<Integer> stack){
        if(stack.isEmpty()) return max;
        int res=stack.pop();
        if(res>max){
            max=res;
        }
        int max=getMax(stack);
        if(res!=max){
            stack.push(res);
        }
        return max;
    }

}
