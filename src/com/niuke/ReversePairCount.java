package com.niuke;

public class ReversePairCount {
    public static int result=0;
    public static int count=1;
    public static int changeCount=0;
    public static void main(String[] args) {
       int[] arrays=new int[]{3,2,4,1,5};
        mergeSort(arrays,0,4);
        System.out.println(changeCount);
    }
   public static void  mergeSort(int[] arrays,int start,int end){
        if(start>=end){
            return;
        }
        int middle=(start+end)/2;
        mergeSort(arrays,start,middle);
        mergeSort(arrays,middle+1,end);
        merge(arrays,start,middle,middle+1,end);
        System.out.print("第"+(count++)+"次的执行结果为:");
        print(arrays);
       System.out.println();
    }
    public static void merge(int[] arrays,int start1,int end1,int start2,int end2){
        int[] temp=new int[end1-start1+end2-start2+2];
        int p1=start1;
        int p2=start2;
        int index=0;
        while(p1<=end1&&p2<=end2){
            if(arrays[p1]<arrays[p2]){
                temp[index++]=arrays[p1];
                p1++;
            }else{
                /**
                 * 因为merge的每个子数组都是局部有序
                 * 找到第一个后继数组元素小于前继数组的元素 表明前继数组中当前位置开始的的元素都大于后继数组中当前角标的元素
                 */
                changeCount+=(end1-p1)+1;
                temp[index++]=arrays[p2];
                p2++;
            }
        }
        if(p1<=end1){
            temp[index++]=arrays[p1++];
        }
        if(p2<=end2){
            temp[index++]=arrays[p2++];
        }
        for(int i=0;i<temp.length;i++){
            arrays[start1+i]=temp[i];
        }

    }
    public static void print(int[] arrays){
        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");
        }
    }
}
