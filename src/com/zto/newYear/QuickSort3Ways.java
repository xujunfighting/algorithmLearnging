package com.zto.newYear;

/**
 * Created by xujun on 2019-01-02.
 */
public class QuickSort3Ways {
    public static void main(String[] args){
        int[] a=new int[]{4,2,3,4,4,5,10};
        method(a,0,a.length-1);
        print(a);
    }
    public static void method(int[] a,int start,int end){
        if(start>=end){
            return ;
        }
        int p=start;//start到p的元素小于角标数据
        int q=end+1;//q到end的数据大于角标数据
        int index=start;// p
        int v=a[start];
        while(index<q){
             if(a[index]<v){
                int temp=a[p+1];
                a[p+1]=a[index];
                a[index]=temp;
                p++;
                index++;
             }else if(a[index]>v){
                int temp=a[q-1];
                a[q-1]=a[index];
                a[index]=temp;
                q--;
             }else{
                index++;
             }
        }
        int temp=a[start];
        a[start]=a[p];
        a[p]=temp;
        method(a,start,p-1);
        method(a,q,end);
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
