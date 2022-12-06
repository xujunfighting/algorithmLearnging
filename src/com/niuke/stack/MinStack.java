package com.niuke.stack;

import java.util.Stack;

public class MinStack {
    private static Stack<Integer> stack=new Stack<>();
    private static Stack<Integer> minStack=new Stack<>();
    public static void main(String[] args) {
        push(-2);
        push(0);
        push(-3);
        System.out.println(getMin());  //--> 返回 -3.
        pop();
        System.out.println(top());      //--> 返回 0.
        System.out.println( getMin());   // --> 返回 -2.
        System.out.println("123");
    }

    public MinStack() {

    }

    public static void push(int val) {
       stack.push(val);
       if(minStack.isEmpty()){
           minStack.push(val);
       }else{
           Integer curMin = minStack.peek();
           if(val<=curMin){
               minStack.push(val);
           }
       }
    }

    public static void pop() {
       int val=stack.pop();
       if(val==minStack.peek()){
           minStack.pop();
       }
    }

    public static int top() {
       return stack.peek();
    }

    public static int getMin() {
        return minStack.peek();
    }
}
