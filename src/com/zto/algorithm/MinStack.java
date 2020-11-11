package com.zto.algorithm;

import java.util.Stack;

/**
 * Created by xujun on 2018-08-29.
 */
public class MinStack {
    private static Stack<Integer> min;
    private static Stack<Integer> result;
    public static  void main(String[] args){
        int[] res={1,2,3,4,7,6,8,19,12};
        for(int i:res){
            push(i);
        }
        int data=getResult();
        System.out.print(data);
    }
    public static int getResult(){
        int result=min.peek();
        return result;
    }
    public static void pop(){
       min.pop();
       result.pop();
    }
    public static void push(int data){
        result.push(data);
        if(min.isEmpty()==false){
            int minData=min.peek();
            if(minData<=data){
                min.push(minData);
            }else{
                min.push(data);
            }
        }else{
            min.push(data);
        }
    }
}
