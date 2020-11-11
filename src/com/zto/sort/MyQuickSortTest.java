package com.zto.sort;

/**
 * Created by xujun on 2018-11-17.
 */
public class MyQuickSortTest {
    public static void main(String[] args){
        int[] a = new int[]{5, 7, 6, 3, 2, 4, 9, 1};
        sort4(a,0,a.length-1);
        InsertSort.print(a);
    }
    public static void sort(int[] a,int start,int end){
        if(start>=end){
            return;
        }
        int j=start;
        int v=a[start];
        for(int i=start+1;i<=end;i++){
            if(a[i]<v){
                int temp=a[j+1];
                a[j+1]=a[i];
                a[i]=temp;
                j++;
            }
        }
        int temp=a[j];
        a[j]=a[start];
        a[start]=temp;
        sort(a,start,j-1);
        sort(a,j+1,end);
    }
    public static void sort4(int[] arr,int l,int r){
        if (r <=l ) {

            return;
        }

        // partitio
        //swap(arr[l], arr[(int) (Math.random() * (r - l + 1)) + l]);
        int v = arr[l];
        // arr[l+1,lt]<v
        int lt = l;
        // arr[gt,r]>v
        int gt = r+1;
        // arr[lt+1,i)==v
        int i = l + 1;
        while (i < gt) {
            System.out.println("arr[i]:"+arr[i]+" and v:"+v);
            if (arr[i] < v) {
                //swap(arr[i], arr[lt + 1],arr);
                int temp=arr[i];
                arr[i]=arr[lt+1];
                arr[lt+1]=temp;
                lt++;
                i++;
            } else if (arr[i] > v) {
                //swap(arr[i], arr[gt - 1],arr);
                int temp=arr[i];
                arr[i]=arr[gt-1];
                arr[gt-1]=temp;
                gt--;
            } else {
                i++;
            }
            System.out.println();
            //print(arr);
        }
        //swap(arr[l], arr[lt],arr);
        int temp=arr[l];
        arr[l]=arr[lt];
        arr[lt]=temp;
        sort4(arr, l, lt - 1);
        sort4(arr, gt, r);
    }
}
