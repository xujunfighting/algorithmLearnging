package com.niuke.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupString {
    private static  int[] count=new int[26];
    public static void main(String[] args) {
       String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results=new ArrayList<>();
        if(strs.length==0){
            return results;
        }else if(strs.length==1){
            List<String> res=new ArrayList<>();
            res.add(strs[0]);
            results.add(res);
            return results;
        }
        Map<String,List<String>> listMap=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String s = calculateValue(strs[i]);
            if(!listMap.containsKey(s)){
                ArrayList<String> objects = new ArrayList<>();
                objects.add(strs[i]);
                listMap.put(s,objects);
            }else{
                List<String> strings = listMap.get(s);
                strings.add(strs[i]);
            }
        }

       results.addAll(listMap.values());
        return results;
    }

    public static String calculateValue(String string){
        for(int i=0;i<count.length;i++){
            count[i]=1;
        }
        char[] chars = string.toCharArray();
        for(int i=0;i<string.length();i++){
            count[chars[i]-'a']++;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<count.length;i++){
            sb.append(count[i]);
        }
        return sb.toString();
    }
}
