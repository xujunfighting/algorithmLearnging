package com.niuke.array;

public class CountVowelStrings {
    private static String[] res=new String[]{"a","e","i","o","u"};
    private static int totalCount=0;
    public static void main(String[] args) {
         getResult(33,0);
        System.out.println(totalCount);
    }

    public static void getResult(int len,int curIndex){
        if(len==0){
            /**
             * 当长度减成0 表示达到长度要求 统计计数加一
             */
            totalCount++;
            return;
        }
        /**
         * 当前角标为必须大于等于上一次添加角标
         */
        for(int i=curIndex;i<res.length;i++){
            getResult(len-1,i);
        }
    }
}
