package com.zto.offer;

/**
 * Created by xujun on 2018-12-11.
 */
public class QuickSort {
    public static void main(String[] args){
        //int[] a=new int[]{5,6,2,3,9,8,1,4};
        int[] a=new int[]{4,2,3,4,1,2,3,4,5,6,10,11,4};
        ThreeWaySort(a,0,a.length-1);
        print(a);
    }
    public static void oneWaySort(int[] a,int start,int end){
        if(start>=end) return;
        int index=a[start];
        int j=start+1;
        for(int i=start;i<=end;i++){
            if(a[i]<index){
                int temp=a[j];
                a[j]=a[i];
                a[i]=temp;
                j++;
            }
        }
        int temp=a[j-1];
        a[j-1]=a[start];
        a[start]=temp;
        oneWaySort(a,start,j-2);
        oneWaySort(a,j,end);
    }
    public static void doubleWaySort(int[] a,int start,int end){
        if(start>=end) return;
        int index=a[start];
        int i=start;
        int j=end;
        while(i<j){
          while (a[j]>index&&i<j){
                j--;
            }
            a[i] = a[j];
            while(a[i]<=index&&i<j){
                i++;
            }
            a[j]=a[i];
        }
        a[i]=index;
        doubleWaySort(a,start,i-1);
        doubleWaySort(a,i+1,end);
    }
    public static void ThreeWaySort(int[] a,int start,int end){
        if(start>=end) return;
       int index=a[start];
       int i=start;
       int p=start;
       int q=end+1;
       while(i<q)
       {
          if(a[i]<index){//将等于当前角标值的数据向后移动
              int temp=a[i];
              a[i]=a[p+1];
              a[p+1]=temp;
              p++;
              i++;
             }else if(a[i]>index){//将第一个大于角标的元素和最后一个元素交换
              int temp=a[q-1];
              a[q-1]=a[i];
              a[i]=temp;
              q--;
          }else{
                 i++;//i角标一直变动直到第一个小于index的数据
          }
       }
       int temp=a[p];
       a[p]=a[start];
       a[start]=temp;
        ThreeWaySort(a,start,p-1);
        ThreeWaySort(a,q,end);
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
