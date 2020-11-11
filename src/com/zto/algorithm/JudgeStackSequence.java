package com.zto.algorithm;

import java.util.Stack;

/**
 * Created by xujun on 2018-08-29.
 */
public class JudgeStackSequence {
    public static  void main(String[] args){
       int[] s1={1,2,3,4,5,6,7};
       int[] s2={7,6,5,4,3,2,1};
       Stack<Integer> res=new Stack<>();
       boolean result=func(s1,s2);
       System.out.print(result);
    }
    public static boolean func(int[] s1,int[] s2){
        //s1表示数列的顺序   s2表示弹出的顺序
        Stack<Integer> res=new Stack<>();
        int index1=0;
        int index2=0;
        while(index1<s1.length&&index2<s2.length){

           if(!res.isEmpty()&&res.peek()==s2[index2]&&index2<s2.length){
                res.pop();
                index2++;
            }else if(s1[index1]!=s2[index2]&&index1<s1.length){//一直查找到最后一个元素
                res.push(s1[index1]);
                index1++;
            }else if(s1[index1]==s2[index2]){
                if(index1<(s1.length-1)) {
                    index1++;
                }
                index2++;
            }
        }
        if(res.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
