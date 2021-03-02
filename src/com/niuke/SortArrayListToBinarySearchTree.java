package com.niuke;

import com.zto.algorithm.TreeNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/2/24
 */
public class SortArrayListToBinarySearchTree {
    public static void main(String[] args) {
        int[] array=new int[]{1,2,3,4,5,6,7,8};
        TreeNode root=getBST(array,0,array.length-1);
        System.out.println(root);
    }
    public static TreeNode getBST(int[] array,int start,int end){
        if(start>end) return null;
        int middle=(start+end)/2;
        TreeNode root=new TreeNode(array[middle]);
        TreeNode left=getBST(array,start,middle-1);
        TreeNode right=getBST(array,middle+1,end);
        root.left=left;
        root.right=right;
        return root;
    }
}
