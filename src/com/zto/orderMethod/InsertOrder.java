package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-26.
 * desc:
 */
public class InsertOrder {
    public static void main(String[] args) {
        int[] a=new int[]{5,2,6,3,4,1};
        a=method(a);
        print(a);
    }
    public static int[] method(int a[]){
        for(int i=0;i<a.length-1;i++){
             if(a[i+1]<a[i]){
                 int temp=a[i+1];//临时记录当前值
                 int j=0;
                 for(j=i;j>=0;j--){
                     if(a[j]>temp) {
                         a[j+1] = a[j];
                     }else{
                         break;
                     }
                 }
                 a[j+1]=temp;
             }

        }
        return a;
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
}
