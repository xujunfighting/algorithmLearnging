package com.zto.algorithm;

/**
 * Created by xujun on 2018-12-24.
 */
public class getOrderOddAndEven {
    public static void main(String[] args){
        int[] a=new int[]{1,2,3,4,5,6,7,8};
        int[] b=new int[a.length];
        a=method(a,b);
        print(a);
    }
    public static int [] method(int[] a,int[] b){
        int i=0;
        int j=b.length-1;
        int p=0;
        int q=b.length-1;
        while(p<b.length&&q>=0){
            if(a[p]%2==1){
                b[i++]=a[p];
            }
            if(a[q]%2==0){
                b[j--]=a[q];
            }
            p++;
            q--;
        }
        return b;
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
