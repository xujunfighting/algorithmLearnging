package com.hard;

public class ReorderArray {
    public static void main(String[] args) {
       int[] res=new int[]{1,2,3,4,5,6,7,8};
       reOrderArray(res);
        System.out.println(res);
    }
    public static void reOrderArray(int[] array){
       int[] odd=new int[array.length];
       int index1=0;
       int[] even=new int[array.length];
       int index2=0;
       for(int i=0;i<array.length;i++){
           if(array[i]%2==1){
               odd[index1++]=array[i];
           }
           if(array[i]%2==0){
               even[index2++]=array[i];
           }
       }
       int index=0;
       for(int j=0;j<index1;j++){
           array[index++]=odd[j];
       }
       for(int k=0;k<index2;k++){
           array[index++]=even[k];
       }
    }
}
