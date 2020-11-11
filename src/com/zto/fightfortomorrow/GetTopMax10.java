package com.zto.fightfortomorrow;

import java.util.Random;

/**
 * Author xujun
 * Create date 2019-05-06.
 * desc:
 */
public class GetTopMax10 {
    public static Random random=new Random();
    public static int[] b=new int[10];
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,18,5,6,7,8,9,10,11,12,13,14,15,16};
        method(a,0,a.length,10);
    }
    public static void method(int[] a,int start,int end,int num){
        if(start>=end) return ;
        int partition=random.nextInt(end);
        int begin=start;
        int last=end-1;
        int res=a[partition-1];
        while(begin<=last){
            while(a[last]>=res){
               last--;//找到第一个小于匹配值的数据
            }
            a[partition-1]=a[last];
            while(a[begin]<=res){
                begin++;//找到第一个大于匹配值的数据‘
            }
            a[last]=a[begin];
        }
        a[begin]=res;
        if(partition==num){
            for(int i=0;i<partition;i++){
                b[i]=a[i];
            }
        }
        if(num<partition)
            method(a,start,partition-2,num);
        if(num>partition)
            method(a,partition,end,num);

    }
}
