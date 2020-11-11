package com.zto.algorithm;

import java.util.Stack;

/**
 * Created by xujun on 2018-10-19.
 */
public class MyJudgeStack {
    public static void main(String[] args){
        int[] params1=new int[]{1,2,3,4,5,6};
        int[] params2=new int[]{4,3,2,1,6,5};
        Stack<Integer> ints=new Stack<Integer>();
        boolean result=isStackSequence(params1,0,params2,0,ints);
        System.out.print(result);
    }
    public static boolean isStackSequence(int[] params1,int start1,int[] params2,int start2,Stack<Integer> ints){
        while(start2<params2.length&&start1<=params1.length){
            while(!ints.isEmpty()&&ints.peek()==params2[start2]){
                ints.pop();
                start2++;
            }
            if(start2>=params2.length||start1>=params1.length){
                break;
            }
            int val=params2[start2];
            System.out.print(start1);
            while(start1<params1.length&&val!=params1[start1]){
                ints.add(params1[start1]);
                start1++;
            }
            if(start2<params2.length) {
                start1++;
                start2++;
            }
        }
        if(ints.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
