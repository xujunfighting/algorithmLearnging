package com.zto.offer;

import java.util.Stack;

/**
 * Created by xujun on 2018-11-30.
 */
public class JudegeStackOrder {
    public static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args){
        int[] a=new int[]{1,2,3,4,5};
        int[] b=new int[]{5,4,3,2,1};
        boolean result=judege(a,b,0,4,0,4);
        System.out.print(result);
    }
    public static boolean judege(int[] a,int[] b,int start1,int end1,int start2,int end2){
        if(start1>end1){
            if(stack.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
       int val=b[start2];
       while(a[start1]!=val&&start1<=end1){//查找到第一个元素
           stack.add(a[start1]);
           start1++;
       }
       while(!stack.isEmpty()&&b[1+start2]==stack.peek()){
           stack.pop();
           start2++;
       }
       return judege(a,b,start1+1,end1,start2+1,end1);
    }
}
