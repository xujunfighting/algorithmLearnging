package com.zto.sort;

/**
 * Created by xujun on 2018-10-26.
 */
public class InsertSort {
    public static  void main(String[] args){
          int[] a=new int[]{1,6,5,4,2,7,9,3};
          a=sort(a);
          print(a);
    }
    public static int[] sort(int[] a){
        for(int i=1;i<a.length-1;i++){
           int j=i+1;
           int tmp=a[j];
           if(a[j]<a[i]){
               int v=i;
               while(v>=1&&a[j]<a[v]){
                   v--;
               }
               int r=0;
               for(r=j;r>v;r--){
                   a[r]=a[r-1];
               }
               a[r+1]=tmp;
           }
        }
        return a;
    }
    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
