package com.niuke;

import com.zto.algorithm.TreeNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/2/23
 */
public class FindBiggestSubBST {
    private static int[] store=new int[3];
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(7);
        TreeNode n3=new TreeNode(12);
        TreeNode n4=new TreeNode(8);
        TreeNode n5=new TreeNode(9);
        TreeNode n6=new TreeNode(2);
        TreeNode n7=new TreeNode(10);
        TreeNode n8=new TreeNode(11);
        TreeNode n9=new TreeNode(18);
        TreeNode n10=new TreeNode(17);
         n1.left=n2;
         n1.right=n3;
         n2.left=n4;
         n2.right=n5;
         n5.left=n6;
         n5.right=n7;
         n3.left=n8;
         n3.right=n9;
         n9.left=n10;
        TreeNode node=getResult(n1);
        System.out.println(node);
    }
    public static TreeNode getResult(TreeNode root){
        //节点为空时直接返回空 并设置当前节点数为0
        if(root==null){
            store[0]=0;
            return null;
        }
        // 节点为叶子节点的时候直接返回当前节点
        // 最大最小值都为当前叶子节点的值
         if(root.left==null&&root.right==null){
             store[0]=1;
             store[1]=root.val;
             store[2]=root.val;
             return root;
         }
         TreeNode left=getResult(root.left);
             int lsize = store[0];
             int lmax = store[1];
             int lmin = store[2];
         TreeNode right=getResult(root.right);
            System.out.println(root.val);
            int rsize = store[0];
            int rmax = store[1];
            int rmin = store[2];
        if(root.right==right&&root.left==left&&(left!=null&&root.val>=lmax||left==null)&&(right!=null&&root.val<=rmin||right==null)){
            store[0]=rsize+lsize+1;
            store[1]=lmax;
            store[2]=rmin;
            if(left==null){
                store[1]=root.val;
            }
            if(right==null){
                store[2]=root.val;
            }
            return root;
        }else{
            //左子树节点多
            if(lsize>rsize){
                store[0]=lsize;
                store[1]=lmax;
                store[2]=lmin;
                return left;
            }else{
                store[0]=rsize;
                store[1]=rmax;
                store[2]=rmin;
                return right;
            }
        }
    }
}
