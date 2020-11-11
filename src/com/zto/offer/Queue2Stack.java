package com.zto.offer;

import java.util.Stack;

/**
 * Created by xujun on 2018-11-27.
 */
public class Queue2Stack {
    public static void main(String[] args){
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        push(stack1,1);
        push(stack1,2);
        push(stack1,3);
        int result=poll(stack1,stack2);
        push(stack1,4);
        push(stack1,5);
        push(stack1,6);
        int result2=poll(stack1,stack2);
        int result3=poll(stack1,stack2);
        int result4=poll(stack1,stack2);
        int result5=poll(stack1,stack2);
        int result6=poll(stack1,stack2);
    }
   public  static void push(Stack<Integer> stack1,Integer num){
     stack1.add(num);
   }
   public static Integer poll(Stack<Integer> stack1,Stack<Integer> stack2){
     if(!stack2.isEmpty()){
         int value=stack2.pop();
         return value;
     }else{
         while (!stack1.isEmpty()){
             int val=stack1.pop();
             stack2.push(val);
         }
         int result=stack2.pop();
         return result;
     }
   }
}
