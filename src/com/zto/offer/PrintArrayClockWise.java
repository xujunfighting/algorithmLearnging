package com.zto.offer;

/**
 * Created by xujun on 2018-11-29.
 * 1  2  3  4
 * 5  6  7  8
 * 9 10  11 12
 * 13 14 15 16
 * 17 18 19 20
 * 21 22 23 24
 */

public class PrintArrayClockWise {
    public static void main(String[] args){
        int[][] a=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}};
        print(a);
    }
    public static void print(int[][] a){
        int wid=a[0].length-1;//表示多少列
        int len=a.length-2;//表示多少行
        int count=a[0].length*a.length;
        int start1=0;
        int start2=0;
        int index=0;//作为计数器
        boolean flag=true;
        while(count>0){
            //先遍历行
            index=0;
            while(index<=wid){//从a[0][0]开始
                if(flag==true) {
                    System.out.print(a[start2][start1++] + " ");
                }else{
                    System.out.print(a[start2][start1--] + " ");
                }
                count--;
                index++;
            }
            if(flag){//控制角标越界
                start1--;
            }else{
                start1++;
            }
            index=0;//每次将index置为零
            //在遍历列
            while(index<=len){
                if(flag) {
                    System.out.print(a[++start2][start1] + " ");

                }else{
                    System.out.print(a[--start2][start1] + " ");
                }
                count--;
                index++;
            }
            if(flag==true){
                start1--;
                flag=false;
            }else{
                start1++;
                flag=true;
            }
            wid--;
            len--;
        }
    }
}
