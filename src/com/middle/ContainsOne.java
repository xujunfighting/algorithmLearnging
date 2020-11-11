package com.middle;

public class ContainsOne {
    public static void main(String[] args) {

    }
    public static int getResult(int n){
        int index=1;//数据存储位
        int count=0;//记录位置为1的个数
        int cur=1;
        while(cur<n){
            for(int i=1;i<=index;i++){
               if(cur>=n){
                    return count;
                }else{
                   return 1;
               }
            }
        }
        return 0;
    }

}
