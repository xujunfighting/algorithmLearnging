package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/25
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] a = new int[100];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        int[] b = new int[100];
        b[0] = 2;
        b[1] = 4;
        b[2] = 6;
        b[4] = 8;
        int[] merge = merge(a, 4, b, 4);

    }

    public static int[] merge(int[] a, int n, int[] b, int m) {
        int index1=0;
        int index2=0;
        int swap=0;

            while(index1<n&&index2<m) {
                if (a[index1] <= b[index2]) {
                    index1++;
                } else {
                    swap=a[index1];
                    a[index1]=b[index2];
                    if(swap>b[index2+1]){
                        index2++;
                    }else {
                        b[index2]=swap;
                        index1++;
                    }
                }
            }
        System.out.println("");

        return a;
    }
}
