package com.zto.offer;

/**
 * Created by xujun on 2018-11-26.
 */
public class FindOrderWay {

     /*
      * 1  2  8  9
      * 2  4  9  12
      * 4  7  10 13
      * 6  8  11 15
      */
     public static int[][] a=new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
     public static void main(String[] args){
        boolean result=method(a,10);
        System.out.print(result);
     }
     public static boolean method(int[][] a,int num){
         int len=0;
         int wid=a[0].length-1;
         boolean result=false;
         while(len<a.length&&wid>=0){
             if(a[len][wid]==num){
                 result=true;
                 return result;
             }else if(a[len][wid]>num){
                 wid--;
             }else{
                 len++;
             }
         }
         return result;
     }
}
