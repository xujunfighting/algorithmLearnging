package com.niuke;

import java.util.HashMap;

public class FindNthUglyNum {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        int result = getResult3(1000);
        long end = System.currentTimeMillis();
//        System.out.println("执行时长为:"+(end-start)+"ms");

//        long start=System.currentTimeMillis();
//        int[] test=new int[1000];
//        for(int i=0;i<test.length;i++){
//            test[i]=i+1;
//        }
//        boolean find = isFind(test, test.length-1, 10);
//        long end = System.currentTimeMillis();
        System.out.println("执行时长为:"+(end-start)+"ms");
//        System.out.println(find);
        System.out.println(result);
   }
    public static int getResult1(int num){
        int[] indexs=new int[num];
        indexs[0]=1;
        for(int i=1;i<num;i++){
            int compare=indexs[i-1];
           for(int j=0;j<i;j++){
               int min=0;
               if(indexs[j]*2>compare) {
                   min= Math.min(Math.min(indexs[j] * 2, indexs[j] * 3), indexs[j] * 5);
               }else if(indexs[j]*3>compare){
                   min=Math.min(indexs[j]*3,indexs[j]*5);
               }else if(indexs[j]*5>compare){
                   min=indexs[j]*5;
               }
               if(indexs[i]==0){
                   indexs[i]=min;
               }else if(min>compare&&min<indexs[i]){
                   indexs[i]=min;
               }
           }
        }
        return indexs[num-1];
    }
    public static int getResult2(int num){
        int[] indexs=new int[num];
        indexs[0]=1;
        int start=1;
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
        m.put(start,start);
        for(int i=1;i<num;i++){
            boolean isGet=false;
            while(!isGet){
                start++;
                if((start%2==0&&m.containsKey(start/2))||(start%3==0&&m.containsKey(start/3))||(start%5==0&&m.containsKey(start/5))){

                    indexs[i]=start;
                    isGet=true;
                    m.put(start,start);
                }
            }
        }
        return indexs[num-1];
    }
    public static int getResult3(int num){
        int[] indexs=new int[num];
        indexs[0]=1;
        int start=1;
        for(int i=1;i<num;i++){
            boolean isGet=false;
            while(!isGet){
                start++;
                if((start%2==0&&isFind(indexs,i-1,start/2))||(start%3==0&&isFind(indexs,i-1,start/3))||(start%5==0&&isFind(indexs,i-1,start/5))){
                    //System.out.println("查找到的结果为:"+start);
                    indexs[i]=start;
                    isGet=true;
                }
            }
        }
        return indexs[num-1];
    }
    private static boolean isFind(int[] indexs,int end,int target){
        long startTime=System.currentTimeMillis();
        int start=0;
        if(indexs[start]==target){
            return true;
        }
        while(start<end){
            int middle=(start+end)/2;
            if(indexs[middle]==target){
                return true;
            }else if(indexs[middle]>target){
                end=middle-1;
            }else if(indexs[middle]<target){
                start=middle+1;
            }
        }
        if(start==end&&indexs[start]==target){
            return true;
        }
        long endTime=System.currentTimeMillis();
//        System.out.println("单次执行时长为:"+(endTime-startTime)+"ms");
        return false;
    }
}
