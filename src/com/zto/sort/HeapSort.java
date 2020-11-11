package com.zto.sort;

/**
 * Created by xujun on 2018-10-26.
 */
public class HeapSort {
    public static void main(String[] args){
        int[] a=new int[]{0,6,10,3,4,1,2,5,7,9,8};
        heapSort(a);
        print(a);
    }
    public static void heapSort(int[] a){
         for(int i=1;i<a.length;i++){
             adjustHeap(a,a.length-i);
             System.out.print(a[1]);
             int temp=a[a.length-i];
             a[a.length-i]=a[1];
             a[1]=temp;
         }
    }
    public static int[] adjustHeap(int[] a,int len){
        for(int i=len/2;i>=1;i--){
           if(i*2+1>len){//只有左子树
              if(a[i*2]<a[i]){
                  int temp=a[i*2];
                  a[i*2]=a[i];
                  a[i]=temp;
              }

           }else{//存在左右子树
               if(a[i*2]<a[i]||a[i*2+1]<a[i]){
                   if(a[i*2]<a[i*2+1]) {
                       int temp=a[i*2];
                       a[i*2]=a[i];
                       a[i]=temp;
                   }else{
                       int temp=a[i*2+1];
                       a[i*2+1]=a[i];
                       a[i]=temp;
                   }
               }
           }

        }
        return a;
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
