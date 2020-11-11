package com.study.learning.sort;

/**
 * Author xujun
 * Create date 2019-12-30.
 * desc:
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] num =  new int[]{2,3,10,1,4,7,8,5,6};
        num=method(num);
        print(num);
    }
    public static int[] method(int[] a){
        for(int i=0;i<a.length-1;i++){
            int index=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[index]){
                    index=j;
                }
            }
            int temp=a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        return a;
    }
    public static void print(int[] b){
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
    }
}
