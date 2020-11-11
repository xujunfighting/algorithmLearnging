package com.zto.sort;

import java.util.Random;

/**
 * Created by xujun on 2018-10-29.
 */
public class QuickSort {
    public static int xujun = 0;

    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 6, 3, 2, 4, 9, 1, 8,5,5};
        //sort2(a, 0, a.length - 1, 3);
        //sort4(a,0,a.length-1);
        System.out.println("result:--------------------------");
        sort1(a,0,a.length-1);
        print(a);
        //System.out.print(a[xujun]);
    }

    public static void sort(int[] a, int start, int end) {
        if(start>=end||start>=a.length||end<0){
            return;
        }
        int left = start;
        int right = end;
        int temp = 0;
        Random ran = new Random();
        int index = 0;
        if (end > start) {
            index = ran.nextInt(end - start) + start;
        } else if (end == start) {
            index = start;
            System.out.println(left + " ");
        }

        temp = a[left];
        a[left] = a[index];
        a[index] = temp;
        if (left <= right) {   //待排序的元素至少有两个的情况
            temp = a[left];  //待排序的第一个元素作为基准元素
            while (left != right) {   //从左右两边交替扫描，直到left = right

                while (right > left && a[right] >= temp)
                    right--;        //从右往左扫描，找到第一个比基准元素小的元素
                a[left] = a[right];  //找到这种元素arr[right]后与arr[left]交换

                while (left < right && a[left] <= temp)
                    left++;         //从左往右扫描，找到第一个比基准元素大的元素
                a[right] = a[left];  //找到这种元素arr[left]后，与arr[right]交换

            }
            a[right] = temp;    //基准元素归位
            sort(a, start, left - 1);  //对基准元素左边的元素进行递归排序
            sort(a, right + 1, end);  //对基准元素右边的进行递归排序
        }

    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void sort1(int[] a, int start, int end) {
        if ((start - 15) <= end) {
            InsertSort.sort(a);
            return;
        }
        int left = start;
        int right = end;
        Random ran = new Random();
        int index = 0;
        int temp = 0;
        if (end > start) {
            index = ran.nextInt(end - start) + start;
        } else if (end == start) {
            index = start;
            System.out.println(left + " ");
        }

        temp = a[left];
        a[left] = a[index];
        a[index] = temp;
        temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        sort1(a, start, left - 1);
        sort1(a, left + 1, end);

    }

    public static void sort2(int[] a, int start, int end, int result) {
//        if(start>=end){
//            return;
//        }
        int left = start;
        int right = end;
        Random ran = new Random();
        int index = 0;
        int temp = 0;
        if (end > start) {
            index = ran.nextInt(end - start) + start;
        } else if (end == start) {
            index = start;
            System.out.println(left + " ");
        }

        temp = a[left];
        a[left] = a[index];
        a[index] = temp;
        temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        if (result == left) {
            xujun = index;
            return;
        }
        if (index < left) {
            sort2(a, start, left - 1, result);
        }
        if (index > left) {
            sort2(a, left + 1, end, result);
        }

    }

    public static void sort3(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int v = a[start];
        int j;
        j = start;
        for (int i = start + 1; i <= end; i++) {
            if (a[i] < v) {
                //swap(arr[j+1],arr[i]);
                int temp = a[j + 1];
                a[j + 1] = a[i];
                a[i] = temp;
                j++;
            }

        }
        //swap(arr[l],arr[j]);
        int temp = a[start];
        a[start] = a[j];
        a[j] = temp;
        sort3(a, start, j - 1);
        sort3(a, j + 1, end);
    }




}
