package com.study.learning.sort;

/**
 * Author xujun
 * Create date 2020-01-02.
 * desc:
 */
public class BubbleSort {
    public static void main(String[] args) {
       int[] num=new int[]{3,2,1,10,11,12,90,34,45,32,78,33,22,93,99};
       long startTime =  System.currentTimeMillis();
       num = method(num);
       long endTime = System.currentTimeMillis();
       print(num);
    }
    public static int[] method(int[] num){
        for(int i=0;i<num.length-1;i++){
            for(int j=num.length-1;j>=i+1;j--){
              if(num[j-1]>num[j]){
                  int temp=num[j-1];
                  num[j-1]=num[j];
                  num[j]=temp;
              }
            }
        }
        return num;
    }
    public static void print(int[] num){
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
}
