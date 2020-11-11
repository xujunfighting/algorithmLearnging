package com.zto.newYear;

import java.util.Stack;

/**
 * Created by xujun on 2019-01-14.
 */
public class JudegeStackSequence {
    private static Stack<Integer> stack=new Stack<Integer>();
    public static void main(String[] args){
        int[] a=new int[]{1,2,3,4,5,6,7,8};
        int[] result=new int[]{8,7,6,5,4,3,2,1};
        boolean res=method(a,result,0,a.length-1,0,result.length-1);
        System.out.print(res);
    }
    public static boolean method(int[] a,int [] b,int start1,int end1,int start2,int end2){
        boolean result=false;
         while(start1<=end1&&start2<=end2) {
             while (a[start1] != b[start2]) {
                 stack.add(a[start1]);
                 start1++;
             }
             if(a[start1]==b[start2]){
                 start1++;//过滤掉当前的元素
                 start2++;
             }
            while(!stack.isEmpty()&&stack.peek()==b[start2]) {
               stack.pop();
               start2++;
            }
         }
         if(stack.isEmpty()){
             result=true;
         }else{
             result=false;
         }
        return result;
    }
}
