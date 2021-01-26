package com.niuke;

import com.zto.algorithm.TreeNode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/25
 */
public class ZorderTree {
    private static ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
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
//        n1.right=n3;
//        n2.left=n4;
//        n2.right=n5;
//        n3.left=n6;
//        n3.right=n7;
//        n4.left=n8;
//        n4.right=n9;
        getZOrder(n1);
        System.out.println(lists);
    }
    public  static  ArrayList<ArrayList<Integer>> getZOrder(TreeNode root){
        if(root==null){
            return lists;
        }
        Queue<TreeNode> queue=new ArrayBlockingQueue<>(100);
        queue.add(root);
        int cur=1;
        int next=0;
        int index=0;
        int flag=0;
        ArrayList<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.println(node.val);
            list.add(node.val);
            index++;
                if(node.left!=null){
                    queue.add(node.left);
                    next++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    next++;
                }
            if(index==cur){
                cur=next;
                index=0;
                next=0;
                if(flag%2==1){
                    Collections.reverse(list);
                }
                lists.add(new ArrayList<>(list));
                flag++;
                list=new ArrayList<>();
            }
        }
        return lists;
    }
}
