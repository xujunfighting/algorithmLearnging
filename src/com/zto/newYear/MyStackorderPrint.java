package com.zto.newYear;

import java.util.Stack;

/**
 * Created by xujun on 2019-01-31.
 */
public class MyStackorderPrint {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        mehtod(stack);
        print(stack);
    }
    public static void mehtod(Stack<Integer> stack){
        Stack<Integer> temp=new Stack<>();
        while(!stack.isEmpty()){
            int current=stack.pop();
            while(!temp.isEmpty()&&temp.peek()>current){
                stack.push(temp.pop());
            }
            temp.push(current);
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
    public static void print(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
