package com.zto.offer;

/**
 * Created by xujun on 2018-11-28.
 */
public class JudgeOddAndEven {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        int[] b = method2(a);
        print(b);
    }

    public static int[] method(int[] a) {
        int[] b = new int[a.length];
        int start = 0;
        int end = b.length - 1;
        int l = 0;
        int r = b.length - 1;
        while (start < b.length && end >= 0) {
            while (a[start] % 2 != 0 && start < b.length - 1) {
                start++;
            }
            b[l++] = a[start++];
            while (a[end] % 2 == 0 && end > 0) {
                end--;
            }
            b[r--] = a[end--];
        }
        return b;
    }

    public static int[] method2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int  time=0;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    time++;
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
            print(array);
            System.out.println();
            if(time==0){
                return array;
            }
        }
        return array;
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
