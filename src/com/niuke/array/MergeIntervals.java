package com.niuke.array;

/**
 * @author xujun
 * @Description
 * @create 2021-09-20 9:57 PM
 **/
public class MergeIntervals {

    public static void main(String[] args) {
          int[][] intervals = new int[][]{{1,4},{2,3}};
//        输出：[[1,6],[8,10],[15,18]]
        int[][] merge = mergeEnhance(intervals);
        System.out.println(merge);
    }
    //有序性
    public static int[][] merge(int[][] intervals){
        if(intervals.length==1){
            return intervals;
        }
        int[][] results=new int[intervals.length][2];
        int index=0;
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){

            if(end>=intervals[i][0]&&end<intervals[i][1]){
               //更新end值
                end = intervals[i][1];
            }else{
                //不存在重叠区间 直接添加前继元素
                results[index][0]=start;
                results[index][1]=end;
                index++;
                //更新start和end
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        results[index][0]=start;
        results[index][1]=end;
        int len=index+1;
        int[][] res=new int[len][2];
        for(int i=0;i<len;i++){
            res[i][0]=results[i][0];
            res[i][1]=results[i][1];
        }
        return res;
    }
    //无序性
    public static int[][] mergeEnhance(int[][] intervals){
        //保证有序性
        for(int i=0;i<intervals.length;i++){
            for(int j=0;j<intervals.length-i-1;j++){
                if(intervals[j][0]>intervals[j+1][0]){
                    int[][] change=new int[1][2];
                    change[0][0]=intervals[j+1][0];
                    change[0][1]=intervals[j+1][1];
                    intervals[j+1][0]=intervals[j][0];
                    intervals[j+1][1]=intervals[j][1];
                    intervals[j][0]=change[0][0];
                    intervals[j][1]=change[0][1];

                }
            }
        }
        merge(intervals);
        return intervals;
    }
}
