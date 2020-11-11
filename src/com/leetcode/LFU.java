package com.leetcode;

import java.util.*;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/25
 */
public class LFU {
    public static void main(String[] args) {
      int[][] nums=new int[][]{{1,1,1},{1,2,2},{1,3,2},{1,2,4},{1,3,5},{2,2},{1,4,4},{2,1}};
        int[] result = getResult(nums, 3);
        System.out.println(result);
    }
    public static int[] getResult(int[][] arrays,int k) {
        boolean isFind = false;
        List<Integer> result = new ArrayList<>();
        LinkedList<Map<String, Integer>> lists = new LinkedList<>();
        //存储调用频次
        Map<String, Integer> usedFrequency = new HashMap<>();
        int len = arrays.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (arrays[i][0] == 1) {//存元素
                Map<String, Integer> map = new HashMap<>();
                map.put(String.valueOf(arrays[i][1]), arrays[i][2]);
                lists.addFirst(map);
                    List<String> strings = mapMethod(usedFrequency, String.valueOf(arrays[i][1]), k);
                    if (strings.size() != 0) {//有元素需要删除
                        for (int v = lists.size() - 1; v >= 0; v--) {
                            Map.Entry<String, Integer> stringIntegerEntry = lists.get(v).entrySet().stream().findFirst().get();
                            String key = stringIntegerEntry.getKey();
                            if (strings.contains(key)) {
                                lists.remove(v);
                                break;
                            }
                        }
                    }
                index++;
            } else if (arrays[i][0] == 2) {//取元素
                int key = arrays[i][1];
                isFind = false;
                for (int v = 0; v < lists.size(); v++) {
                    Map<String, Integer> map = lists.get(v);
                    String s = map.keySet().stream().findFirst().get();
                    if (s.trim().equals(String.valueOf(key))) {
                        lists.remove(v);
                        Integer integer = map.values().stream().findFirst().get();
                        result.add(integer);//添加元素
                        lists.addFirst(map);
                        isFind = true;
                        break;

                    }
                }
                if (!isFind) {
                    result.add(-1);
                }
            }

        }
        int total=result.size();
        int[] objects=new int[total];
        for(int t=0;t<objects.length;t++){
            objects[t]=result.get(t);
        }
        return objects;
    }

    public static List<String> mapMethod(Map<String,Integer> maps,String key,int k){
        List<String> minKeys=new ArrayList<>();
        int minValue=Integer.MAX_VALUE;
        if(maps.containsKey(key)){
            Integer integer = maps.get(key);
            maps.put(key,integer+1);
            minKeys.add(key);
        }else{
            maps.put(key,1);
        }
        if(maps.size()>k){
            for(Map.Entry<String,Integer> map:maps.entrySet()){
                Integer value=map.getValue();
                if(value<minValue){
                    minValue=value;
                }
            }
            for(Map.Entry<String,Integer> map:maps.entrySet()){
                String mapKey=map.getKey();
                Integer mapValue=map.getValue();
                if(mapValue==minValue){
                    minKeys.add(mapKey);
                }
            }
        }
        return minKeys;
    }
}
