package com.middle;

public class DuplicateNumber {

    public static void main(String[] args) {
       int[] res= new int[]{};
       int result=getResult(res);
        System.out.println(result);
    }
    public static int getResult(int[] res){
        if(res.length==0){
            return -1;
        }
        int[] num= new int[res.length];
        for(int i=0;i<res.length;i++){
            num[res[i]]=num[res[i]]+1;
        }
        for(int i=0;i<num.length;i++){
            if(num[res[i]]>1){
                return res[i];
            }
        }
        return 0;
    }
}
