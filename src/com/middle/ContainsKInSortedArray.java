package com.middle;

public class ContainsKInSortedArray {
    public static void main(String[] args) {
       int[] res=new int[]{3,3,3,3,4,5};
       int result=getResult(res,10);
        System.out.println(result);
    }
    public static int getResult(int[] array,int k){
        int start=0;
        int end=array.length-1;
        int result=0;
        if(array[start]>k||array[end]<k){
            return 0;
        }
        int middle=0;
        boolean isExists=false;
        while(start<end){
            middle=(start+end)/2;
            if(array[middle]>k){
                end=middle;
            }else if(array[middle]<k){
                start=middle;
            }else{
                isExists=true;
               break;
            }
        }
        if(isExists){
            result=1;
            int p=middle-1;
            int q=middle+1;
            while((p>=0&&array[p]==k)||(q<array.length&&array[q]==k)){
                if(p>=0&&array[p--]==k){
                    result++;
                }

                if(q<array.length&&array[q++]==k){
                    result++;
                }
            }
        }
        return result;
    }
}
