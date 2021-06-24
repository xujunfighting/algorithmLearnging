package com.niuke;

import com.zto.algorithm.TreeNode;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/6/23
 **/
public class GetLongestZigPath {
     private static int[] tag=new int[2];
     private static int result=0;
     //[1,  1,1,     null,1,null,null,     1,1,null,1]
    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);
        TreeNode n8=new TreeNode(8);
        TreeNode n9=new TreeNode(9);
//        n1.right=n2;
//        n2.left=n3;
//        n2.right=n4;
//        n4.left=n5;
//        n4.right=n6;
//        n5.right=n7;
//        n7.right=n8;
//        n8.right=n9;

        n1.left=n2;
        n1.right=n3;
        n2.right=n4;
        n4.left=n5;
        n4.right=n6;
        n5.left=n7;
         int[] root = getResult(n1);
        System.out.println(result);
    }
    public static int[] getResult(TreeNode node){
        if(node==null){
            int[] tag=new int[2];
            tag[0]=0;
            tag[1]=0;
            return tag;
        }
        int[] left=getResult(node.left);
        int[] right=getResult(node.right);
        int[] tag=new int[2];
        System.out.println(node.val);

        if(node.right!=null&&node.left!=null) {
            tag[0] = left[1]+1;
            tag[1] = right[0]+1;
        }else if(node.right!=null&&node.left==null){
            tag[0]=0;
            tag[1]=right[0]+1;
        }else if(node.right==null&&node.left!=null){
            tag[0]=left[1]+1;
            tag[1]=0;
        }
        /**
         * 记录每次遍历出结果的最大值
         */
        result=Math.max(tag[0],tag[1])+1>result?Math.max(tag[0],tag[1]):result;
        return tag;
    }
}
