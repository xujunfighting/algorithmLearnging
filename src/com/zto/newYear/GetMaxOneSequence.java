package com.zto.newYear;

/**
 * Created by xujun on 2019-01-16.
 */
public class GetMaxOneSequence {
    public static void main(String[] args){
     int[] a=new int[]{1,0, 0 ,1, 0, 1, 0 ,1 ,0, 1,1};
     int result=length(a,3);
     System.out.print(result);
    }
    public static int length(int[] a,int len){
        int index=0;
        int count=0;
        int result=0;
        for(int i=0;i<a.length-1;i++){
            count=0;
            index=0;
            if(a[i]==1){
                index++;
            }else{
                index++;
                count++;
            }
            for(int j=i+1;j<a.length;j++){
                if(a[j]==0){
                    if(count==len){
                        break;
                    }
                    count++;
                    index++;
                }else{
                    index++;
                }
            }
            if(result<index){
                result=index;
            }
        }
        return result;
    }

}
