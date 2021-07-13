package com.niuke.array;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/12
 **/
public class NextArrayDictionaryCombination {

    public static void main(String[] args) {
       int[] ints=new int[]{5,4,7,5,3,2};
       //2,3,1
       method(ints);
        System.out.println(ints);

    }
    public static void method(int[] array){
        int start=0;
        int end=array.length-1;
        int swap=0;
        /**
         * 当前元素只有一个直接返回
         */
        if(start==end){
            return;
        }
        /**
         * 查找第一个构成非降序排列的两个相邻数组元素
         * 如果没有表明这个是最后一个排列 直接构建第一个升序排列
         */
        while(end>start&&array[end]<=array[end-1]){
            end--;
        }
        if(end>start){
            /**
             * 升序排列为第一个和第二个元素
             */
            int firstLarge=0;
            for(int i=array.length-1;i>=1;i--){
                if(array[i]>array[end-1]){
                    firstLarge=i;
                    break;
                }
            }
            swap=array[firstLarge];
            array[firstLarge]=array[end-1];
            array[end-1]=swap;
            start=end;
            end=array.length-1;
            while(start<end){
                swap=array[start];
                array[start]=array[end];
                array[end]=swap;
                start++;
                end--;
            }
        }else if(end==0){
            /**
             * 构造升序排列
             */
            start=0;
            end=array.length-1;
            while(start<end){
                swap=array[start];
                array[start]=array[end];
                array[end]=swap;
                start++;
                end--;
            }
        }
    }

}
