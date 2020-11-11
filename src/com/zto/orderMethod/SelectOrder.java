package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-26.
 * desc:
 */
public class SelectOrder {
    public static void main(String[] args) {
        int[] a=new int[]{5,2,6,3,4};
        a=method(a);
        print(a);
    }
    public static int[] method(int[] a){
        int min=0;
        int index=0;
        for(int i=0;i<a.length-1;i++)
        {
            min=a[i];
            index=i;
            for(int j=i+1;j<a.length;j++){
                if(min>a[j]){
                    min=a[j];
                    index=j;
                }
                if(j==4){
                    System.out.println("123");
                }
            }

            int swap=0;
            swap=a[i];
            a[i]=a[index];
            a[index]=swap;
        }
        return a;
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
}
