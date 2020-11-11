package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-29.
 * desc:
 */
public class BubbleSort {
    public static void main(String[] args) {
       int[] a=new int[]{2,3,4,5,1,6};
        a=method(a);
        InsertOrder.print(a);
    }
    public static int[] method(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }
}
