package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/25
 */
public class FindResultInRotateArray {
    public static void main(String[] args) {
           int[] array=new int[]{7,6,5,4,3,2,1,0};
           int result = getResult(array, 3);
           System.out.println(result);
    }
    public static int getResult(int[] array,int target){
        int start=0;
        int end=array.length-1;
        int index=-1;
        if(array==null||array.length==0){
            return index;
        }
        while(start<end){
            if(array[start]==target){
                return start;
            }
            if(array[end]==target){
                return end;
            }
            if(end-start==1){
                break;
            }
           //一般情况是前大后小
            if(target>array[start]){//结果在头后面
                   int middle=(start+end)/2;
                   if(array[middle]==target){
                       return middle;
                   }else if(array[middle]>array[start]&&array[middle]>target){//正序
                       end=middle-1;
                   }else if(array[middle]>array[start]&&array[middle]<target){
                       start=middle+1;
                   }else if(array[middle]<array[start]){
                       start++;
                       end=middle-1;
                   }

            }else if(target<array[end]){//结果在尾部
                   int middle=(start+end)/2;
                   if(array[middle]==target){
                       return middle;
                   }else if(array[middle]<array[end]&&array[middle]>target){
                       end=middle-1;
                   }else if(array[middle]<array[end]&&array[middle]<target){
                       start=middle+1;
                   }else{
                       end--;
                       start=middle+1;
                   }

            }else if(target<array[start]&&target>array[end]){//完全倒序
                  int middle=(start+end)/2;
                  if(array[middle]==target){
                      return middle;
                  }else if(array[middle]<target){
                      end=middle-1;
                  }else if(array[middle]>target){
                      start=middle+1;
                  }
            }
        }
        if(start==end&&array[start]==target){
            return start;
        }
        return index;
    }
}
