package com.huawei;

import java.util.*;

public class FindnIndexAndValueSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=Integer.valueOf(scanner.nextLine());
        ArrayList<String> objects = new ArrayList<>();
        for(int i=0;i<num;i++){
            objects.add(scanner.nextLine());
        }
        getResult(objects);
    }
    public static void getResult(List<String> lists){
        Map<Integer, Integer> integerIntegerMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(String str:lists){
            String[] strs=str.split(" ");
            int key=Integer.valueOf(strs[0]);
            int val=Integer.valueOf(strs[1]);
            if(integerIntegerMap.containsKey(key)){
                int curVal=integerIntegerMap.get(key);
                integerIntegerMap.put(key,val+curVal);
            }else{
                integerIntegerMap.put(key,val);
                arrayList.add(key);
            }
        }
        arrayList.sort(Integer::compareTo);
        for(int i:arrayList){
            System.out.println(i+" "+integerIntegerMap.get(i));
        }
    }
}
