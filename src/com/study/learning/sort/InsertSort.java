package com.study.learning.sort;

/**
 * Author xujun
 * Create date 2019-12-30.
 * desc:
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] num =  new int[]{2,3,10,1,4,7,8,5,6};
        num=method(num);
        print(num);
    }
    public static int[] method(int[] num){
        for(int i=0;i<num.length-1;i++){
            int index=num[i+1];
            int k=0;
            for(k=i;k>=0&&num[k]>index;k--){
                num[k+1]=num[k];
            }
            num[k+1]=index;
        }
        return num;
    }
    public static void print(int[] num){
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
}
