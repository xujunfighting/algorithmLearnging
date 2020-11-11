package com.huawei;

import java.util.*;

public class StaticsNumberOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        getResult(s);
    }
    public static void getResult(String strs){
        Map<Character, Integer> integerCharacterHashMap = new HashMap<Character, Integer>();
        Map<String,Character> ints=new HashMap<>();
        char[] chars=strs.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '||(chars[i]<='z'&&chars[i]>='a')||(chars[i]<='Z'&&chars[i]>='A')||((chars[i]<='9'&&chars[i]>='0'))) {
                if (integerCharacterHashMap.containsKey(chars[i])) {
                    int val = integerCharacterHashMap.get(chars[i]);
                    integerCharacterHashMap.put(chars[i], val + 1);
                } else {
                    integerCharacterHashMap.put(chars[i], 1);
                }
            }
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(integerCharacterHashMap.entrySet());


        Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if(o1.getValue()<o2.getValue())
                    return 1;
                else if(o1.getValue()==o2.getValue()){
                    return o1.getKey().compareTo(o2.getKey());
                }else{
                    return -1;
                }
            }
        });
        for(Map.Entry<Character,Integer> i:entries){
            System.out.print(i.getKey());
        }
        System.out.println();

    }
}
