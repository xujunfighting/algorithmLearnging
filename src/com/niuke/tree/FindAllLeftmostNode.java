package com.niuke.tree;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllLeftmostNode {
    //数组的index表示数组的深度
    static List<Integer> results=new ArrayList<>(200);
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
        n1.left=n2;
        n2.left=n3;
        n1.right=n4;
        n4.right=n5;
        n5.right=n6;
        n6.left=n7;
        n6.right=n8;
        n8.left=n9;
        for(int i=0;i<200;i++){
            results.add(0);
        }
        getResult(n1,0);
        System.out.println(results);
    }

    public static void getResult(TreeNode node,int depth){
        if(node==null){
            return;
        }
        getResult(node.left, depth + 1);
        /**
         * 中序遍历元素 是从左往右遍历的 对当前元素判断是否是0 如果是0表明是默认值 则替换掉 如果不是表明该层次已经在之前的左子树已经添加过了 不需要再次添加
         *
         */
        if(node!=null) {
            if (results.get(depth) == 0) {
                results.set(depth, node.val);
            }
        }
        getResult(node.right, depth + 1);
    }
}
