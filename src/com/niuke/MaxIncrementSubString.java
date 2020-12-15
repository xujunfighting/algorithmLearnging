package com.niuke;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/17
 */
public class MaxIncrementSubString {
    public static void main(String[] args) {
       int[] res=new int[]{2,1,5,3,6,4,8,9,7,10};
       int[] result=getMaxIncrementSubString(res);
        System.out.println(result);
    }
    public static int[] getResult1(int[] res){
        int len=res.length;
        int[] index=new int[len];
        index[0]=1;
        int max=0;
        for(int i=1;i<index.length;i++){
            index[i]=1;
            for(int j=0;j<i;j++){
                if(res[j]<res[i]){
                    index[i]=index[j]+1;
                    if(max<index[i]) {
                        max = index[i];
                    }
                }
            }
        }
        int p=0;
        int q=0;
        int[] result=new int[max];
        for(int i=0;i<result.length;i++){
            p++;
            int val= Integer.MAX_VALUE;
            for(int j=0;j<index.length;j++){
               if(index[j]==p&&res[j]<val){
                   val=res[j];
               }
            }
            result[q++]=val;
        }
      return result;
    }

    public static int[] getResult2(int[] res){

         LinkedHashMap<Integer,Integer> maps=new LinkedHashMap<>(10,0.75f,true);
         int[] index=new int[res.length];
         int start=res[0];
         int startIndex=1;
         index[0]=1;
         for(int i=1;i<res.length;i++){
             if(res[i]<start){
                 //后继数据小于前继的数据
                 if(!maps.isEmpty()&&maps.get(startIndex-1)!=null&&maps.get(startIndex-1)>res[i]){
                     continue;
                 }
                 start=res[i];
                 index[i]=startIndex;
             }else{ //后继数据大于前继数据
                 maps.put(startIndex, start);
                 start=res[i];
                 startIndex++;
                 index[i]=startIndex;
             }
         }
         maps.put(startIndex,start);
         int[] result=new int[new Long(maps.values().stream().count()).intValue()];
         int i=0;
         for(Map.Entry<Integer,Integer> value:maps.entrySet()){
             result[i++]=value.getValue();
         }
         return result;
    }
    public static int[] getMaxIncrementSubString(int[] test){
         List<Integer> lists=new ArrayList<>();

         int[] result=new int[10];
         int startValue=test[0];
         lists.add(startValue);
         for(int i=1;i<test.length;i++){
             if(lists.get(lists.size()-1)<test[i]){//当前元素大于前继元素
                 lists.add(test[i]);
             }else{//当前元素小于前继元素
               if(!lists.isEmpty()) {
                   lists.remove(lists.size() - 1);//移除最后一个元素
               }
               startValue=test[i];
               lists.add(startValue);
             }
         }
         return result;
    }
}
