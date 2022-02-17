package com.niuke.array;

/**
 * @author xujun
 * @date 2022-02-16
 **/
public class FindTargetStartAndEndIndex {
    public static Integer startIndex = null;
    public static Integer endIndex = null;

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7};
        getResult(arrays,3,0,arrays.length-1);
        System.out.println(startIndex);
        System.out.println(endIndex);
    }

    public static void getResult(int[] arrays, int target, int start, int end) {

        while (start < end) {
            int middle = (start + end) / 2;
            if (arrays[middle] == target) {
                startIndex = getStart(arrays, start, middle,target);
                endIndex = getEnd(arrays, middle + 1, end,target);
                return;
            } else if (arrays[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
    }

    public static Integer getStart(int[] arrays, int start, int end, int target) {
        if (start + 1 < arrays.length && arrays[start + 1] == target && arrays[start] < target) {
            return start + 1;
        }
        if (start >= end) {
            return null;
        }
        int middle = (start + end) / 2;
        Integer left = getStart(arrays, start, middle, target);
        Integer right = getStart(arrays, middle + 1, end, target);
        if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return null;
        }
    }


    public static Integer getEnd(int[] arrays, int start, int end, int target) {
        if (end > 0 && end < arrays.length - 1 && arrays[end - 1] == target && arrays[end] > target) {
            return end - 1;
        }
        if (start >= end) {
            return null;
        }
        int middle = (start + end) / 2;
        Integer left = getEnd(arrays, start, middle, target);
        Integer right = getEnd(arrays, middle + 1, end, target);
        if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return null;
        }
    }
}
