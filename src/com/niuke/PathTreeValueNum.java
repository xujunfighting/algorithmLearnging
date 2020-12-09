package com.niuke;

import com.zto.algorithm.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/2
 */
public class PathTreeValueNum {
    private static List<List<Integer>> lists=new ArrayList<>();
    private static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
             TreeNode n1=new TreeNode(1);
             TreeNode n2=new TreeNode(3);
             TreeNode n3=new TreeNode(4);
             TreeNode n4=new TreeNode(5);
             TreeNode n5=new TreeNode(6);
             n1.left=n2;
             n1.right=n3;
             n2.left=n5;
             n3.right=n4;
             getResult(n1,10);
             System.out.println(lists);
    }
    public static List<List<Integer>> getResult(TreeNode root,int sum){
        if(root==null){
            return lists;
        }
        if(root!=null&&root.right==null&&root.left==null){
            if(sum==root.val){
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
        }
        sum-=root.val;
        list.add(root.val);
        if(root.left!=null){
            getResult(root.left,sum);
        }
        if(root.right!=null){
            getResult(root.right, sum);
        }
        sum+=root.val;
        list.remove(list.size()-1);
        return lists;
    }
}
