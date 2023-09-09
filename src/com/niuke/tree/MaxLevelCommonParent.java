package com.niuke.tree;

import com.zto.common.TreeNode;

/**
 * Description
 *
 * @author xujun
 * @date 2023.09.09 11:17
 */
public class MaxLevelCommonParent {

    /**
     * 计算当前树的最大深度
     */
    private static Integer maxLevel=0;
    public static void main(String[] args) {
        TreeNode l1=new TreeNode(1);
        TreeNode l2=new TreeNode(2);
        TreeNode l3=new TreeNode(3);
        TreeNode l4=new TreeNode(4);
        l1.left=l2;
        l2.right=l3;
        l2.left=l4;
        getMaxLevel(l1,1);
        TreeNode commonParent = getCommonParent(l1, 1);
        System.out.println(commonParent);
    }


    public TreeNode getResult(TreeNode root){
       return null;
    }


    /**
     * 先序遍历统计当前最大深度
     * @param root
     * @param level
     */
    public static void getMaxLevel(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level>maxLevel){
            maxLevel=level;
        }
        getMaxLevel(root.left,level+1);
        getMaxLevel(root.right,level+1);
    }


    /**
     * 先序遍历二叉树中的节点并且判断当前的深度是不是最大深度 如果是则直接返回当前节点 如果不存在直接返回为空
     * 后序遍历中判断左右子树的节点是否都存在值 如果都有则当前节点就是左右子树的公共父节点  如果无则返回左或右子树中不为空的节点
     * @param root
     * @param level
     * @return
     */
    public static TreeNode getCommonParent(TreeNode root,int level){
         if(root==null){
             return null;
         }
         if(level==maxLevel){
             return root;
         }
         TreeNode left=getCommonParent(root.left,level+1);
         TreeNode right=getCommonParent(root.right,level+1);
         if(left!=null&&right!=null){
             return root;
         }else if(left==null&&right!=null){
             return right;
         }else if(left!=null&&right==null){
             return left;
         }else{
             return null;
         }
    }
}
