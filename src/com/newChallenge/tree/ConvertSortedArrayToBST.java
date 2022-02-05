package com.newChallenge.tree;

import com.zto.algorithm.TreeNode;

/**
 * @author xujun
 * @date 2022-01-25
 **/
public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        int[] arrays=new int[]{1,2,3,4,5,6};
        TreeNode node = convertToBST(arrays, 0, arrays.length - 1);
        System.out.println(node);

    }
    public static TreeNode convertToBST(int[] arrays, int start, int end){
        if(start>end){
            return null;
        }
        if(start==end){
            return new TreeNode(arrays[start]);
        }
        int middle=(start+end)/2;
        TreeNode head=new TreeNode(arrays[middle]);
        TreeNode left=convertToBST(arrays,start,middle-1);
        TreeNode right=convertToBST(arrays,middle+1,end);
        head.left=left;
        head.right=right;
        return head;
    }
}
