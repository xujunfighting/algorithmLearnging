package com.zto.newYear;

import java.util.Stack;


/**
 * Created by xujun on 2019-01-30.
 */
public class ReverserStack {
    public static void main(String[] args) {
      int[] a=new int[]{1,2,3,4,5};
      Stack<Integer> stack1=new Stack<>();
      Stack<Integer> stack2=new Stack<>();
      Stack<Integer> res=method(a,stack1,stack2,0);
      print(res);
    }
    public static Stack<Integer> method(int[] a,Stack<Integer> stack1,Stack<Integer> stack2,int index){
        if(index>=a.length){
            while(!stack1.isEmpty()){
                int val=stack1.pop();
                stack2.add(val);
            }
            return stack2;
        }
        stack1.add(a[index]);
         return method(a,stack1,stack2,index+1);
    }
    public  static void print(Stack<Integer> res) {
        while (!res.isEmpty()) {
            System.out.println(res.pop());
        }
    }
}
