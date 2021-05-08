package com.niuke;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/5/8
 **/
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
       int[] a=new int[]{2};
       int[] b=new int[]{1};
       getResult(a,1,b,1);
    }

    public static void getResult(int[] a,int m,int[] b,int n){
        int[] arrays=new int[m];
        for(int i=0;i<m;i++){
            arrays[i]=a[i];
        }
        int start1=0;
        int start2=0;
        int index=0;
        while(start1<m&&start2<n){
            if(arrays[start1]<b[start2]){
               a[index++]=arrays[start1++];
            }else{
                a[index++]=b[start2++];
            }
        }
        while(start1<m){
            a[index++]=arrays[start1++];
        }
        while(start2<n){
            a[index++]=b[start2++];
        }
        System.out.println(a);
    }
}
