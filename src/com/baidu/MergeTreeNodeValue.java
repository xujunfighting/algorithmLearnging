package com.baidu;

import com.zto.algorithm.TreeNode;


/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/12
 */
public class MergeTreeNodeValue {
    public static void main(String[] args) {
         TreeNode treeNode11=new TreeNode(1);
        TreeNode treeNode12=new TreeNode(10);
        TreeNode treeNode13=new TreeNode(8);
        TreeNode treeNode14=new TreeNode(1);
        TreeNode treeNode15=new TreeNode(3);
        treeNode11.left=treeNode12;
        treeNode11.right=treeNode13;
        treeNode12.left=null;
        treeNode12.right=treeNode14;
        treeNode14.left=treeNode15;



         TreeNode treeNode21=new TreeNode(9);
         TreeNode treeNode22=new TreeNode(4);
         TreeNode treeNode23=new TreeNode(2);
         TreeNode treeNode24=new TreeNode(4);
         TreeNode treeNode25=new TreeNode(9);
         treeNode21.left=treeNode22;
         treeNode21.right=treeNode23;
         treeNode22.right=treeNode24;
         treeNode23.left=treeNode25;
         TreeNode node=mergeTreeNode(treeNode11,treeNode21);
         System.out.println(node);
    }
    public static TreeNode mergeTreeNode(TreeNode n1,TreeNode n2){
        if(n1==null&&n2==null){
            return null;
        }
        TreeNode node=new TreeNode(1);
        if(n1!=null&&n2!=null) {
            node.val=n1.val+n2.val;
        }else if(n1!=null&&n2==null){
            node.val=n1.val;
        }else if(n1==null&&n2!=null){
            node.val=n2.val;
        }
        TreeNode left=null;
        TreeNode right=null;
        if(n1!=null&&n2!=null) {
             left = mergeTreeNode(n1.left, n2.left);
             right = mergeTreeNode(n1.right,n2.right);
        }else if(n1==null&&n2!=null){
             left = mergeTreeNode(null,n2.left);
            right = mergeTreeNode(null,n2.right);
        }else if(n1!=null&&n2==null){
            left = mergeTreeNode(n1.left,null);
            right = mergeTreeNode(n1.right,null);
        }

        node.left=left;
        node.right=right;
        return node;

    }
}
