package com.leetcode;

import java.util.*;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/25
 */
public class LRU {
    public static void main(String[] args) {
       int[][] arrays=new int[][]{{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int[] result = getResult(arrays, 3);
    }
    public static  int[] getResult(int[][] arrays, int k){
        int index=0;
        List<Integer> result=new ArrayList<>();
        boolean isFind=false;
        LinkedList<Map<String,Integer>> lists=new LinkedList<>();
        int len=arrays.length;
        for(int i=0;i<len;i++){
                if(arrays[i][0]==1){//存元素
                     if(index>=k){
                         lists.removeLast();
                     }
                     Map<String, Integer> map=new HashMap<>();
                     map.put(String.valueOf(arrays[i][1]),arrays[i][2]);
                     lists.addFirst(map);
                     index++;
                }else if(arrays[i][0]==2){//取元素
                    int key=arrays[i][1];
                    isFind=false;
                     for(int v=0;v<lists.size();v++){
                         Map<String,Integer> map=lists.get(v);
                         String s = map.keySet().stream().findFirst().get();
                         if(s.trim().equals(String.valueOf(key))){
                             lists.remove(v);
                             Integer integer = map.values().stream().findFirst().get();
                             result.add(integer);//添加元素
                             lists.addFirst(map);
                             isFind=true;
                             break;
                         }
                     }
                     if(!isFind){
                         result.add(-1);
                     }
                }
        }
        int total=result.size();
        int[] objects=new int[total];
        for(int i=0;i<objects.length;i++){
            objects[i]=result.get(i);
        }
        return objects;
    }

}
