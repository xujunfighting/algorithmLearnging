package com.zto.offer;

import java.util.Stack;

/**
 * Created by xujun on 2018-11-30.
 */
public class MinStack {
    public static void main(String[] args){
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> minStack=new Stack<>();
        put(stack,minStack,1);
        put(stack,minStack,2);
        put(stack,minStack,3);
        System.out.print(get(stack,minStack));
        put(stack,minStack,4);
        put(stack,minStack,5);
    }
    public static void put(Stack<Integer> stack,Stack minStack,int val){
       if(minStack.isEmpty()){
           minStack.add(val);
       }else{
           int min=(Integer)minStack.peek();
           if(min<=val){
               minStack.add(min);
           }else{
               minStack.add(val);
           }
       }
       stack.add(val);
    }
    public static int get(Stack stack,Stack minStack){
         stack.pop();
         int result=(Integer) minStack.pop();
         return result;
    }
}
