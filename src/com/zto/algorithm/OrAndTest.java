package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-31.
 */
public class OrAndTest {
    public static void main(String[] args){
        int[] res={1,1,2,3,5,6,7,8};
        System.out.print(getResult(res));
    }
    public static int getResult(int[] arr){
        int res=0;
        int sum=0;
        for(int i:arr){
            res=res^i;
        }
        for(int i:arr){
            sum+=i;
        }
        int result=(sum-res)/2;
        return result;

    }
}
