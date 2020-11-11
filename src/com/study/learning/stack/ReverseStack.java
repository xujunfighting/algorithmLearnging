package com.study.learning.stack;

import java.util.Stack;

/**
 * Author xujun
 * Create date 2020-01-05.
 * desc:
 */
public class ReverseStack {
    private static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        stack.add(4);
        stack.add(3);
        stack.add(2);
        stack.add(1);
        //int size=4;
        reverseStack(stack);
        print(stack);
    }
    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;
       //cur为每个栈底的元素
        int cur=getStackDownData(stack);
        reverseStack(stack);
        stack.push(cur);
    }
    public static int getStackDownData(Stack<Integer> stack){
        if(stack.size()==1){
            return stack.pop();
        }
        int item = stack.pop();
        int res=getStackDownData(stack);
        stack.push(item);
        return res;
    }
    public static void print(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
