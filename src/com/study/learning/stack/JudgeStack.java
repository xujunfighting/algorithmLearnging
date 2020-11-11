package com.study.learning.stack;

import java.util.Stack;

/**
 * Author xujun
 * Create date 2020-01-05.
 * desc:
 */
public class JudgeStack {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
       int[] inPut = new int[]{1,2,3,4,5};
       int[] outPut =  new int[]{1,2,3,4,5};
       boolean result = judgeStack(inPut,outPut,0,0);
        System.out.println(result);
    }
    public static boolean judgeStack(int[] in,int[] out,int startIn,int startOut){
        if(startIn >= in.length||startOut >= out.length){
            if(stack.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
        int index=out[startOut];
        int i=startIn;
        while(i<in.length&&in[i]!=index){//查找到第一个相等的元素
            stack.add(in[i]);
            i++;
        }
        while((startOut+1)<out.length&&!stack.isEmpty()&&stack.peek() == out[startOut+1]){
            stack.pop();
            startOut++;
        }
        return judgeStack(in,out,i+1,startOut+1);
    }
}
