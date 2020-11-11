package com.zto.sort;

/**
 * Created by xujun on 2018-11-21.
 */
public class QuickSort3Ways {
    public static void main(String[] args){
      int[] a=new int[]{4,2,3,4,1,2,3,4,5,6,10,11,4};
      sort(a,0,a.length-1);
      System.out.println();
      print(a);
    }
    public static void sort(int[] a,int l,int r){

        if(r<=l){
            return;
        }
        int lt=l;
        int gt=r+1;//gt到r的元素大于v
        int i=l;//l到lt的元素小于v
        int v=a[l];//lt+1到gt-1的元素等于v
        while(i<gt){
            if(v>a[i]){//将与当前v想等的元素和小于v的元素进行交换 保证l到lt的元素都小于v
                int temp=a[i];
                a[i]=a[lt+1];
                a[lt+1]=temp;
                i++;
                lt++;
            }else if(v<a[i]){//当前元素小于比较元素时和最后的元素进行交换
                int temp=a[i];
                a[i]=a[gt-1];
                a[gt-1]=temp;
                gt--;
            }else{
                i++;
            }
        }
        int  temp=a[lt];
        a[lt]=v;
        a[l]=temp;
        print(a);
        System.out.println();
        sort(a,l,lt-1);
        sort(a,gt,r);
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void sort4(int[] arr,int l,int r){
        if (r <=l ) {

            return;
        }
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
            print(arr);
        }
        //swap(arr[l], arr[lt],arr);
        int temp=arr[l];
        arr[l]=arr[lt];
        arr[lt]=temp;
        print(arr);
        System.out.println();
        sort4(arr, l, lt - 1);
        sort4(arr, gt, r);
    }

}
