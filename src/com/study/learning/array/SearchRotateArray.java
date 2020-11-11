package study.learning.array;

import netscape.javascript.JSUtil;

public class SearchRotateArray {
    public static void main(String[] args) {
        int[] nums=new int[]{4,5,6,7,0,1,2};
        int result=findIndex(nums,3);
        System.out.println(result);
    }
    public static int findIndex(int[] arr,int target){
        if(arr.length==0) return -1;
        if(arr.length==1){
            if(arr[0]==target){
                return 0;
            }else{
                return -1;
            }
        }
        int start=0;
        int end=arr.length-1;
        boolean flag=true;
        if(arr[start]<=arr[end]){//表明数组有序没有发生旋转
            if(target<arr[start]||target>arr[end]){
                return -1;
            }
            for(int i=0;i<arr.length;i++){
               if(arr[i]==target){
                   return i;
               }
            }
        }else{
            if(target>arr[start]){
                do{
                    if(arr[start]==target){
                        return start;
                    }
                    if(arr[start]>=arr[start+1]){
                        flag=false;
                    }
                    start++;
                }while(flag);
                return -1;
            }else if(target<arr[end]){
                do{
                      if(arr[end]==target){
                          return end;
                      }
                    if(arr[end]<=arr[end-1]){
                        flag=false;
                    }
                      end--;
                  }while(flag);
                  return -1;
            }
        }
        return -1;
    }
}
