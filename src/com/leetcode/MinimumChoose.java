package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujun
 * @date 2022-02-07
 **/
public class MinimumChoose {
    private static int count = Integer.MAX_VALUE;
    private static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        int[] res = new int[]{3, 2, 1, 1};
        getResult(res, 9);
        System.out.println(count);
    }

    public static List<Integer> getResult(int[] res, int target) {
        if (target < 0) {
            return results;
        }
        if (target == 0) {
            count = results.size();
            return results;
        }
        for (int i = 0; i < res.length; i++) {
            target -= res[i];
            results.add(res[i]);
            getResult(res, target);
            if(count!=Integer.MAX_VALUE){
                return results;
            }
            results.remove(results.size() - 1);
            target += res[i];
        }
        return results;
    }
}
