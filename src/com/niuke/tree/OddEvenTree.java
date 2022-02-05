package com.niuke.tree;

import com.zto.common.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xujun
 * @date 2021-12-25
 **/
public class OddEvenTree {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n10=new TreeNode(10);
        TreeNode n4=new TreeNode(4);
        TreeNode n3=new TreeNode(3);
        TreeNode n7=new TreeNode(7);
        TreeNode n9=new TreeNode(9);
        TreeNode n12=new TreeNode(12);
        TreeNode n8=new TreeNode(8);
        TreeNode n6=new TreeNode(6);
        TreeNode n2=new TreeNode(2);
        n1.right=n10;
        n1.right=n4;
        n10.left=n3;
        n4.left=n7;
        n4.right=n9;
        n3.left=n12;
        n3.right=n8;
        n7.left=n6;
        n9.right=n2;
        boolean oddEvenTree = isOddEvenTree(n1);
        System.out.println(oddEvenTree);

    }
    public static boolean isOddEvenTree(TreeNode root){
        if(root==null||root.value%2==0){
            return false;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        Integer cur=null;
        Integer pre=null;
        int curCount=1;
        int index=0;
        int nextCount=0;
        int level=0;
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(level%2==0&&node.value%2==0||level%2==1&&node.value%2==1) {
                return false;
            }
            if(cur==null){
                cur= node.value;
            }else{
                pre=cur;
                cur=node.value;
            }
            if(cur!=null&&pre!=null){
                if(level%2==0&&cur<pre){
                   return false;
                }
                if(level%2==1&&cur>pre){
                    return false;
                }
            }
            System.out.print(node.value);
            index++;

            if(node.left!=null){
                nextCount++;
                queue.add(node.left);
            }
            if(node.right!=null){
                nextCount++;
                queue.add(node.right);
            }
            if(index==curCount){
                level++;
                cur=null;
                pre=null;
                index=0;
                curCount=nextCount;
                nextCount=0;
                System.out.println();
            }
        }
        return true;
    }
}
