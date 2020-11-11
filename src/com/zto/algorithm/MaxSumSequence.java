package com.zto.algorithm;

/**
 * Created by xujun on 2018-11-07.
 */
public class MaxSumSequence {
    public static void main(String[] args){
        int a[]=new int[]{6,-3,-2,7,-15,1,2,2};
        int result=solution(a);
        System.out.print(result);
    }
    public static int solution(int[] a){
        int max=0;
        int result=0;
        for(int i=0;i<a.length;i++){
            if(max>=0){
                max+=a[i];
                if(result<max){
                    result=max;
                }
            }else{
                max=0;
            }
        }
        return result;
    }
}
