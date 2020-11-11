package com.zto.newYear;

import java.util.Stack;

/**
 * Created by xujun on 2019-01-30.
 */
public class SortStack {
    public static void main(String[] args) {
      Stack<Integer> stack=new Stack<>();
      stack.push(3);
      stack.push(4);
      stack.push(1);
      stack.push(2);
      stack.push(5);
      method(stack);
      print(stack);
    }
    public static void method(Stack<Integer> stack){
        Stack<Integer> help=new Stack<>();
        while(!stack.isEmpty()){
            int cur=stack.pop();
            while(!help.isEmpty()&&help.peek()>cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }

    }
    public static void print(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
