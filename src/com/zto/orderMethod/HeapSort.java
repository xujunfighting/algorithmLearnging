package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-29.
 * desc:
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a=new int[]{4,5,6,3,2,1,10,8,9,7};
        a=method(a);
        InsertOrder.print(a);
    }
    public static int[] method(int[] a){
        for(int i=1;i<a.length;i++){
            adjustHeap(a,i);
            int temp=a[a.length-i];
            a[a.length-i]=a[0];
            a[0]=temp;
        }
        return a;
    }
    public static int[] adjustHeap(int[] a,int i){
        for(int j=(a.length-i)/2-1;j>=0;j--){
            if(j*2+2>a.length-1){//表名只有左子树
               if(a[j]<a[2*j+1]) {
                   int temp=a[j];
                   a[j]=a[2*j+1];
                   a[2*j+1]=temp;
               }
            }else{
                if(a[j]<a[2*j+1]||a[j]<a[2*j+2]) {
                    if(a[2*j+1]>a[j*2+2]) {
                        int temp = a[j];
                        a[j] = a[2 * j + 1];
                        a[2 * j + 1] = temp;
                    }else{
                        int temp = a[j];
                        a[j] = a[2 * j + 2];
                        a[2 * j + 2] = temp;
                    }
                }
            }
        }
        return a;
    }
}
