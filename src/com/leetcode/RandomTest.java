package com.leetcode;

import java.util.HashSet;
import java.util.Random;

/**
 * @author xujun
 * @date 2022-01-26
 **/
public class RandomTest {
    public static void main(String[] args) {
        HashSet<Integer> results=new HashSet<>(5);
        for(int i=0;i<5;i++){
            Random random = new Random();
            int randomCount = random.nextInt(10);
            if(!results.contains(randomCount)){
                results.add(randomCount);
            }
        }
        System.out.println(results);
    }
}
