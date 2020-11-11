package com.newChallenge.tree;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/6
 */
public class SumValuePathTree {
    private static List<List<Integer>> lists=new ArrayList<>();
    private static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node4.left=null;
        node4.right=null;
        node5.left=null;
        node5.right=null;
        node6.left=null;
        node6.right=null;
        node7.left=null;
        node7.right=null;
        getSumValuePath(node1,7);
        System.out.println(lists);
    }
    public static void getSumValuePath(TreeNode treeNode,int sum){
        if(treeNode==null||sum<=0){
            return;
        }
        if(treeNode.right==null&&treeNode.left==null){
            if(sum==treeNode.getVal()){
                list.add(treeNode.getVal());
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }
        }
        sum-=treeNode.getVal();
        list.add(treeNode.getVal());
        getSumValuePath(treeNode.left,sum);
        getSumValuePath(treeNode.right,sum);
        sum+=treeNode.getVal();
        list.remove(list.size()-1);
    }
}
