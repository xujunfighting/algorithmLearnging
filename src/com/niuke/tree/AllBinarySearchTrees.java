package com.niuke.tree;

import com.zto.algorithm.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/21
 **/
public class AllBinarySearchTrees {

    static List<TreeNode> results=new ArrayList<>();
    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        System.out.println(treeNodes);

    }
    public static List<TreeNode> generateTrees(int n) {
        if(n==1){
            results.add(new TreeNode(1));
            return results;
        }
        getResult(1, n,0);
        return results;
    }
    public static List<TreeNode> getResult(int start,int end,int level){
        /**
         * 一个二叉排序树  节点需要保证 左边的所有节点都小于根节点 右边的节点都大于根节点
         * 左边的节点构造情况和右边的构造情况的乘积就是以当前节点作为根节点的所有的组合
         */
        if(start>end||end<start){
            return null;
        }
        if(start==end){
            List<TreeNode> lists=new ArrayList<>();
            lists.add(new TreeNode(start));
            return lists;
        }
        /**
         * lists保存左右子树中间结果集合
         */
        List<TreeNode> lists=new ArrayList<>();
        for(int i=start;i<=end;i++){
            TreeNode node=new TreeNode(i);
            List<TreeNode> left=getResult(start,i-1,level+1);
            List<TreeNode> right=getResult(i+1,end,level+1);
            if(left==null){
                left=new ArrayList<>();
            }
            if(right==null){
                right=new ArrayList<>();
            }
            buildTreeWithLeftAndRight(node,left,right,lists);
            if(level==0){
                results.addAll(lists);
                lists.clear();
            }
        }
        return lists;
    }
    public static List<TreeNode> buildTreeWithLeftAndRight(TreeNode node,List<TreeNode> left,List<TreeNode> right,List<TreeNode> lists){
        if(left.size()==0&&right.size()==0){
            return lists;
        }else if(left.size()==0&&right.size()!=0){
            TreeNode l=null;
            for(TreeNode r:right){
                TreeNode temp=new TreeNode(node.val);
                temp.left=l;
                temp.right=r;
                lists.add(temp);
            }
        }else if(right.size()==0&&left.size()!=0){
            TreeNode r=null;
            for(TreeNode l:left){
                TreeNode temp=new TreeNode(node.val);
                temp.left=l;
                temp.right=r;
                lists.add(temp);
            }
        }else if(right.size()!=0&&left.size()!=0) {
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode temp=new TreeNode(node.val);
                    temp.left = l;
                    temp.right = r;
                    lists.add(temp);
                }
            }
        }
        return lists;
    }
}
