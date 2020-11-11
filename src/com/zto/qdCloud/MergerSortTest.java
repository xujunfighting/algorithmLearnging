package com.zto.qdCloud;

/**
 * Author xujun
 * Create date 2019-04-26.
 * desc:
 */
public class MergerSortTest {
    public static void main(String[] args) {
        int[] a=new int[]{1,4,5,2,3,8,10,9,6,7};
        mergeSort(0,a.length-1,a);
        print(a);
    }
    public static void mergeSort(int left,int right,int[] temp){
            if(left>=right){return;}
            int middle=(left+right)/2;
            mergeSort(left,middle,temp);
            mergeSort(middle+1,right,temp);
            merge(temp,left,middle,middle+1,right);

    }
    public static void merge(int[] a,int start1,int end1,int start2,int end2){
        int start11=start1;
        int end11=end1;
        int start22=start2;
        int end22=end2;
        int[] merge=new int[end1-start1+end2-start2+2];
        int index=0;
        while(start11<=end11&&start22<=end22){
            if(a[start11]<a[start22]){
                merge[index++]=a[start11];
                start11++;
            }else{
                merge[index++]=a[start22];
                start22++;
            }
        }
        while(start11<=end11){
            merge[index++]=a[start11++];
        }
        while(start22<=end22){
            merge[index++]=a[start22++];
        }
        for(int i=0;i<merge.length;i++){
            a[start1+i]=merge[i];
        }
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
